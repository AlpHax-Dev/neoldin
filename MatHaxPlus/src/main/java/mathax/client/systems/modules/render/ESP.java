package mathax.client.systems.modules.render;

import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import mathax.client.MatHax;
import mathax.client.eventbus.EventHandler;
import mathax.client.events.render.Render2DEvent;
import mathax.client.events.render.Render3DEvent;
import mathax.client.renderer.Renderer2D;
import mathax.client.renderer.ShapeMode;
import mathax.client.settings.*;
import mathax.client.systems.enemies.Enemies;
import mathax.client.systems.friends.Friends;
import mathax.client.systems.modules.Categories;
import mathax.client.systems.modules.Module;
import mathax.client.systems.modules.Modules;
import mathax.client.utils.entity.EntityUtils;
import mathax.client.utils.misc.Vec3;
import mathax.client.utils.player.PlayerUtils;
import mathax.client.utils.render.NametagUtils;
import mathax.client.utils.render.WireframeEntityRenderer;
import mathax.client.utils.render.color.Color;
import mathax.client.utils.render.color.SettingColor;
import net.minecraft.client.option.Perspective;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;

ppublic class ESP extends Module {

	private ShaderEffectWrapper shader;
	private ColorVertexConsumerProvider colorVertexer;

	public ESP() {
		super("ESP", KEY_UNBOUND, ModuleCategory.RENDER, "Highlights Entities in the world.",
				new SettingMode("Render", "Shader", "Box").withDesc("The Render mode."),
				new SettingSlider("ShaderFill", 1, 255, 50, 0).withDesc("How opaque the fill on shader mode should be."),
				new SettingSlider("Box", 0, 5, 2, 1).withDesc("How thick the box outline should be."),
				new SettingSlider("BoxFill", 0, 255, 50, 0).withDesc("How opaque the fill on box mode should be."),

				new SettingToggle("Players", true).withDesc("Highlights Players.").withChildren(
						new SettingColor("Player Color", 255, 75, 75).withDesc("Outline color for players."),
						new SettingColor("Friend Color", 0, 255, 255).withDesc("Outline color for friends.")),

				new SettingToggle("Mobs", false).withDesc("Highlights Mobs.").withChildren(
						new SettingColor("Color", 128, 25, 128).withDesc("Outline color for mobs.")),

				new SettingToggle("Animals", false).withDesc("Highlights Animals").withChildren(
						new SettingColor("Color", 75, 255, 75).withDesc("Outline color for animals.")),

				new SettingToggle("Items", true).withDesc("Highlights Items.").withChildren(
						new SettingColor("Color", 255, 200, 50).withDesc("Outline color for items.")),

				new SettingToggle("Crystals", true).withDesc("Highlights End Crystals.").withChildren(
						new SettingColor("Color", 255, 50, 255).withDesc("Outline color for crystals.")),

				new SettingToggle("Vehicles", false).withDesc("Highlights Vehicles.").withChildren(
						new SettingColor("Color", 150, 150, 150).withDesc("Outline color for vehicles (minecarts/boats).")),

				new SettingToggle("Armorstands", false).withDesc("Highlights armor stands.").withChildren(
						new SettingColor("Color", 160, 150, 50).withDesc("Outline color for armor stands.")));

		try {
			shader = new ShaderEffectWrapper(
					ShaderLoader.loadEffect(mc.getFramebuffer(), new Identifier("bleachhack", "shaders/post/entity_outline.json")));

			colorVertexer = new ColorVertexConsumerProvider(shader.getFramebuffer("main"), BleachCoreShaders::getColorOverlayShader);
		} catch (JsonSyntaxException | IOException e) {
			throw new RuntimeException("Failed to initialize ESP Shader! loaded too early?", e);
		}
	}

	@BleachSubscribe
	public void onWorldRender(EventWorldRender.Pre event) {
		shader.prepare();
		shader.clearFramebuffer("main");
	}

	@BleachSubscribe
	public void onEntityRender(EventEntityRender.Single.Pre event) {
		if (getSetting(0).asMode().getMode() != 0)
			return;

		int[] color = getColor(event.getEntity());

		if (color != null) {
			event.setVertex(colorVertexer.createDualProvider(event.getVertex(), color[0], color[1], color[2], getSetting(1).asSlider().getValueInt()));
		}
	}

	@BleachSubscribe
	public void onWorldRender(EventWorldRender.Post event) {
		if (getSetting(0).asMode().getMode() == 0) {
			colorVertexer.draw();
			shader.render();
			shader.drawFramebufferToMain("main");
		} else {
			float width = getSetting(2).asSlider().getValueFloat();
			int fill = getSetting(3).asSlider().getValueInt();

			for (Entity e: mc.world.getEntities()) {
				int[] color = getColor(e);

				if (color != null) {
					if (width != 0)
						Renderer.drawBoxOutline(e.getBoundingBox(), QuadColor.single(color[0], color[1], color[2], 255), width);

					if (fill != 0)
						Renderer.drawBoxFill(e.getBoundingBox(), QuadColor.single(color[0], color[1], color[2], fill));
				}
			}
		}
	}

	private int[] getColor(Entity e) {
		if (e == mc.player)
			return null;

		if (e instanceof PlayerEntity && getSetting(4).asToggle().getState()) {
			return getSetting(4).asToggle().getChild(BleachHack.friendMang.has(e) ? 1 : 0).asColor().getRGBArray();
		} else if (e instanceof Monster && getSetting(5).asToggle().getState()) {
			return getSetting(5).asToggle().getChild(0).asColor().getRGBArray();
		} else if (EntityUtils.isAnimal(e) && getSetting(6).asToggle().getState()) {
			return getSetting(6).asToggle().getChild(0).asColor().getRGBArray();
		} else if (e instanceof ItemEntity && getSetting(7).asToggle().getState()) {
			return getSetting(7).asToggle().getChild(0).asColor().getRGBArray();
		} else if (e instanceof EndCrystalEntity && getSetting(8).asToggle().getState()) {
			return getSetting(8).asToggle().getChild(0).asColor().getRGBArray();
		} else if ((e instanceof BoatEntity || e instanceof AbstractMinecartEntity) && getSetting(9).asToggle().getState()) {
			return getSetting(9).asToggle().getChild(0).asColor().getRGBArray();
		} else if (e instanceof ArmorStandEntity && getSetting(10).asToggle().getState()) {
			return getSetting(10).asToggle().getChild(0).asColor().getRGBArray();
		}

		return null;
	}
}
