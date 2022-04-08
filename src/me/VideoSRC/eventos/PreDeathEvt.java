package me.VideoSRC.eventos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.EspectadoresManager;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.kits.BungeeAPI;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.outros.Manager;

public class PreDeathEvt implements Listener {
	@EventHandler
	public void onRespawnRenove(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (p.isDead()) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					p.spigot().respawn();
				}
			}, 15L);
		}
	}

	@EventHandler
	public void onDeathCheck(PlayerDeathEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
			}
		}, 35L);
	}

	@EventHandler
	public void Respawn(PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				Bukkit.getServer().getWorld("world");
				Random random = new Random();
				Location teleportLocation = null;
				int x = random.nextInt(350) + 1;
				int y = 150;
				int z = random.nextInt(350) + 1;
				boolean isOnLand = false;
				while (!isOnLand) {
					teleportLocation = new Location(p.getWorld(), x, y, z);
					if (teleportLocation.getBlock().getType() != Material.AIR) {
						isOnLand = true;
					} else {
						y--;
					}
				}
				p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D,
						teleportLocation.getZ()));
				p.setHealth(20.0D);
				p.setFoodLevel(20);
				p.setSaturation(75.0F);
				p.setNoDamageTicks(160);
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 3));
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.COMPASS) });
			}
		}, 10L);
	}

	@EventHandler
	public void onRespawn(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if ((p.hasPermission("tag.vip")) && (Main.Andamento <= 300)) {
			ChecarVitoria.verificaWin();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			Manager.darBussola(p);
		} else if ((p.hasPermission("tag.vip")) && (Main.Andamento >= 300)) {
			Main.Watch.add(p.getName());
			Main.Jogadores.remove(p.getName());
			Habilidade.removeAbility(p);
			ChecarVitoria.verificaWin();
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					p.getInventory().clear();
				}
			}, 5L);
		} else if ((Main.Andamento >= 300) && (p.hasPermission("tag.vip"))) {
			Main.Watch.add(p.getName());
			EspectadoresManager.DamageMobs.add(p);
			Main.Jogadores.remove(p.getName());

			p.getInventory().clear();
			p.sendMessage("§cSPEC§7, You joined spec mode!");
			p.sendMessage("§cSPEC§7, Use /go to go to a player!");
			p.setGameMode(GameMode.CREATIVE);

			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					ItemStack kit = new ItemStack(Material.SLIME_BALL);
					ItemMeta rkit = kit.getItemMeta();
					rkit.setDisplayName("§aTeleport Menu.");
					kit.setItemMeta(rkit);
					p.getInventory().setItem(4, kit);
				}
			}, 5L);
			ChecarVitoria.verificaWin();
			Habilidade.removeAbility(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					for (Player hids : Bukkit.getOnlinePlayers()) {

						hids.hidePlayer(p);
						p.setAllowFlight(true);
						p.setFlying(true);
					}
				}
			}, 5L);
		} else {
			BungeeAPI.send(p, "lobby");
			Main.mortos.add(p.getName());
			Main.Jogadores.remove(p.getName());
			ChecarVitoria.verificaWin();
		}
	}
}
