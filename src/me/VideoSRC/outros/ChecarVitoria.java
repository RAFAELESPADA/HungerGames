package me.VideoSRC.outros;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.map.MinecraftFont;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;
import me.VideoSRC.comandos.CMDAdmin;
import me.VideoSRC.comandos.CMDListener;
import me.VideoSRC.kits.BungeeAPI;
import me.VideoSRC.pontos.SistemaPontos;
import me.VideoSRC.tempos.EmJogo;

public class ChecarVitoria implements Listener {
	public static boolean ProtecaoFeast;

	@EventHandler
	public void onRegen(EntityRegainHealthEvent event) {
		LivingEntity entity = (LivingEntity) event.getEntity();
		final Damageable dm = entity;
		int lvl = 0;
		Collection<PotionEffect> Effects = entity.getActivePotionEffects();
		for (PotionEffect effect : Effects) {
			if ((effect.getType().getName() == "REGENERATION") || (effect.getType().getName() == "HEAL")) {
				lvl = effect.getAmplifier() + 1;
				break;
			}
		}
		if ((event.getRegainReason() == EntityRegainHealthEvent.RegainReason.MAGIC_REGEN) && (event.getAmount() == 1.0D)
				&& (lvl > 0)) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					if (dm.getMaxHealth() >= dm.getHealth() + 1.0D) {
						dm.setHealth(dm.getHealth() + 1.0D);
					}
				}
			}, 50L / (lvl * 2));
		} else if ((event.getRegainReason() == EntityRegainHealthEvent.RegainReason.MAGIC) && (event.getAmount() > 1.0D)
				&& (lvl > 0)) {
			event.setAmount(event.getAmount() * 1.5D);
		}
	}

	@EventHandler
	public void onBlockSpread(BlockSpreadEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBreakFeast(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (e.getBlock().getType() == Material.TERRACOTTA) {
			if (ProtecaoFeast) {
				e.setCancelled(true);
				p.sendMessage(Strings.perm);
				return;
			}
			return;
		}
	}

	private Map<String, Long> timeout = new HashMap();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if ((this.timeout.containsKey(p.getName()))
				&& (((Long) this.timeout.get(p.getName())).longValue() > System.currentTimeMillis())) {
			if (p.hasPermission("tag.ajudante")) {
				return;
			}
			p.sendMessage("??cSPAM ??7Please Do not spam!");
			e.setCancelled(true);
			return;
		}
		this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 3000L));
	}

	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().endsWith("%")) {
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void onAdm(PlayerPickupItemEvent e) {
		if (CMDAdmin.admin.contains(e.getPlayer())) {
			e.setCancelled(true);
			return;
		}
	}


	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteractbook(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Damageable dm = p;
		ItemStack item = event.getItem();
		if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (item != null) && (item.getType() == Material.WRITTEN_BOOK)) {
			ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
			bookMeta.setTitle("How to do Soups");
			bookMeta.setAuthor("zEnderX5_");
			List<String> pages = new ArrayList<String>();
			pages.add("HG is a battle royale mode with habilities!\nWhere you will need to fight to be the last player alive\nYou can do soups with the following items"); // Page 1
			pages.add("Mushrooms, Cocoa, Cactus, SeaGrass, Dandelions and Poppys\nApples, LilyPads, Wheat Seeds\nBeetroot seeds and Carrots");
			bookMeta.setPages(pages);
			writtenBook.setItemMeta(bookMeta);
			p.openBook(writtenBook);
	}
	
}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Damageable dm = p;
		ItemStack item = event.getItem();
		if (((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (item != null) && (item.getType() == Material.MUSHROOM_STEW)
				&& ((dm.getHealth() < 20.0D) || (p.getFoodLevel() < 20))) {
			int restores = 7;
			event.setCancelled(true);
			if (dm.getHealth() < 20.0D) {
				if (dm.getHealth() + restores <= 20.0D) {
					p.setHealth(dm.getHealth() + restores);
				} else {
					p.setHealth(20.0D);
				}
			} else if (p.getFoodLevel() < 20) {
				if (p.getFoodLevel() + restores <= 20) {
					p.setFoodLevel(p.getFoodLevel() + restores);
					p.setSaturation(75.0F);
					p.setExhaustion(0.0F);
				} else {
					p.setFoodLevel(20);
					p.setSaturation(75.0F);
					p.setExhaustion(0.0F);
				}
			}
			if (item.getAmount() > 1) {
				p.setItemInHand(new ItemStack(Material.BOWL));
			} else {
				item = new ItemStack(Material.BOWL);
			}
			p.setItemInHand(item);
		}
	}

	@EventHandler
	public void onSpecRank(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (Main.Watch.contains(p.getName())) {
			e.setCancelled(true);
			return;
		}
	}

			

	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(PlayerQuitEvent e) {
		if ((Main.Partida) && (Main.Jogadores.size() == 0)) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					Bukkit.shutdown();
					Main.Jogadores.clear();
				}
			}, 250L);
		}
	}

	public static void spawnRandomFirework(Location loc) {
		Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();
		Random r = new Random();
		int rt = r.nextInt(4) + 1;
		FireworkEffect.Type type = FireworkEffect.Type.BALL;
		if (rt == 1) {
			type = FireworkEffect.Type.BALL;
		}
		if (rt == 2) {
			type = FireworkEffect.Type.BALL_LARGE;
		}
		if (rt == 3) {
			type = FireworkEffect.Type.BURST;
		}
		if (rt == 4) {
			type = FireworkEffect.Type.CREEPER;
		}
		if (rt == 5) {
			type = FireworkEffect.Type.STAR;
		}
		Color c1 = Color.RED;
		Color c2 = Color.YELLOW;
		Color c3 = Color.ORANGE;
		FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withColor(c2)
				.withFade(c3).with(type).trail(r.nextBoolean()).build();
		fwm.addEffect(effect);
		int rp = r.nextInt(2) + 1;
		fwm.setPower(rp);
		fw.setFireworkMeta(fwm);
	}

	public static void onVerific() {
		if (Main.Finalizando) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
				}
			}, 600L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
				}
			}, 650L);
		}
	}

	public static String NEW_WINNER = "";

	@EventHandler
	public void onMap(MapInitializeEvent event) {
		if (NEW_WINNER == "") {
			MapView m = event.getMap();
			for (MapRenderer r : m.getRenderers()) {
				m.removeRenderer(r);
			}
			return;
		}
		MapView m = event.getMap();
		for (MapRenderer r : m.getRenderers()) {
			m.removeRenderer(r);
		}
		m.addRenderer(new MapRenderer() {
			public void render(MapView view, MapCanvas canvas, Player p) {
				int i = 0;
				int name = p.getName().length();
				if (name == 16) {
					i = 22;
				}
				if (name == 15) {
					i = 25;
				}
				if (name == 14) {
					i = 28;
				}
				if (name == 13) {
					i = 30;
				}
				if (name == 12) {
					i = 33;
				}
				if (name == 11) {
					i = 36;
				}
				if (name == 10) {
					i = 38;
				}
				if (name == 9) {
					i = 41;
				}
				if (name == 8) {
					i = 44;
				}
				if (name == 7) {
					i = 46;
				}
				if (name == 6) {
					i = 49;
				}
				if (name == 5) {
					i = 52;
				}
				if (name == 4) {
					i = 54;
				}
				if (name == 3) {
					i = 57;
				}
				if (name == 2) {
					i = 60;
				}
				if (name == 1) {
					i = 62;
				}
				String parabens = "Parabens";
				canvas.drawText(38, 6, MinecraftFont.Font, parabens + ",");
				canvas.drawText(-5, 15, MinecraftFont.Font, " You win!");
				canvas.drawText(i, 24, MinecraftFont.Font, p.getName());
			}
		});
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void NerfSwords(EntityDamageByEntityEvent event) {
		if ((event.getDamager() instanceof Player)) {
			Player player = (Player) event.getDamager();
			if (event.getDamage() > 1.0D) {
				event.setDamage(event.getDamage() - 1.0D);
			}
			if ((event.getDamager() instanceof Player)) {
				if ((player.getFallDistance() > 0.0F) && (!player.isOnGround())
						&& (!player.hasPotionEffect(PotionEffectType.BLINDNESS))) {
					int NewDamage = (int) (event.getDamage() * 1.5D) - (int) event.getDamage();
					if (event.getDamage() > 1.0D) {
						event.setDamage(event.getDamage() - NewDamage);
					}
				}
				if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
					for (PotionEffect Effect : player.getActivePotionEffects()) {
						if (Effect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {
							double Division = (Effect.getAmplifier() + 2) * 1.3D + 1.0D;
							int NewDamage1;
							if (event.getDamage() / Division <= 1.0D) {
								NewDamage1 = (Effect.getAmplifier() + 2) * 3 + 3;
							} else {
								NewDamage1 = (int) (event.getDamage() / Division);
							}
							event.setDamage(NewDamage1);
							break;
						}
					}
				}
				if (player.getItemInHand().getType() == Material.AIR) {
					event.setDamage(0.5D);
				}
				if (player.getItemInHand().getType() == Material.WOODEN_SWORD) {
					event.setDamage(1.5D);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(2.5);
				}
				if (player.getItemInHand().getType() == Material.GOLDEN_SWORD) {
					event.setDamage(1.5D);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(3.0D);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(4.0D);
				}
				if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
					for (PotionEffect Effect : player.getActivePotionEffects()) {
						if ((Effect.getType().equals(PotionEffectType.INCREASE_DAMAGE))
								&& (player.getItemInHand() != null)
								&& (player.getItemInHand().getType().name().contains("SWORD"))) {
							Random r = new Random();
							if (r.nextInt(3) == 0) {
								event.setDamage(event.getDamage() + 2.0D);
								break;
							}
							event.setDamage(event.getDamage() + 1.5D);
						}
					}
				}
				if ((player.getFallDistance() > 0.0F) && (!player.isOnGround())
						&& (!player.hasPotionEffect(PotionEffectType.BLINDNESS))) {
					if (player.getItemInHand().getType() == Material.AIR) {
						event.setDamage(0.5D);
					}
					if (player.getItemInHand().getType() == Material.WOODEN_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if (player.getItemInHand().getType() == Material.STONE_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if (player.getItemInHand().getType() == Material.GOLDEN_SWORD) {
						event.setDamage(event.getDamage() + 1.5D);
					}
					if (player.getItemInHand().getType() == Material.IRON_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
					if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
						event.setDamage(event.getDamage() + 1.0D);
					}
				}
			}
		}
	}

	public static void verificaWin() {
		if (Main.Partida) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				public void run() {
					if (Main.Jogadores.size() == 1) {
						for (String s : Main.Jogadores) {
							final Player pl1 = Bukkit.getPlayer(s);
							SistemaPontos.darDinheiro(pl1, 50);
							pl1.sendMessage("??eYou receive 50 points for the Win!");
							EmJogo.resetScoreboard(pl1);
							pl1.playSound(pl1.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
							Location pLoc = pl1.getLocation();
							final Location winnerLoc = new Location(pl1.getWorld(), pLoc.getBlockX(), 170.0D,
									pLoc.getBlockZ());
							for (int i = 0; i < 1; i++) {
								for (int x = -3; x < 3; x++) {
									for (int z = -3; z < 3; z++) {
										Block b = winnerLoc.clone().add(x, -2.0D, z).getBlock();
										Block b2 = winnerLoc.clone().add(x, -1.0D, z).getBlock();
										b.setType(Material.GLASS);
										b2.setType(Material.CAKE);
										pl1.teleport(winnerLoc);
										pl1.getInventory().clear();
										Manager.darBalde(pl1);
									}
									Main.Finalizando = true;
									ChecarVitoria.spawnRandomFirework(winnerLoc);
									Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
										public void run() {
											ChecarVitoria.spawnRandomFirework(winnerLoc);
										}
									}, 550L);
									Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
										public void run() {
											ChecarVitoria.spawnRandomFirework(winnerLoc);
										}
									}, 200L);
								}
							}
							Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
								public void run() {
									Bukkit.broadcastMessage("??cWIN??7, " + pl1.getName() + " Wins!");
								}
							}, 5L, 120L);
							Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
								public void run() {
									if (pl1.isOnline()) {
										for (Player p : Bukkit.getOnlinePlayers()) {
											SistemaPontos.darDinheiro(p, 400);
											BungeeAPI.send(pl1, "lobby");
										}
									}
								}
							}, 250L);
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
							public void run() {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
									}
						}, 500L);
				
					} else if (Main.Jogadores.size() == 0) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "restart");
					}
				}
			}, 25L);
		}
	}
}
