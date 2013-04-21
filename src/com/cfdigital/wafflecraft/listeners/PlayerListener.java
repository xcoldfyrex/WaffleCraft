package com.cfdigital.wafflecraft.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import com.cfdigital.wafflecraft.WaffleCraft;

public class PlayerListener implements Listener	{

	final WaffleCraft plugin;

	public PlayerListener(WaffleCraft instance) {
		plugin = instance;
	}
	
	//craft item
	@EventHandler (priority = EventPriority.NORMAL)
	public void onCraft(CraftItemEvent event) {
		ItemStack item = event.getInventory().getResult();
		if (!(plugin.rankAllowed(item))) {
			event.setCancelled(true);
		}
	}
	
	//pick up item
	@EventHandler (priority = EventPriority.NORMAL)
	public void onPickup(PlayerPickupItemEvent event) {
		final Item item = event.getItem();
		if (!(plugin.rankAllowed(item))) {
			event.setCancelled(true);
			plugin.showDenied(event.getPlayer());
		}
	}
	
	//break block
	@EventHandler (priority = EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent event) {
		final Block block = event.getBlock();
		if (!(plugin.rankAllowed(event.getPlayer(), block))) {
			event.setCancelled(true);
			plugin.showDenied(event.getPlayer());
		}
	}
	
	//place block
	@EventHandler (priority = EventPriority.NORMAL)
	public void onBlockPlace(BlockPlaceEvent event) {
		final Block block = event.getBlock();
		if (!(plugin.rankAllowed(event.getPlayer(), block))) {
			event.setCancelled(true);
			plugin.showDenied(event.getPlayer());
		}
	}
	
	
}
