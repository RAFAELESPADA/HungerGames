package me.VideoSRC.kits;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.VideoSRC.api.Habilidade;

public class Lumberjack implements Listener {
	@EventHandler(priority = EventPriority.NORMAL)
	public void onBlockBreak1(BlockBreakEvent event) {
		Player p = event.getPlayer();
		Block b = event.getBlock();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("lumberjack")) && (b.getType() == Material.ACACIA_LOG || b.getType() == Material.OAK_LOG || b.getType() == Material.DARK_OAK_LOG ||b.getType() == Material.BIRCH_LOG || b.getType() == Material.JUNGLE_LOG || b.getType() == Material.SPRUCE_LOG)
				&& (p.getItemInHand().getType() == Material.WOODEN_AXE)) {
			World w = (World) Bukkit.getServer().getWorlds().get(0);
			Double y = Double.valueOf(b.getLocation().getY() + 1.0D);
			Location l = new Location(w, b.getLocation().getX(), y.doubleValue(), b.getLocation().getZ());
			while (l.getBlock().getType() == Material.ACACIA_LOG || l.getBlock().getType() == Material.OAK_LOG || l.getBlock().getType() == Material.DARK_OAK_LOG || l.getBlock().getType() == Material.BIRCH_LOG || l.getBlock().getType() == Material.JUNGLE_LOG || l.getBlock().getType() == Material.SPRUCE_LOG) {
				l.getBlock().breakNaturally();
				y = Double.valueOf(y.doubleValue() + 1.0D);
				l.setY(y.doubleValue());
			}
			while (l.getBlock().getType() == Material.ACACIA_LOG || l.getBlock().getType() == Material.OAK_LOG || l.getBlock().getType() == Material.DARK_OAK_LOG || l.getBlock().getType() == Material.BIRCH_LOG || l.getBlock().getType() == Material.JUNGLE_LOG || l.getBlock().getType() == Material.SPRUCE_LOG) {
				l.getBlock().breakNaturally();
				y = Double.valueOf(y.doubleValue() + 1.0D);
				l.setY(y.doubleValue());
			}
		}
	}
}
