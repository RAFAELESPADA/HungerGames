package me.VideoSRC.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Strings;
import me.VideoSRC.feasteminifeast.FeastManager;

public class CMDFeast implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("feast")) && (Main.Andamento >= 15)) {
			p.setCompassTarget(FeastManager.getMainBlock().getLocation());
			p.sendMessage("§eCompass pointing to §aFeast!");
		} else {
			p.sendMessage("§cThe feast dont appear yet!");
		}
		return true;
	}
}
