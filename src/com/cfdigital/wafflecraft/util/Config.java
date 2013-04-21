package com.cfdigital.wafflecraft.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.cfdigital.wafflecraft.WaffleCraft;
import com.cfdigital.wafflecraft.classes.ClassManager;
import com.cfdigital.wafflecraft.classes.SkillClass;

public class Config extends JavaPlugin {

	private FileConfiguration config;
	private File classFile;
	static YamlConfiguration ymlConfig;

	final WaffleCraft plugin;


	public Config(WaffleCraft instance) {
		plugin = instance;
	}

	public boolean loadClasses() {
		classFile = new File(plugin.getDataFolder(), "classes.yml");
		config = plugin.getConfig();

		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdirs();
		}

		try {
			config.load(classFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		Map<String, Object> keys = config.getValues(true);
		ClassManager.clearWaffleClasses();
		for (String n : keys.keySet()) {
			if (n.startsWith("classes")) {
				String temp[] = n.split("\\.");
				if (temp.length == 2) {
					String className = temp[1];
					int classPrice = config.getInt("classes." + className + ".price");
					List<String> classItems = config.getStringList("classes" + className + ".items");
					if (classItems == null) {
						WaffleLogger.warning("Class " + className + " has no materials!");
						break;
					}
					SkillClass WC  = new SkillClass(className, classItems, classPrice);
					ClassManager.addWaffleClass(className, WC);
				}
			}
		}

		return true;

	}
}