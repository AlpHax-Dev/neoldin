package mathax.client.systems.modules.movement;

import baritone.api.BaritoneAPI;
import mathax.client.eventbus.EventHandler;
import mathax.client.events.entity.player.PlayerMoveEvent;
import mathax.client.events.packets.PacketEvent;
import mathax.client.events.world.TickEvent;
import mathax.client.mixin.PlayerMoveC2SPacketAccessor;
import mathax.client.mixin.PlayerPositionLookS2CPacketAccessor;
import mathax.client.mixininterface.IPlayerMoveC2SPacket;
import mathax.client.mixininterface.IVec3d;
import mathax.client.settings.*;
import mathax.client.systems.modules.Categories;
import mathax.client.systems.modules.Module;
import mathax.client.systems.modules.Modules;
import mathax.client.utils.entity.EntityUtils;
import mathax.client.utils.player.FindItemResult;
import mathax.client.utils.player.InvUtils;
import mathax.client.utils.player.PlayerUtils;
import mathax.client.utils.player.Rotations;
import mathax.client.utils.world.BlockUtils;
import mathax.client.utils.world.Dimension;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.RaycastContext;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

// DOGSHİT++

public class Nofall extends Module {

	public Nofall() {
		super("Nofall", KEY_UNBOUND, ModuleCategory.PLAYER, "Prevents you from taking fall damage.",
				new SettingMode("Mode", "Simple", "Packet").withDesc("What Nofall mode to use."));
	}

	@BleachSubscribe
	public void onTick(EventTick event) {
		if (mc.player.fallDistance > 2.5f && getSetting(0).asMode().getMode() == 0) {
			if (mc.player.isFallFlying())
				return;
			mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
		}

		if (mc.player.fallDistance > 2.5f && getSetting(0).asMode().getMode() == 1 &&
				mc.world.getBlockState(mc.player.getBlockPos().add(
						0, -1.5 + (mc.player.getVelocity().y * 0.1), 0)).getBlock() != Blocks.AIR) {
			mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(false));
			mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(
					mc.player.getX(), mc.player.getY() - 420.69, mc.player.getZ(), true));
			mc.player.fallDistance = 0;
		}
	}
}
