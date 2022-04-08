package me.VideoSRC.outros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import me.VideoSRC.Main;
import net.minecraft.server.v1_16_R3.PacketDataSerializer;
import net.minecraft.server.v1_16_R3.PacketPlayOutCustomPayload;
import net.minecraft.server.v1_16_R3.PacketPlayOutOpenBook;

@SuppressWarnings("unused")
public class Manager {
	public static void darItens(Player p) {

		p.getInventory().clear();
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta mkits = kits.getItemMeta();
		mkits.setDisplayName("§aKits §7(Click)");
		kits.setItemMeta(mkits);

		p.getInventory().setItem(4, kits);
		ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
		bookMeta.setTitle("How to make soups");
		bookMeta.setAuthor("zEnderX5_");
		List<String> pages = new ArrayList<String>();
		pages.add("HG is a battle royale mode with habilities!\nWhere you will need to fight to be the last player alive\nYou can do soups with the following items"); // Page 1
		pages.add("Mushrooms, Cocoa Beans, Cactus, SeaGrass, Dandelions and Poppys\nApples, LilyPads, Wheat Seeds\nBeetroot seeds and Carrots");
		bookMeta.setPages(pages);
		writtenBook.setItemMeta(bookMeta);
		p.openBook(writtenBook);
		p.getInventory().setItem(8, writtenBook);
		p.updateInventory();
	}

	public static void darBussola(Player p) {

		ItemStack kits = new ItemStack(Material.COMPASS);
		ItemMeta mkits = kits.getItemMeta();
		mkits.setDisplayName("§cCompass");
		kits.setItemMeta(mkits);

		p.getInventory().setItem(0, kits);

		p.updateInventory();
	}

	public static void darBalde(Player p) {

		ItemStack balde = new ItemStack(Material.WATER_BUCKET);
		ItemMeta mbalde = balde.getItemMeta();
		mbalde.setDisplayName("§b§lYou win!");
		balde.setItemMeta(mbalde);

		p.getInventory().setItem(4, balde);

		p.updateInventory();
	}

	public static void tpwSpawn(Player p) {

		Location plocation = p.getLocation();
		int topX = p.getWorld().getSpawnLocation().getBlockX();
		int topZ = p.getWorld().getSpawnLocation().getBlockZ();
		int topY = plocation.getWorld().getHighestBlockYAt(topX, topZ);

		Location loc1 = new Location(p.getWorld(), topX, topY + 1, topZ);
		p.teleport(loc1);
	}

	public static void tpSpawn(Player p) {

		Location plocation = p.getLocation();
		int topX = p.getWorld().getSpawnLocation().getBlockX();
		int topZ = p.getWorld().getSpawnLocation().getBlockZ();
		int topY = plocation.getWorld().getHighestBlockYAt(topX, topZ);

		Location loc1 = new Location(p.getWorld(), topX, topY + 1, topZ);
		p.teleport(loc1);
	}

	public static void darItemInv(final Inventory inv, final Material mat, final int quantidade, final int modo,
			final String nome, final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade, (short) modo);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		inv.setItem(lugar, item);
	}
}
