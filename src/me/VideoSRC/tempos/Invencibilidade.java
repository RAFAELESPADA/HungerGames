package me.VideoSRC.tempos;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import de.Herbystar.TTA.Scoreboard.TTA_Scoreboards;
import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.comandos.CMDListener;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.pontos.SistemaPontos;

public class Invencibilidade {
	private static Integer shed_id;

	public static Scoreboard getScoreBoard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}

	public static void resetScoreboard(Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		p.setScoreboard(manager.getNewScoreboard());
	}

	public static String Rank(Player p) {

		double a = SistemaPontos.MostrarDinheiroPlayer(p);
		if (a <= 500.0D) {
			return "§7Bronze";
		}
		if (a <= 1500.0D) {
			return "§6Gold";
		}
		if (a <= 2500.0D) {
			return "§fPlatina";
		}
		if (a <= 3500.0D) {
			return "§bDiamond";
		}
		if (a <= 5000.0D) {
			return "§cRuby";
		}
		return "§cRuby";
	}

	public Invencibilidade() {
		shed_id = Integer
				.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
					public void run() {
						if (Main.TimerInvencibilidade.intValue() > 0) {
							if (((Main.TimerInvencibilidade.intValue() >= 10 ? 1 : 0)
									& (Main.TimerInvencibilidade.intValue() % 10 == 0 ? 1 : 0)) != 0) {
								if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() == 60)) {
									((World) Bukkit.getServer().getWorlds().get(0)).setDifficulty(Difficulty.PEACEFUL);
									Bukkit.broadcastMessage("§eInvencilibity ends on: §c01:00");
								}
								if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() == 30)) {
									Bukkit.broadcastMessage("§eInvencilibity ends on: §c00:30");
								}
								if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() == 10)) {
									Bukkit.broadcastMessage("§eInvencilibity ends on: §c00:10");
								}
							} else if ((Main.PreInvencibilidade) && (Main.TimerInvencibilidade.intValue() < 6)) {
								Bukkit.broadcastMessage("§eInvencilibity ends on: §c"
										+ StringTimer.TimerGame(Integer.valueOf(Main.TimerInvencibilidade.intValue())));
								Player[] arrayOfPlayer;
								for (Player pl : Bukkit.getOnlinePlayers()) {
									pl.playSound(pl.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
								}
							}
							Main.TimerInvencibilidade = Integer.valueOf(Main.TimerInvencibilidade.intValue() - 1);
							
						} else {
							EmJogo.Iniciar(120);
							Invencibilidade.cancel();
							Bukkit.broadcastMessage("§eInvencilibity ended!");
							Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.NORMAL);
							Main.PreInvencibilidade = false;
							Main.Partida = true;
							ChecarVitoria.verificaWin();
							for (Player pl : Bukkit.getOnlinePlayers()) {

								pl.playSound(pl.getLocation(), Sound.BLOCK_ANVIL_LAND, 30.0F, 30.0F);
								Invencibilidade.resetScoreboard(pl);
								EmJogo.scoreAndamento(pl);
							}
							if (Main.Partida) {
								new EmJogo();
								Invencibilidade.cancel();
							}
						}				
				
		if (Main.PreInvencibilidade) {
			for (Player p : Bukkit.getOnlinePlayers()) {

				String kit = Habilidade.NomeDoKit(Habilidade.getAbility(p));
				
				
				ArrayList scoreboard = new ArrayList();
              	scoreboard.add("");
        		
              	scoreboard.add("§fInvencible for §7" + StringTimer.TimerGame(Main.TimerInvencibilidade));
              	scoreboard.add("§fPlayers §7" + Main.Jogadores.size() + "/"
						+ Bukkit.getServer().getMaxPlayers());
              	scoreboard.add("§fKit §a" + kit);
              	scoreboard.add("");
              	scoreboard.add("§fRank §a" + Rank(p));
              	scoreboard.add("");
              	scoreboard.add("§fGroup §a" + Main.getGroup(p));
              	scoreboard.add("§fKills §a" + CMDListener.getKs(p));
              	scoreboard.add("");
              	scoreboard.add("  §a" + Main.site + " ");
              	TTA_Scoreboards s = new TTA_Scoreboards(p, Arrays.asList("§aHG", "§bHG", "§cHG", "§fHG" , "§9HG" , "§1HG" , "§8HG" , "§4HG"), scoreboard);
			}}}}
		, 0L, 20L));
					}
	

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
	}
}
