package com.cfdigital.wafflecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cfdigital.wafflecraft.WaffleCraft;

public class Skill implements CommandExecutor {
	
	 WaffleCraft plugin;

	public Skill(WaffleCraft plugin) {
		this.plugin = plugin;
	}
    
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		String commandName = command.getName().toLowerCase();
		String[] trimmedArgs = args;
		Player player = (Player) sender;
		if (commandName.equalsIgnoreCase("skill")) {
			player.sendMessage("You have X SkillPoints left to spend");
			
			return true;
		}
		
		if (commandName.equalsIgnoreCase("skill help")) {
			return true;
		}
		return true;
	}
}
