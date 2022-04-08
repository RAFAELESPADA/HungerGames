package me.VideoSRC.eventos;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.kits.BungeeAPI;
import me.VideoSRC.outros.Manager;

public class PreGameEvt implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onFood(FoodLevelChangeEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if (Main.PreGame) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (Main.PreGame) {
			Main.Jogadores.remove(p.getName());
		}
	}

	@EventHandler
	public void DamageMobs(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof LivingEntity)) {
			return;
		}
		if (Main.PreGame) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void DamagePlayers(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		if (Main.PreGame) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.PreGame) {
			e.setCancelled(true);
			return;
		}
	}
	public static void TeleportArenaRandom(final Player p) {
	    final Random dice = new Random();
	    final int number = dice.nextInt(10);
	    switch (number) {
	        case 0: {
	        	final World w = p.getWorld();
	            final double x = 16565;
	            final double y = 110;
	            final double z = 15651;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 1: {
	        	final World w = p.getWorld();
	            final double x = 252165;
	            final double y = 110;
	            final double z = 3251;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 3: {
	        	final World w = p.getWorld();
	            final double x = 2965;
	            final double y = 110;
	            final double z = 233033;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 4: {
	        	final World w = p.getWorld();
	            final double x = 75520;
	            final double y = 110;
	            final double z = 95522;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 5: {
	        	final World w = p.getWorld();
	            final double x = 36999;
	            final double y = 110;
	            final double z = 932222;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 6: {
	        	final World w = p.getWorld();
	            final double x = 92222;
	            final double y = 110;
	            final double z = 97444;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 7: {
	        	final World w = p.getWorld();
	            final double x = 12165;
	            final double y = 110;
	            final double z = 122888;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 8: {
	        	final World w = p.getWorld();
	            final double x = 26565;
	            final double y = 110;
	            final double z = 9265265;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	        case 9: {
	        	final World w = p.getWorld();
	            final double x = 416565;
	            final double y = 110;
	            final double z = 7855;
	            final Location lobby = new Location(w, x, y, z);
	            p.teleport(lobby);
	            p.getWorld().setSpawnLocation(lobby);
	            break;
	        }
	    }
	        }
		
	@EventHandler
	public void onWin(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (Main.Finalizando) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		e.setJoinMessage(null);
		if (Main.PreGame) {
			p.getInventory().clear();
			Main.Jogadores.add(p.getName());
			TitleAPI.sendTitle(p,  20 , 60 , 20, Strings.nomeserver , "§eWELCOME!");

			Habilidade.removeAbility(p);
			Habilidade.setAbility(p, "None");
			Manager.darItens(p);
			Location plocation = p.getLocation();
			Random random = new Random();
			double x = p.getLocation().getX();
			double z = p.getLocation().getZ();
			double x1 = x + 5112;
	        double z1 = z + 2621;
			Location semoceano = new Location(p.getWorld() , x1 , 110 , z1);
			Biome bioma = plocation.getWorld().getBiome((int)plocation.getX(), (int)plocation.getZ());  
			if (bioma == Biome.OCEAN || bioma == Biome.DEEP_OCEAN || bioma == Biome.WARM_OCEAN || bioma == Biome.LUKEWARM_OCEAN || bioma == Biome.RIVER || bioma == Biome.FROZEN_OCEAN || bioma == Biome.DEEP_FROZEN_OCEAN || bioma == Biome.FROZEN_RIVER || plocation.getBlock().getType() == Material.WATER) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
						for (Player p : Bukkit.getOnlinePlayers()) {

							BungeeAPI.send(p, "lobby");
						}
					}
				}, 5L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					public void run() {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
					}
				}, 40L);
				return;
		}
			Manager.tpSpawn(p);
		}
	
}}

