package com.cfdigital.wafflecraft.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ClassManager {
	
	private static HashMap<String,SkillClass> waffleClasses = new HashMap<String,SkillClass>();
	private static HashMap<Player,PlayerClass> playerClass = new HashMap<Player,PlayerClass>();
	private static List<Material> registeredItems = new ArrayList<Material>();

	public static SkillClass WaffleClass(String className) {
		if (waffleClasses.containsKey(className)) {
			return waffleClasses.get(className);
		}
		return null;
	}

	public static boolean addWaffleClass(String className, SkillClass WC) {
		if (waffleClasses.containsKey(className)) return false;
		waffleClasses.put(className, WC);
		return true;
	}
	
	public static boolean addWafflePlayer(Player player, PlayerClass pc) {
		if (playerClass.containsKey(player)) return false;
		playerClass.put(player, pc);
		return true;
	}
	
	public static void clearWaffleClasses() {
		waffleClasses.clear();
	}
	
	public static HashMap<String,SkillClass> getWaffleClasses(){
		return waffleClasses;
	}
	
	public static PlayerClass getPlayerClass(Player player) {
		if (!playerClass.containsKey(player)) return null;
		PlayerClass pc = playerClass.get(player);
		return pc;
	}

	public static List<Material> getRegisteredItems() {
		return registeredItems;
	}

	public static void addRegisteredItems(List<Material> registeredItems) {
		ClassManager.registeredItems = registeredItems;
	}
}