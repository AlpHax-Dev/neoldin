package mathax.client.systems.modules.movement;

import baritone.api.BaritoneAPI;
import com.google.common.collect.Streams;
import mathax.client.eventbus.EventHandler;
import mathax.client.events.entity.player.CanWalkOnFluidEvent;
import mathax.client.events.packets.PacketEvent;
import mathax.client.events.world.CollisionShapeEvent;
import mathax.client.events.world.TickEvent;
import mathax.client.mixin.LivingEntityAccessor;
import mathax.client.mixininterface.IVec3d;
import mathax.client.settings.*;
import mathax.client.systems.modules.Categories;
import mathax.client.systems.modules.Module;
import mathax.client.utils.entity.EntityUtils;
import net.minecraft.block.Material;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.GameMode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Jesus extends Module {

	public Jesus() {
		super("Jesus", KEY_UNBOUND, ModuleCategory.PLAYER, "Allows you to walk on water.",
				new SettingMode("Mode", "Vibrate", "Solid").withDesc("The jesus mode."));
	}

	@BleachSubscribe
	public void onTick(EventTick event) {
		Entity e = mc.player.getRootVehicle();

		if (e.isSneaking() || e.fallDistance > 3f)
			return;

		if (isSubmerged(e.getPos().add(0, 0.3, 0))) {
			e.setVelocity(e.getVelocity().x, 0.08, e.getVelocity().z);
		} else if (isSubmerged(e.getPos().add(0, 0.1, 0))) {
			e.setVelocity(e.getVelocity().x, 0.05, e.getVelocity().z);
		} else if (isSubmerged(e.getPos().add(0, 0.05, 0))) {
			e.setVelocity(e.getVelocity().x, 0.01, e.getVelocity().z);
		} else if (isSubmerged(e.getPos())) {
			e.setVelocity(e.getVelocity().x, -0.005, e.getVelocity().z);
			e.setOnGround(true);
		}
	}

	@BleachSubscribe
	public void onBlockShape(EventBlockShape event) {
		if (getSetting(0).asMode().getMode() == 1
				&& !mc.world.getFluidState(event.getPos()).isEmpty()
				&& !mc.player.isSneaking()
				&& !mc.player.isTouchingWater()
				&& mc.player.getY() >= event.getPos().getY() + 0.9) {
			event.setShape(VoxelShapes.cuboid(0, 0, 0, 1, 0.9, 1));
		}
	}

	private boolean isSubmerged(Vec3d pos) {
		BlockPos bp = new BlockPos(pos);
		FluidState state = mc.world.getFluidState(bp);

		return !state.isEmpty() && pos.y - bp.getY() <= state.getHeight();
	}
}
