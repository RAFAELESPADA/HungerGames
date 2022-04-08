package me.VideoSRC.feasteminifeast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.VideoSRC.api.Arquivos;
import me.VideoSRC.borda.BorderType;
import me.VideoSRC.borda.WorldBorder;

public class MiniFeast2 {
	private static Block mainBlock = null;
	private static Integer radius = Integer.valueOf(3);
	private static Logger log = Bukkit.getLogger();
	private static Boolean spawned = Boolean.valueOf(false);
	private static Chest[] chests = new Chest[4];
	private static ArrayList<Location> fblocks = new ArrayList();
	public static int presentEndingDataValue = 15;
	public static int presentStartingDataValue = 0;
	public static String presentName = ChatColor.WHITE + "Gift to kit - %s";

	public static Location getRespawn() {
		double borderSize = 100.0D;
		Location spawn = ((World) Bukkit.getWorlds().get(0)).getSpawnLocation();
		double addX = new Random().nextInt((int) (borderSize / 2.0D)) + borderSize / 2.0D;
		double addZ = new Random().nextInt((int) (borderSize / 2.0D)) + borderSize / 2.0D;
		if (new Random().nextBoolean()) {
			addX = -addX;
		}
		if (new Random().nextBoolean()) {
			addZ = -addZ;
		}
		Block block = spawn.getWorld().getHighestBlockAt((int) (spawn.getX() + addX), (int) (spawn.getZ() + addZ));
		if (!block.getChunk().isLoaded()) {
			block.getChunk().load();
		}
		while ((block.getRelative(BlockFace.UP).getType() != Material.AIR) && (!block.isLiquid())) {
			block.getRelative(BlockFace.UP);
		}
		block.getLocation().add(0.0D, 2.0D, 0.0D);
		return block.getLocation();
	}

	public static void announceFeast() {
		if (mainBlock == null) {
			do {
				mainBlock = getRespawn().add(0.0D, 2.0D, 0.0D).getBlock();
			} while (!WorldBorder.inBorder(mainBlock.getLocation(), BorderType.WARN));
			mainBlock.setType(Material.GLASS);
			fblocks.add(mainBlock.getLocation());
			createFeast(Material.GLASS);
			spawned = Boolean.valueOf(true);
			spawnFeast();
		}
	}

	public static void spawnFeast() {
		DecimalFormat df = new DecimalFormat("##");
		Bukkit.broadcastMessage(
				"§cM-FEAST§7, A minifeast spawned in §§fX: §§f(" + df.format(mainBlock.getLocation().getX() + 50.0D)
						+ " >§7e §§f" + df.format(mainBlock.getLocation().getX() - 50.0D) + ") §§7e §fZ: ("
						+ df.format(mainBlock.getLocation().getZ() + 50.0D) + " §7e§f "
						+ df.format(mainBlock.getLocation().getZ() - 50.0D) + ")");
		spawnChests();

		List<String> items = Arquivos.MiniFeast.getStringList("ITEMSMF");
		for (String item : items) {
			String[] oneitem = item.split(",");
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


	private static void createFeast(Material m) {
		Integer r = radius;

		log.info("Generating feast.");
		for (double x = -r.intValue(); x <= r.intValue(); x += 1.0D) {
			for (double z = -r.intValue(); z <= r.intValue(); z += 1.0D) {
				Location loc = mainBlock.getLocation();
				Location l = new Location((World) Bukkit.getServer().getWorlds().get(0), loc.getX() + x, loc.getY(),
						loc.getZ() + z);
				if (l.distance(loc) <= r.intValue()) {
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
		Integer[] co = { Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(2),
				Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(3), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(-1), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(-1), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(5),
				Integer.valueOf(5), Integer.valueOf(-2) };
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
				m = Material.DIAMOND_BLOCK;
				break;
			case 7:
				m = Material.BEACON;
				break;
			case -1:
				break;
			case -2:
				break;
			default:
				log.warning("Something occoured when spawning feast: " + f.toString());
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
					if (curchest.intValue() < 4) {
						curchest = Integer.valueOf(curchest.intValue() + 1);
					}
				}
				loc.add(1.0D, 0.0D, 0.0D);
			}
		}
	}

	public static Block getMainBlock() {
		return mainBlock;
	}
}
