package mathax.client.systems.modules.render;

import mathax.client.eventbus.EventHandler;
import mathax.client.eventbus.EventPriority;
import mathax.client.events.entity.DamageEvent;
import mathax.client.events.game.GameLeftEvent;
import mathax.client.events.game.OpenScreenEvent;
import mathax.client.events.mathax.KeyEvent;
import mathax.client.events.mathax.MouseScrollEvent;
import mathax.client.events.world.ChunkOcclusionEvent;
import mathax.client.events.world.TickEvent;
import mathax.client.settings.BoolSetting;
import mathax.client.settings.DoubleSetting;
import mathax.client.settings.Setting;
import mathax.client.settings.SettingGroup;
import mathax.client.systems.modules.Categories;
import mathax.client.systems.modules.Module;
import mathax.client.systems.modules.Modules;
import mathax.client.systems.modules.movement.GUIMove;
import mathax.client.utils.misc.Vec3;
import mathax.client.utils.misc.input.Input;
import mathax.client.utils.misc.input.KeyAction;
import mathax.client.utils.player.Rotations;
import net.minecraft.client.option.Perspective;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class Freecam extends Module {

	private PlayerCopyEntity dummy;
	private double[] playerPos;
	private float[] playerRot;
	private Entity riding;

	private boolean prevFlying;
	private float prevFlySpeed;

	public Freecam() {
		super("Freecam", KEY_UNBOUND, ModuleCategory.PLAYER, "Its freecam, you know what it does.",
				new SettingSlider("Speed", 0, 3, 0.5, 2).withDesc("Moving speed in freecam."),
				new SettingToggle("HorseInv", true).withDesc("Opens your Horse inventory when riding a horse."));
	}

	@Override
	public void onEnable(boolean inWorld) {
		if (!inWorld)
			return;

		super.onEnable(inWorld);

		mc.chunkCullingEnabled = false;

		playerPos = new double[] { mc.player.getX(), mc.player.getY(), mc.player.getZ() };
		playerRot = new float[] { mc.player.getYaw(), mc.player.getPitch() };

		dummy = new PlayerCopyEntity(mc.player);

		dummy.spawn();

		if (mc.player.getVehicle() != null) {
			riding = mc.player.getVehicle();
			mc.player.getVehicle().removeAllPassengers();
		}

		if (mc.player.isSprinting()) {
			mc.player.networkHandler.sendPacket(new ClientCommandC2SPacket(mc.player, Mode.STOP_SPRINTING));
		}

		prevFlying = mc.player.getAbilities().flying;
		prevFlySpeed = mc.player.getAbilities().getFlySpeed();
	}

	@Override
	public void onDisable(boolean inWorld) {
		if (inWorld) {
			mc.chunkCullingEnabled = true;

			dummy.despawn();
			mc.player.noClip = false;
			mc.player.getAbilities().flying = prevFlying;
			mc.player.getAbilities().setFlySpeed(prevFlySpeed);

			mc.player.refreshPositionAndAngles(playerPos[0], playerPos[1], playerPos[2], playerRot[0], playerRot[1]);
			mc.player.setVelocity(Vec3d.ZERO);

			if (riding != null && mc.world.getEntityById(riding.getId()) != null) {
				mc.player.startRiding(riding);
			}
		}

		super.onDisable(inWorld);
	}

	@BleachSubscribe
	public void sendPacket(EventPacket.Send event) {
		if (event.getPacket() instanceof ClientCommandC2SPacket || event.getPacket() instanceof PlayerMoveC2SPacket) {
			event.setCancelled(true);
		}
	}

	@BleachSubscribe
	public void onOpenScreen(EventOpenScreen event) {
		if (getSetting(1).asToggle().getState() && riding instanceof AbstractHorseEntity) {
			if (event.getScreen() instanceof InventoryScreen) {
				mc.player.networkHandler.sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.OPEN_INVENTORY));
				event.setCancelled(true);
			}
		}
	}

	@BleachSubscribe
	public void onClientMove(EventClientMove event) {
		mc.player.noClip = true;
	}

	@BleachSubscribe
	public void onTick(EventTick event) {
		mc.player.setOnGround(false);
		mc.player.getAbilities().setFlySpeed((float) (getSetting(0).asSlider().getValue() / 5));
		mc.player.getAbilities().flying = true;
		mc.player.setPose(EntityPose.STANDING);
	}
}
