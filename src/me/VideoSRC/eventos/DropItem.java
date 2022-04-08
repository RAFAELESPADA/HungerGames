package me.VideoSRC.eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.VideoSRC.api.Habilidade;

public class DropItem implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("forcefield"))
				&& (e.getItemDrop().getItemStack().getType() == Material.IRON_BARS)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("crafter"))
				&& (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("demoman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.GRAVEL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("grandpa"))
				&& (e.getItemDrop().getItemStack().getType() == Material.STICK)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("demoman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.STONE_PRESSURE_PLATE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("endermage"))
				&& (e.getItemDrop().getItemStack().getType() == Material.NETHER_PORTAL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("jellyfish"))
				&& (e.getItemDrop().getItemStack().getType() == Material.CLAY_BALL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("enderman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.ENDER_PEARL)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("fisherman"))
				&& (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("gladiator"))
				&& (e.getItemDrop().getItemStack().getType() == Material.IRON_BARS)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("grappler"))
				&& (e.getItemDrop().getItemStack().getType() == Material.ACACIA_BOAT)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("kangaroo"))
				&& (e.getItemDrop().getItemStack().getType() == Material.FIREWORK_ROCKET)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("monk"))
				&& (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("reaper"))
				&& (e.getItemDrop().getItemStack().getType() == Material.WOODEN_HOE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("specialist"))
				&& (e.getItemDrop().getItemStack().getType() == Material.BOOK)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("thor"))
				&& (e.getItemDrop().getItemStack().getType() == Material.WOODEN_AXE)) {
			e.setCancelled(true);
			p.updateInventory();
		}
		if ((Habilidade.getAbility(p).equalsIgnoreCase("timelord"))
				&& (e.getItemDrop().getItemStack().getType() == Material.CLOCK)) {
			e.setCancelled(true);
			p.updateInventory();
		}
	}
}
