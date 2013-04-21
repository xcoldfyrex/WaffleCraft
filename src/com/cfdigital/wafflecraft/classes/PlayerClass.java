package com.cfdigital.wafflecraft.classes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerClass {
	
	public PlayerClass(Player player) {
		this.player = player;
	}
	
	public String getSkillClass() {
		if (skillClass == null) {
			return null;
		}
		return skillClass.toString();
	}
	public void setSkillClass(String skillClass) {
		if (ClassManager.WaffleClass(skillClass) != null) {
			this.skillClass = skillClass;
		} else {
			player.sendMessage(ChatColor.RED + "That class does not exist!");
		}
	}

	public int getskillLevel() {
		return skillLevel;
	}

	public void setskillLevel(int skillRank) {
		this.skillLevel = skillRank;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private int skillLevel = 1;
	private String skillClass;
	private Player player;
}