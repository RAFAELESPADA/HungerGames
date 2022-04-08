package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.Main;
import me.VideoSRC.api.EspectadoresManager;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.outros.ChecarVitoria;

public class CMDWatch implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("watch")) && (p.hasPermission("tag.ajudante"))) {
			p.setAllowFlight(true);
			p.sendMessage("§eYou enter spectator mode!");
			p.sendMessage("§eUse /go to go to a player!");
			p.getInventory().clear();
			p.setGameMode(GameMode.CREATIVE);

			ItemStack kit = new ItemStack(Material.SLIME_BALL);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§aTeleport Menu.");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(4, kit);

			Main.Watch.add(p.getName());
			EspectadoresManager.DamageMobs.add(p);
			Main.Jogadores.remove(sender.getName());
			p.getInventory().setHelmet(new ItemStack(Material.AIR));
			p.getInventory().setChestplate(new ItemStack(Material.AIR));
			p.getInventory().setLeggings(new ItemStack(Material.AIR));
			p.getInventory().setBoots(new ItemStack(Material.AIR));
			p.updateInventory();
			ChecarVitoria.verificaWin();
			Habilidade.removeAbility(p);
			Bukkit.getLogger().info(p.getName() + " Decided to spectate!");
			Bukkit.broadcast(p.getName() + " §7Dedided to give up on the game!", "tag.admin");
			Player[] arrayOfPlayer;
			for (Player pl : Bukkit.getOnlinePlayers()) {
				pl.hidePlayer(p);
			}
		} else {
			p.sendMessage("§eNo permission!");
		}
		return true;
	}
}
