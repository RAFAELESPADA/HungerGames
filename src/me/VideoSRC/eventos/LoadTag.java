package me.VideoSRC.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import me.VideoSRC.Main;
import me.VideoSRC.menus.GuiRank;
import me.VideoSRC.menus.MenuKits1;

public class LoadTag implements Listener {


	@EventHandler(priority = EventPriority.MONITOR)
	public void Stats(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((Main.PreGame) && (p.getItemInHand().getType() == Material.BOOK)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			;
			GuiRank.GuiRanks(p);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void Kits(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((Main.PreGame) && (p.getItemInHand().getType() == Material.CHEST)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			MenuKits1.InventarioKitsGui(p);
		}
	}

	

	}
