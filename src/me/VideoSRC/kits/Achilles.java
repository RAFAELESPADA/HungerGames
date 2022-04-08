package me.VideoSRC.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Habilidade;

public class Achilles implements Listener {
	@EventHandler
	public void onDamageAchilles(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			Player player = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			ItemStack item = ((Player) e.getDamager()).getItemInHand();
			if ((Habilidade.getAbility(player).equalsIgnoreCase("achilles")) && (damager.getItemInHand() != null)) {
				if (item.getType().equals(Material.WOODEN_SWORD)) {
					e.setDamage(6.0D);
				} else if (item.getType().equals(Material.WOODEN_AXE)) {
					e.setDamage(e.getDamage() + 6.0D);
				} else if (item.getType().equals(Material.WOODEN_SHOVEL)) {
					e.setDamage(e.getDamage() + 6.0D);
				} else if (item.getType().equals(Material.WOODEN_PICKAXE)) {
					e.setDamage(e.getDamage() + 6.0D);
				} else if (item.getType().equals(Material.STONE_SWORD)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.STONE_PICKAXE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.STONE_HOE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.IRON_SWORD)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.IRON_PICKAXE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.IRON_SHOVEL)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.IRON_HOE)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.GOLDEN_SWORD)) {
					e.setDamage(e.getDamage() - 2.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.DIAMOND_SWORD)) {
					e.setDamage(e.getDamage() - 3.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.DIAMOND_SHOVEL)) {
					e.setDamage(e.getDamage() - 3.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				} else if (item.getType().equals(Material.DIAMOND_HOE)) {
					e.setDamage(e.getDamage() - 3.0D);
					damager.sendMessage(
							"§3Huh, The Wood Tools §3do more damage to this guy...");
				}
			}
		}
	}
}
