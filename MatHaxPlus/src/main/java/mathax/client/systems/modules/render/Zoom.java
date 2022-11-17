package mathax.client.systems.modules.render;

import mathax.client.MatHax;
import mathax.client.eventbus.EventHandler;
import mathax.client.events.mathax.MouseScrollEvent;
import mathax.client.events.render.GetFovEvent;
import mathax.client.events.render.Render3DEvent;
import mathax.client.events.world.TickEvent;
import mathax.client.settings.BoolSetting;
import mathax.client.settings.DoubleSetting;
import mathax.client.settings.Setting;
import mathax.client.settings.SettingGroup;
import mathax.client.systems.modules.Categories;
import mathax.client.systems.modules.Module;
import mathax.client.utils.Utils;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;

public class Zoom extends Module {

	public int prevFov;
	public double prevSens;

	public Zoom() {
		super("Zoom", KEY_UNBOUND, ModuleCategory.RENDER, "Zooming to your life",
				new SettingSlider("Scale", 1, 10, 3, 2).withDesc("How much to zoom."));
	}

	@Override
	public void onEnable(boolean inWorld) {
		super.onEnable(inWorld);

		prevFov = mc.options.getFov().getValue();
		prevSens = mc.options.getMouseSensitivity().getValue();

		mc.options.getFov().setValue((int) (prevFov / getSetting(0).asSlider().getValue()));
		mc.options.getMouseSensitivity().setValue(prevSens / getSetting(0).asSlider().getValue());
	}

	@Override
	public void onDisable(boolean inWorld) {
		mc.options.getFov().setValue(prevFov);
		mc.options.getMouseSensitivity().setValue(prevSens);

		super.onDisable(inWorld);
	}
}
