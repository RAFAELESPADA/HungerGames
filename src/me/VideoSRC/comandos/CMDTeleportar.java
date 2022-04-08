package me.VideoSRC.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.api.Strings;

public class CMDTeleportar implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tp")) {
			if (!player.hasPermission("tag.ajudante")) {
				player.sendMessage(Strings.perm);
				return true;
			}
			if (args.length == 0) {
				player.sendMessage("§eUse /tp <player> ou /s <player>");
				return true;
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					player.sendMessage("§ePlayer offline!");
					return true;
				}
				player.teleport(target);
				player.sendMessage("§eTeleported to: §c" + target.getName());
				return true;
			}
			if (args.length > 1) {
				player.sendMessage("§eUse /tp <player> ou /s <player>");
				return true;
			}
		} else if (cmd.getName().equalsIgnoreCase("s")) {
			if (!player.hasPermission("tag.ajudante")) {
				player.sendMessage(Strings.perm);
				return true;
			}
			if (args.length == 0) {
				player.sendMessage("§eUse /tp <player> or /s <player>");
				return true;
			}
			if (args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					player.sendMessage("§ePlayer offline or invalid!");
					return true;
				}
				target.teleport(player);
				player.sendMessage("§eYou teleported §c" + target.getName() + "§7 to your position!");
				return true;
			}
			if (args.length > 1) {
				player.sendMessage("§eUse /tp <jogador> or /s <jogador>");
				return true;
			}
		}
		return false;
	}
}
