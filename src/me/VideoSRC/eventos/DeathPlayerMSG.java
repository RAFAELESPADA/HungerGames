package me.VideoSRC.eventos;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;

public class DeathPlayerMSG implements Listener {
	public static String NomeDosItens(ItemStack i) {
		String nome = null;
		if (i.getType() == Material.AIR) {
			nome = "Hand";
		} else if (i.getType() == Material.WOODEN_SWORD) {
			nome = "Wood Sword";
		} else if (i.getType() == Material.STONE_SWORD) {
			nome = "Stone Sword";
		} else if (i.getType() == Material.IRON_SWORD) {
			nome = "Iron Sword";
		} else if (i.getType() == Material.DIAMOND_SWORD) {
			nome = "Diamond Sword";
		} else if (i.getType() == Material.GOLDEN_SWORD) {
			nome = "Gold Sword";
		} else if (i.getType() == Material.WOODEN_AXE) {
			nome = "Wood Axe";
		} else if (i.getType() == Material.STONE_AXE) {
			nome = "Stone Axe";
		} else if (i.getType() == Material.IRON_AXE) {
			nome = "Iron Axe";
		} else if (i.getType() == Material.DIAMOND_AXE) {
			nome = "Diamond Axe";
		} else if (i.getType() == Material.GOLDEN_AXE) {
			nome = "Golden Axe";
		} else if (i.getType() == Material.WOODEN_SHOVEL) {
			nome = "Pa de Madeira";
		} else if (i.getType() == Material.STONE_SHOVEL) {
			nome = "Stone Shovel";
		} else if (i.getType() == Material.IRON_SHOVEL) {
			nome = "Iron Shovel";
		} else if (i.getType() == Material.DIAMOND_SHOVEL) {
			nome = "Diamond Shovel";
		} else if (i.getType() == Material.GOLDEN_SHOVEL) {
			nome = "Gold Shovel";
		} else if (i.getType() == Material.WOODEN_PICKAXE) {
			nome = "Wood Pickaxe";
		} else if (i.getType() == Material.STONE_PICKAXE) {
			nome = "Stone Pickaxe";
		} else if (i.getType() == Material.IRON_PICKAXE) {
			nome = "Iron Pickaxe";
		} else if (i.getType() == Material.DIAMOND_PICKAXE) {
			nome = "Diamond Pickaxe";
		} else if (i.getType() == Material.GOLDEN_PICKAXE) {
			nome = "Gold Pickaxe";
		} else if (i.getType() == Material.STICK) {
			nome = "Stick";
		} else if (i.getType() == Material.MAP) {
			nome = "Map";
		} else if (i.getType() == Material.MUSHROOM_STEW) {
			nome = "Soup";
		} else if (i.getType() == Material.RED_MUSHROOM) {
			nome = "Red Mushroom";
		} else if (i.getType() == Material.BROWN_MUSHROOM) {
			nome = "Brown Mushroom";
		} else if (i.getType() == Material.BOWL) {
			nome = "Bowl";
		} else if (i.getType() == Material.COMPASS) {
			nome = "Compass";
		} else {
			nome = i.getType().toString();
		}
		return nome;
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		for (ItemStack drops : event.getDrops()) {
			Material m = drops.getType();
			if ((m.equals(Material.LEATHER)) || (m.equals(Material.FLINT)) || (m.equals(Material.CLOCK))
					|| (m.equals(Material.BLAZE_ROD)) || (m.equals(Material.STONE_PICKAXE))
					|| (m.equals(Material.WOODEN_AXE)) || (m.equals(Material.FIRE_CHARGE)) || (m.equals(Material.LEAD))
					|| (m.equals(Material.IRON_BARS)) || (m.equals(Material.SNOWBALL))
					|| (m.equals(Material.SLIME_BALL)) || (m.equals(Material.STONE_AXE))
					|| (m.equals(Material.WOODEN_HOE)) || (m.equals(Material.STICK)) || (m.equals(Material.FISHING_ROD))
					|| (m.equals(Material.ENDER_PEARL)) || (m.equals(Material.CLAY_BALL)) || (m.equals(Material.NETHER_PORTAL))
					|| (m.equals(Material.LEATHER_BOOTS)) || (m.equals(Material.NETHER_STAR))
					|| (m.equals(Material.STONE_PRESSURE_PLATE)) || (m.equals(Material.GRAVEL))) {
				drops.setAmount(1);
				drops.setType(Material.AIR);
			}
		}
	}

