package me.VideoSRC.feasteminifeast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.Main;
import me.VideoSRC.api.Arquivos;

public class BonusFeast {
	private static Block mainBlock = null;
	private static Integer radius = Integer.valueOf(20);
	public static Boolean spawned = Boolean.valueOf(false);
	private static Chest[] chests = new Chest[12];
	private static ArrayList<Location> fblocks = new ArrayList();

	public static void announceFeast(Integer time) {
		if (mainBlock == null) {
			do {
				int min = 65286;
				int max = 250;
				Random r = new Random();
				int x = r.nextInt(max - min + 1) + max;
				int z = r.nextInt(max - min + 1) + max;
				Block maisalto = ((World) Bukkit.getServer().getWorlds().get(0)).getHighestBlockAt(x, z);
				Block loca = ((World) Bukkit.getServer().getWorlds().get(0)).getBlockAt(x, maisalto.getY(), z);
				mainBlock = loca;
			} while ((mainBlock.getType() == Material.OAK_LOG) || (mainBlock.getType() == Material.OAK_LEAVES) || (mainBlock.getType() == Material.DARK_OAK_LEAVES) || (mainBlock.getType() == Material.ACACIA_LEAVES  || (mainBlock.getType() == Material.DARK_OAK_LOG || (mainBlock.getType() == Material.ACACIA_LOG) || (mainBlock.getType() == Material.BIRCH_LOG || (mainBlock.getType() == Material.BIRCH_LEAVES || (mainBlock.getType() == Material.JUNGLE_LEAVES || (mainBlock.getType() == Material.JUNGLE_LOG) || (mainBlock.getType() == Material.SPRUCE_LEAVES || (mainBlock.getType() == Material.SPRUCE_LOG))))))));
			mainBlock.setType(Material.TERRACOTTA);
			fblocks.add(mainBlock.getLocation());
			removeAbove(mainBlock);
			createFeast(Material.RED_TERRACOTTA);
			spawned = Boolean.valueOf(true);
			me.VideoSRC.outros.ChecarVitoria.ProtecaoFeast = true;
		}
		time.intValue();
	}

