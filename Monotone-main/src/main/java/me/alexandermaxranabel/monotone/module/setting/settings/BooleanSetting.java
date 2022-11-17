package me.alexandermaxranabel.monotone.module.setting.settings;

import me.alexandermaxranabel.monotone.Monotone;
import me.alexandermaxranabel.monotone.module.Module;
import me.alexandermaxranabel.monotone.module.setting.Setting;

/** the only value you need to worry about is the default value, it can either be true or false.
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public class BooleanSetting extends Setting {
	public boolean enabled;

	public BooleanSetting(String name, Module parent, boolean enabled) {
		this.name = name;
		this.parent = parent;
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;

		if(Monotone.INSTANCE.save != null) {
			try {
				Monotone.INSTANCE.save.saveSettings();
			} catch (Exception e) {}
		}
	}

	public void toggle() {
		setEnabled(!enabled);
	}
}