	@EventHandler
	public void DeathMSGMonster(PlayerDeathEvent e) {
		Player p = e.getEntity();
		EntityDamageEvent damageEvent = p.getLastDamageCause();
		if (!(damageEvent instanceof EntityDamageByEntityEvent)) {
			return;
		}
		Entity damager = ((EntityDamageByEntityEvent) damageEvent).getDamager();
		if ((damager instanceof Monster)) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by a monster!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by a monster!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		}
	}

	@EventHandler
	public void DeathMSGAnimals(PlayerDeathEvent e) {
		Player p = e.getEntity();
		EntityDamageEvent damageEvent = p.getLastDamageCause();
		if (!(damageEvent instanceof EntityDamageByEntityEvent)) {
			return;
		}
		Entity damager = ((EntityDamageByEntityEvent) damageEvent).getDamager();
		if ((damager instanceof Animals)) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by a animal" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by a animal" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		}
	}

	@EventHandler
	public void DeathMSG(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (((e.getEntity() instanceof Player)) && ((p.getKiller() instanceof Player))
				&& (e.getDeathMessage().contains("was slain by"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " gets killed by "
							+ ChatColor.GRAY + p.getKiller().getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p.getKiller())) + ")" + ChatColor.GRAY
							+ " with " + NomeDosItens(p.getKiller().getItemInHand()) + "\n" + ChatColor.RED
							+ Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED
							+ p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " foi morto por "
						+ ChatColor.GRAY + p.getKiller().getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p.getKiller())) + ")" + ChatColor.GRAY + " com "
						+ NomeDosItens(p.getKiller().getItemInHand()) + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("went up in flames"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died burned!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Died burned!"
						+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("dragon"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by a dragon O_O!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by a dragon O_O!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("ladder"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Morreu!" + "\n"
							+ ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
							+ ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Morreu!" + "\n"
						+ ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (e.getDeathMessage().contains("walked into a cactus")) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Morreu!" + "\n"
							+ ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
							+ ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Morreu!" + "\n"
						+ ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (e.getDeathMessage().contains("walked into fire")) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Tentou correr mas morreu!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Tentou correr mas morreu!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (e.getDeathMessage().contains("Magma Cube")) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by magma cube!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by magma cube!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (e.getDeathMessage().contains("was struck by lightning")) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by lighting!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by lightning!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("went up in flames"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died burned!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Died burned!"
						+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player))
				&& (e.getDeathMessage().contains("walked into a fire whilst fighting"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died burned!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Died burned!"
						+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player))
				&& (e.getDeathMessage().contains("was burnt to a crisp whilst fighting"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died burned!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Died burned!"
						+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("burned to death"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Queimou ate a morte!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Queimou ate a morte!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player))
				&& (e.getDeathMessage().contains("was burnt to a crisp whilst fighting"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " walked into a fire whilst fighting!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " walked into a fire whilst fighting!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player))
				&& (e.getDeathMessage().contains("walked into a fire whilst fighting"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " walked into a fire whilst fighting!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " walked into a fire whilst fighting!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("tried to swim in lava"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Tried to swin in lava!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Tried to swin in lava!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("suffocated in a wall"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died suffocated by blocks!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died suffocated by blocks!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("drowned"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Drowned!"
							+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left"
							+ "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Drowned!"
						+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("drowned"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Drowned!"
							+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left"
							+ "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Drowned!"
						+ "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("starved to death"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died of hunger!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died of hunger!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was pricked to death"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Spiked in a cactus!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " spiked in a cactus!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player))
				&& (e.getDeathMessage().contains("walked into a cactus while trying to escape"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died spiked in cactus!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died spiked in cactus!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("fell from a high place"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Fall in the void!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Fall in the void!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("hit the ground too hard"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Fall in the void!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Fall in the void!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("fell out of the world"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Fall in the void!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Fall in the void!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("died"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Morreu!" + "\n"
							+ ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
							+ ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY + " Morreu!" + "\n"
						+ ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n"
						+ ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("blew up"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by explosion!" + "\n" + ChatColor.RED
							+ Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED
							+ p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by explosion!" + "\n" + ChatColor.RED
						+ Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED
						+ p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was blown up by"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by explosion!" + "\n" + ChatColor.RED
							+ Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED
							+ p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by explosion!" + "\n" + ChatColor.RED
						+ Main.Jogadores.size() + ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED
						+ p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("magic"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by witch!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by witch!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("withered away"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by wither!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
							+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Morreu por 1 wither!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was shot by"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by one arrow!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by one arrow!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was fireballed by"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by fireball!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by bola de fogo!" + "\n" + ChatColor.RED + Main.Jogadores.size()
						+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
						+ " Left the server.");
			}
		} else if (((e.getEntity() instanceof Player)) && (e.getDeathMessage().contains("was pummeled by"))) {
			if (p.hasPermission("tag.vip")) {
				if (Main.Andamento <= 300) {
					e.setDeathMessage(null);
				} else if (Main.Andamento >= 300) {
					e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
							+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
							+ " Died by EnderPearl!" + "\n" + ChatColor.RED + Main.Jogadores.size()
							+ ChatColor.GRAY + " Players left" + "\n" + ChatColor.RED + p.getName()
							+ " Left the server.");
				}
			} else {
				e.setDeathMessage(ChatColor.GRAY + p.getName() + ChatColor.RED + "("
						+ Habilidade.NomeDoKit(Habilidade.getAbility(p)) + ")" + ChatColor.GRAY
						+ " Died by EnderPearl!" + "\n" + ChatColor.RED + Main.Jogadores.size() + ChatColor.GRAY
						+ " Players left" + "\n" + ChatColor.RED + p.getName() + " Left the server.");
			}
		}
	}
}