	public static void spawnFeast() {
		if (mainBlock == null) {
			announceFeast(Integer.valueOf(0));
		}
		DecimalFormat df = new DecimalFormat("##.#");
		Bukkit.getLogger().info("The feast spawned in §f" + df.format(mainBlock.getLocation().getX()) + ","
				+ df.format(mainBlock.getLocation().getY()) + "," + df.format(mainBlock.getLocation().getZ()));
		Bukkit.broadcastMessage("§cB-FEAST§7, Bonus Feast Spawned!");
		me.VideoSRC.outros.ChecarVitoria.ProtecaoFeast = false;
		spawned = Boolean.valueOf(false);
		if (Main.BausFeast.booleanValue()) {
			spawnChests();
		}
		List<?> items = Arquivos.MiniFeast.getStringList("ITEMSF");
		for (Object item : items) {
			String[] oneitem = ((String) item).split(",");
			Random r = new Random();
			String itemid = oneitem[0];
			Integer minamount = Integer.valueOf(Integer.parseInt(oneitem[1]));
			Integer maxamount = Integer.valueOf(Integer.parseInt(oneitem[2]));
			Integer amount = Integer.valueOf(0);
			Boolean force = Boolean.valueOf(Boolean.parseBoolean(oneitem[3]));
			Boolean spawn = force;
			Integer id = null;
			Short durability = null;
			if (!force.booleanValue()) {
				spawn = Boolean.valueOf(r.nextBoolean());
			}
			while (amount.intValue() > 0) {
				Chest chest = chests[r.nextInt(4)];
				Integer slot = Integer.valueOf(r.nextInt(27));
				chest.getBlock().setType(Material.CHEST);
                Random random = new Random();

                Inventory inventory = ((Chest)chest.getBlock().getState()).getInventory();
                int itemsAmount = random.nextInt(5);

                for (int i = 0; i < itemsAmount; i++) {
                    int slot1 = random.nextInt(inventory.getSize());

                    int randomItemIndex = random.nextInt(items1.size());
                    ItemStack randomItem = items1.get(randomItemIndex);
                    chest.getInventory().setItem(slot1, randomItem);
				chest.update();
			}
			}
		}
	}
		private final static List<ItemStack> items1 = Arrays.asList(
	    		new ItemStack(Material.DIAMOND_SWORD),
	    		new ItemStack(Material.DIAMOND_AXE),
	    		new ItemStack(Material.DIAMOND_CHESTPLATE),
	    		new ItemStack(Material.GOLDEN_APPLE),
	    		new ItemStack(Material.ARROW , 16),
	    		new ItemStack(Material.POTION, 1, (short)16418),
	            new ItemStack(Material.POTION, 1, (short)16387),
	            new ItemStack(Material.POTION, 1, (short)16456),
	    		new ItemStack(Material.DIAMOND_HELMET),
	    		new ItemStack(Material.DIAMOND_BOOTS),
	    		new ItemStack(Material.DIAMOND_SWORD),
	    		new ItemStack(Material.LEATHER_HELMET),
	    		new ItemStack(Material.IRON_SWORD),
	    		new ItemStack(Material.IRON_AXE),
	    		new ItemStack(Material.LEATHER_LEGGINGS),
	    		new ItemStack(Material.POTION, 1 , (short)16388),
	    		new ItemStack(Material.DIAMOND_HELMET),
	    		new ItemStack(Material.DIAMOND_HELMET),
	    		new ItemStack(Material.DIAMOND_BOOTS),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.EXPERIENCE_BOTTLE),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.ARROW , 10),
	    		new ItemStack(Material.ENDER_PEARL),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.MUSHROOM_STEW),
	    		new ItemStack(Material.GOLDEN_APPLE, 3),
	    		new ItemStack(Material.GOLDEN_APPLE, 1, (short)1),
	    		new ItemStack(Material.DIAMOND_LEGGINGS)
	                    

	    );

	public static Boolean isFeastBlock(Block b) {
		if ((!Main.Feast.booleanValue()) || (!spawned.booleanValue())) {
			return Boolean.valueOf(false);
		}
		return Boolean.valueOf(fblocks.contains(b.getLocation()));
	}

	private static void createFeast(Material m) {
		Location loc = mainBlock.getLocation();
		Integer r = radius;
		for (double x = -r.intValue(); x <= r.intValue(); x += 1.0D) {
			for (double z = -r.intValue(); z <= r.intValue(); z += 1.0D) {
				Location l = new Location((World) Bukkit.getServer().getWorlds().get(0), loc.getX() + x, loc.getY(),
						loc.getZ() + z);
				if ((l.distance(loc) <= r.intValue()) && (l.getBlock().getType() != Material.NETHERRACK)) {
					removeAbove(l.getBlock());
					l.getBlock().setType(m);
					fblocks.add(l);
				}
			}
		}
	}

	private static void spawnChests() {
		Location loc = mainBlock.getLocation();
		loc.add(-3.0D, 1.0D, -3.0D);
		Integer curchest = Integer.valueOf(0);
		Main.ProtecaoFeast = Boolean.valueOf(false);
		Integer[] co = { Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5),
				Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2),
				Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(2),
				Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1),
				Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(3), Integer.valueOf(5),
				Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2),
				Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1) };
		Integer[] arrayOfInteger1;
		int j = (arrayOfInteger1 = co).length;
		for (int i = 0; i < j; i++) {
			Integer f = arrayOfInteger1[i];

			Material m = Material.AIR;
			switch (f.intValue()) {
			case 0:
				m = Material.AIR;
				break;
			case 1:
				m = Material.OBSIDIAN;
				break;
			case 2:
				m = Material.CHEST;
				break;
			case 3:
				m = Material.ENCHANTING_TABLE;
				break;
			case 4:
				m = Material.OAK_FENCE;
				break;
			case 5:
				break;
			case 6:
				m = Material.OAK_WOOD;
				break;
			case 7:
				m = Material.GLOWSTONE;
			}
			if (f.intValue() == -1) {
				loc.add(0.0D, 0.0D, 1.0D);
				loc.subtract(7.0D, 0.0D, 0.0D);
			} else if (f.intValue() == -2) {
				loc.add(0.0D, 1.0D, 0.0D);
				loc.subtract(7.0D, 0.0D, 6.0D);
			} else if (f.intValue() == 5) {
				loc.add(1.0D, 0.0D, 0.0D);
			} else {
				loc.getBlock().setType(m);
				if (f.intValue() != 0) {
					fblocks.add(loc.getBlock().getLocation());
				}
				if (m == Material.CHEST) {
					chests[curchest.intValue()] = ((Chest) loc.getBlock().getState());
					if (curchest.intValue() < 12) {
						curchest = Integer.valueOf(curchest.intValue() + 1);
					}
				}
				loc.add(1.0D, 0.0D, 0.0D);
			}
		}
	}

	public static void removeAbove(Block block) {
		Location loc = block.getLocation();
		loc.setY(loc.getY() + 0.5D);
		Block newBlock = ((World) Bukkit.getServer().getWorlds().get(0)).getBlockAt(loc);
		while (loc.getY() < ((World) Bukkit.getServer().getWorlds().get(0)).getMaxHeight()) {
			newBlock.setType(Material.AIR);
			loc.setY(loc.getY() + 0.5D);
			newBlock = ((World) Bukkit.getServer().getWorlds().get(0)).getBlockAt(loc);
		}
	}

	public static Block getMainBlock() {
		return mainBlock;
	}
}
