package me.alexandermaxranabel.monotone;

import me.srgantmoomoo.bedroom.saveload.Load;
import me.alexandermaxranabel.monotone.saveload.Save;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.alexandermaxranabel.monotone.command.Command;
import me.alexandermaxranabel.monotone.command.CommandManager;
import me.alexandermaxranabel.monotone.module.Module;
import me.alexandermaxranabel.monotone.module.ModuleManager;
import me.alexandermaxranabel.monotone.module.setting.SettingManager;

/**
 * @author SrgantMooMoo
 * @since 5/16/2021
 */

public final class Monotone {
	public static Monotone INSTANCE;

	public Monotone() {
		INSTANCE = this;
	}

	public ModuleManager moduleManager;
	public SettingManager settingManager;
	public CommandManager commandManager;
	public Save save;
	public Load load;

	public static final Logger LOGGER = LogManager.getLogger("monotone");

	public static final Object syncronize = new Object();
	public static void printLog(String text) {
		synchronized (syncronize) {
			LOGGER.info(text);
		}
	}

	public void addModule(Module module) {
		moduleManager.modules.add(module);
	}

	public void addCommand(Command command) {
		commandManager.commands.add(command);
	}

	public static String modid;
	public static String modname;
	public static String modversion;

	public void init(String id, String name, String version) {
		printLog("welcome to Monotone!");
		printLog("\n" +
				" __                     __                                       \n" +
				"[  |                   |  ]                                      \n" +
				" | |.--.   .---.   .--.| |  _ .--.   .--.    .--.   _ .--..--.   \n" +
				" | '/'`\\ \\/ /__\\\\/ /'`\\' | [ `/'`\\]/ .'`\\ \\/ .'`\\ \\[ `.-. .-. |  \n" +
				" |  \\__/ || \\__.,| \\__/  |  | |    | \\__. || \\__. | | | | | | |  \n" +
				"[__;.__.'  '.__.' '.__.;__][___]    '.__.'  '.__.' [___||__||__] \n");

		modid = id;
		modname = name;
		modversion = version;

		printLog("variables initialized.");

		commandManager = new CommandManager();
		printLog("command system initialized.");

		moduleManager = new ModuleManager();
		printLog("module system initialized.");

		settingManager = new SettingManager();
		printLog("setting system initialized.");

		save = new Save();
		load = new Load();
		printLog("saves and loads initialized.");
	}

}
