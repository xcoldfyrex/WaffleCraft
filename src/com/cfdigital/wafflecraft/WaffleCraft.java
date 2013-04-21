package com.cfdigital.wafflecraft;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.cfdigital.wafflecraft.classes.ClassManager;
import com.cfdigital.wafflecraft.classes.PlayerClass;
import com.cfdigital.wafflecraft.commands.Skill;
import com.cfdigital.wafflecraft.commands.WC;
import com.cfdigital.wafflecraft.listeners.BlockListener;
import com.cfdigital.wafflecraft.listeners.PlayerListener;
import com.cfdigital.wafflecraft.util.Config;
import com.cfdigital.wafflecraft.util.WaffleLogger;


public class WaffleCraft extends JavaPlugin {

	public WaffleCraft plugin;

	public static String prefix = "§6[§aWaffleCraft§6]§f ";

	public WaffleCraft() {
		plugin = this;
	}

	private final PlayerListener playerListener = new PlayerListener(this);
	private final BlockListener blockListener = new BlockListener(this);

	@Override
	public void onEnable()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
		pm.registerEvents(blockListener, this);

		Config config = new Config(this);
		
		if (!config.loadClasses()){
			WaffleLogger.severe("Failed to load classes! Disabling..");
			this.plugin.onDisable();
		}
		
		getCommand("wc").setExecutor(new WC(this));
		getCommand("skill").setExecutor(new Skill(this));
		
		for (Player player : getServer().getOnlinePlayers()) {
			PlayerClass pc = new PlayerClass(player);			
			ClassManager.addWafflePlayer(player, pc);
		}
	}

	@Override
	public void onDisable() {
		plugin.getServer().getScheduler().cancelTasks(plugin);
	}
	
	public boolean rankAllowed(Material material) {
		//probably came from placing or mining
		return true;
	}
	
	public boolean rankAllowed(ItemStack itemstack) {
		//was something that was crafted
		return true;
	}
	
	public boolean rankAllowed(Item items) {
		//probably picked up
		return true;
	}
	
	public boolean rankAllowed(Player player, Block block) {
		//broke/placed
		return false;
	}
	
	public void showDenied(Player player) {
		player.sendMessage(prefix + "Your rank is not high enough for this!");
		
	}
	
	public boolean isItemInClass(Material material) {
		return false;
		
	}
}