package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;

public class CMDKitDisableAll implements Listener, CommandExecutor {
	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("toggle")) {
			if (p.hasPermission("tag.admin")) {
				if (args.length == 0) {
					sender.sendMessage("§eUse: /toggle <true-false>");
					return true;
				}
				if (args[0].equalsIgnoreCase("true")) {
					sender.sendMessage("§eYou enabled all kits!");
					Bukkit.broadcastMessage("§eAll kits has been enabled!");
					CMDKitDisable.KitsDisable = false;
				} else if (args[0].equalsIgnoreCase("false")) {
					sender.sendMessage("§eYou disabled all kits!");
					Bukkit.broadcastMessage("§eAll kits has been disabled!");
					CMDKitDisable.KitsDisable = true;
					for (Player Jogadores : Bukkit.getOnlinePlayers()) {
						Habilidade.removeAbility(Jogadores);
					}
				} else {
					sender.sendMessage("§eUse: /toggle <true-false>");
				}
			} else {
				p.sendMessage(Strings.perm);
				return true;
			}
		}
		return true;
	}
}
