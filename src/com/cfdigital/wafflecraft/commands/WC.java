package com.cfdigital.wafflecraft.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cfdigital.wafflecraft.WaffleCraft;
import com.cfdigital.wafflecraft.classes.ClassManager;
import com.cfdigital.wafflecraft.classes.PlayerClass;
import com.cfdigital.wafflecraft.classes.SkillClass;

public class WC implements CommandExecutor {
	
	 WaffleCraft plugin;

	public WC(WaffleCraft plugin) {
		this.plugin = plugin;
	}
    
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		String commandName = command.getName().toLowerCase();
		String[] trimmedArgs = args;
		Player player = (Player) sender;
		if (commandName.equalsIgnoreCase("wc")) {
			PlayerClass pc = ClassManager.getPlayerClass(player);
			if (trimmedArgs.length >= 1 ){
				//show classes loaded
				if (trimmedArgs[0].equalsIgnoreCase("classes")) {
					player.sendMessage(WaffleCraft.prefix + "Loaded player classes"); {
						HashMap<String, SkillClass> hm = ClassManager.getWaffleClasses();
						for (String key : hm.keySet()) {
							player.sendMessage(key);
						}
					}
				}
				
				//set a class for self
				if (trimmedArgs[0].equalsIgnoreCase("setclass") && 	trimmedArgs.length == 2 ){
					String skillClass = trimmedArgs[1];
					pc.setSkillClass(skillClass);
					player.sendMessage(ChatColor.GREEN + "You are now the class " + skillClass);
				}
				
				//show info about self
				if (trimmedArgs[0].equalsIgnoreCase("class")) {
					String cn = pc.getSkillClass();
					int level = pc.getskillLevel();
					if (cn != null) {
						player.sendMessage("You are a level " + level + " + cn");
					} else {
						player.sendMessage(ChatColor.RED + "You have not joined a class yet!");
					}	
				}
			}
			return true;
		}
		return true;
	}
}