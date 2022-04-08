package me.VideoSRC.kits;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.VideoSRC.api.Habilidade;

public class Monk implements Listener {
	public String monkCooldownMessagem = "§cMONK§7, You are in cooldown!";
	public String Acertouomonk = "§cMONK§7, You desarmed your enemy!";
	public boolean randominv = true;
	private transient HashMap<ItemStack, Long> monkL = new HashMap();
	public int cooldown = 15;
	public int mcooldown = 15;

	@EventHandler
	public void onRightClick1(PlayerInteractEntityEvent event) {
		ItemStack item = event.getPlayer().getItemInHand();
		Player Player = event.getPlayer();
		if ((Habilidade.getAbility(Player).equalsIgnoreCase("monk"))
				&& (Player.getItemInHand().getType() == Material.BLAZE_ROD)
				&& (event.getRightClicked().getType() == EntityType.PLAYER)) {
			long lastUsed = 0L;
			if (this.monkL.containsKey(item)) {
				lastUsed = ((Long) this.monkL.get(item)).longValue();
			}
			if (lastUsed + 1000 * this.mcooldown > System.currentTimeMillis()) {
				event.getPlayer().sendMessage(String.format(this.monkCooldownMessagem, new Object[] {
						Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * this.cooldown)) / 1000L)) }));
			} else {
				PlayerInventory inv = ((Player) event.getRightClicked()).getInventory();
				int slot = new Random().nextInt(this.randominv ? 36 : 9);
				ItemStack replaced = inv.getItemInHand();
				if (replaced == null) {
					replaced = new ItemStack(Material.AIR);
				}
				ItemStack replacer = inv.getItem(slot);
				if (replacer == null) {
					replacer = new ItemStack(Material.AIR);
				}
				inv.setItemInHand(replacer);
				inv.setItem(slot, replaced);
				this.monkL.put(item, Long.valueOf(System.currentTimeMillis()));
				event.getPlayer().sendMessage(ChatColor.GREEN + this.Acertouomonk);
			}
		}
	}
}
