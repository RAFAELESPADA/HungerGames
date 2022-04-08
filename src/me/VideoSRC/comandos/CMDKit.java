package me.VideoSRC.comandos;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.menus.MenuKits1;

public class CMDKit implements Listener, CommandExecutor {
	public static void onKitChest(Player p) {
		if (Main.PreGame) {
			MenuKits1.InventarioKitsGui(p);
		}
	}

	public static ArrayList<String> CopyCat = new ArrayList();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				onKitChest(p);
				return true;
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("kangaroo"))) {
				p.sendMessage("§eYou choose the kit: §cKangaroo");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Kangaroo");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("crafter"))) {
				p.sendMessage("§eYou choose the kit: §cCrafter");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Crafter");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("launcher"))) {
				p.sendMessage("§eYou choose the kit: §cLauncher");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Launcher");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("madman"))) {
				p.sendMessage("§eYou choose the kit: §cMadman");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Madman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("enderman"))) {
				p.sendMessage("§eYou choose the kit: §cEnderman");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Enderman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("grandpa"))) {
				p.sendMessage("§eYou choose the kit: §cGrandpa");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Grandpa");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("Copycat"))) {
				p.sendMessage("§eYou choose the kit: §cCopyCat");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "CopyCat");
				CopyCat.add(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Surprise"))) {
				p.sendMessage("§eYou choose the kit: §cSurprise");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Surprise");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("cultivator"))) {
				p.sendMessage("§eYou choose the kit: §cCultivator");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Cultivator");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("anchor"))) {
				p.sendMessage("§eYou choose the kit: §cAnchor");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Anchor");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("hulk"))) {
				p.sendMessage("§eYou choose the kit: §cHulk");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Hulk");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("Demoman"))) {
				p.sendMessage("§eYou choose the kit: §cDemoman");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Demoman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("endermage"))) {
				p.sendMessage("§eYou choose the kit: §cEndermage");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Endermage");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("tower"))) {
				p.sendMessage("§eYou choose the kit: §cTower");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Tower");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Fisherman"))) {
				p.sendMessage("§eYou choose the kit: §cFisherman");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Fisherman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("forger"))) {
				p.sendMessage("§eYou choose the kit: §cForger");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Forger");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("gladiator"))) {
				p.sendMessage("§eYou choose the kit: §cGladiator");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Gladiator");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("grappler"))) {
				p.sendMessage("§eYou choose the kit: §cGrappler");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Grappler");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("jellyfish"))) {
				p.sendMessage("§eYou choose the kit: §cJellyfish");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Jellyfish");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("lumberjack"))) {
				p.sendMessage("§eYou choose the kit: §cLumberjack");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Lumberjack");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("miner"))) {
				p.sendMessage("§eYou choose the kit: §cMiner");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Miner");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("monk"))) {
				p.sendMessage("§eYou choose the kit: §cMonk");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Monk");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("fireman"))) {
				p.sendMessage("§eYou choose the kit: §cFireman");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Fireman");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("viking"))) {
				p.sendMessage("§eYou choose the kit: §cViking");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Viking");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("ninja"))) {
				p.sendMessage("§eYou choose the kit: §cNinja");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Ninja");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("poseidon"))) {
				p.sendMessage("§eYou choose the kit: §cPoseidon");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Poseidon");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("reaper"))) {
				p.sendMessage("§eYou choose the kit: §cReaper");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Reaper");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("snail"))) {
				p.sendMessage("§eYou choose the kit: §cSnail");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Snail");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("specialist"))) {
				p.sendMessage("§eYou choose the kit: §cSpecialist");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Specialist");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("stomper"))) {
				p.sendMessage("§eYou choose the kit: §cStomper");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Stomper");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Switcher"))) {
				p.sendMessage("§eYou choose the kit: §cSwitcher");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Switcher");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("tank"))) {
				p.sendMessage("§eYou choose the kit: §cTank");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Tank");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("thor"))) {
				p.sendMessage("§eYou choose the kit: §cThor");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Thor");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("timelord"))) {
				p.sendMessage("§eYou choose the kit: §cTimelord");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Timelord");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("turtle"))) {
				p.sendMessage("§eYou choose the kit: §cTurtle");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Turtle");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.membro")) && (args[0].equalsIgnoreCase("Viper"))) {
				p.sendMessage("§eYou choose the kit: §cViper");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Viper");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("worm"))) {
				p.sendMessage("§eYou choose the kit: §cWorm");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Worm");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("Achilles"))) {
				p.sendMessage("§eYou choose the kit: §cAchilles");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Achilles");
				CopyCat.remove(p.getName());
			}
			if ((p.hasPermission("tag.vip")) && (args[0].equalsIgnoreCase("Pyro"))) {
				p.sendMessage("§eYou choose the kit: §cPyro");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
				Habilidade.removeAbility(p);
				Habilidade.setAbility(p, "Pyro");
				CopyCat.remove(p.getName());
			}
			return true;
		}
		return false;
	}
}
