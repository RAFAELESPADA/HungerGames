package me.VideoSRC.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;

public class CMDDano implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("damage")) {
			if (args.length == 0) {
				p.sendMessage("§eUse /damage on ou /damage off");
				return true;
			}
			if ((p.hasPermission("tag.admin")) && (args[0].equalsIgnoreCase("on"))) {
				p.sendMessage("§eThe damage as been activated!");
				Main.Dano = false;
			}
			if ((p.hasPermission("tag.admin")) && (args[0].equalsIgnoreCase("off"))) {
				p.sendMessage("§cDANO§7, The damage as been desactivated!");
				Main.Dano = true;
			}
			return true;
		}
		return false;
	}
}
