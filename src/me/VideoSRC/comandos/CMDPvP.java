package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.Strings;

public class CMDPvP implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (p.hasPermission("tag.mod")) {
				if (args.length == 0) {
					p.sendMessage("§eUse: /pvp on or /pvp off");
					return true;
				}
				if (args[0].equalsIgnoreCase("on")) {
					Bukkit.getServer().getWorld("world").setPVP(true);
					Bukkit.broadcastMessage("§ePvp global activated!");
				}
				if (args[0].equalsIgnoreCase("off")) {
					Bukkit.getServer().getWorld("world").setPVP(false);
					Bukkit.broadcastMessage("§ePvp global disabled!");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return true;
	}
}
