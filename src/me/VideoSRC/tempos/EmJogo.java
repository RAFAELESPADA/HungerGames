package me.VideoSRC.tempos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.ScoreboardManager;

import de.Herbystar.TTA.Scoreboard.TTA_Scoreboards;
import me.VideoSRC.Main;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.Strings;
import me.VideoSRC.comandos.CMDArena;
import me.VideoSRC.comandos.CMDListener;
import me.VideoSRC.feasteminifeast.BonusFeast;
import me.VideoSRC.feasteminifeast.FeastManager;
import me.VideoSRC.feasteminifeast.MiniFeast;
import me.VideoSRC.feasteminifeast.MiniFeast2;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.pontos.SistemaPontos;


public class EmJogo {
	private static Integer shed_id = null;

	public static void Checar() {
		ChecarVitoria.verificaWin();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
			}
		}, 600L);
	}

	public static void Iniciar(int Contagem) {
		Main.Andamento = Contagem;
		shed_id = Integer
				.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
					public void run() {
						Main.Andamento += 1;
						if (Main.Andamento == 450) {
							MiniFeast.announceFeast();
						}
						if (Main.Andamento == 850) {
							MiniFeast2.announceFeast();
						}
						if (Main.Andamento == 900) {
							FeastManager.announceFeast(Integer.valueOf(5));
						}
						if (Main.Andamento == 960) {
							FeastManager.announceFeast(Integer.valueOf(4));
						}
						if (Main.Andamento == 1020) {
							FeastManager.announceFeast(Integer.valueOf(3));
						}
						if (Main.Andamento == 1080) {
							FeastManager.announceFeast(Integer.valueOf(2));
						}
						if (Main.Andamento == 1140) {
							FeastManager.announceFeast(Integer.valueOf(1));
						}
						if (Main.Andamento == 1195) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f5 §7segundos!");
						}
						if (Main.Andamento == 1196) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f4 §7segundos!");
						}
						if (Main.Andamento == 1197) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f3 §7segundos!");
						}
						if (Main.Andamento == 1198) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f2 §7segundos!");
						}
						if (Main.Andamento == 1199) {
							DecimalFormat df = new DecimalFormat("##.#");
							Bukkit.broadcastMessage("§eO Feast nascera nas coordenadas §f"
									+ df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f "
									+ df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f1 §7segundo!");
						}
						if (Main.Andamento == 1200) {
							FeastManager.spawnFeast();
						}
						if (Main.Andamento == 2400) {
							BonusFeast.announceFeast(Integer.valueOf(1));
							BonusFeast.spawnFeast();
						}
						if (Main.Andamento == 3000) {
							CMDArena.criarAreaBatle();
							Bukkit.broadcastMessage("§eArena final gerada!");
						}
						if (Main.Andamento == 4400) {
							Bukkit.shutdown();
						}
						Bukkit.getPluginManager().callEvent(new Segundos());
					}
				}, 0L, 20L));
	}

	public static void cancel() {
		if (shed_id != null) {
			Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
			shed_id = null;
		}
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

	@SuppressWarnings({ "deprecation" })
	public static void scoreAndamento(Player p) {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
            public void run() {
		for (Player p1 : Bukkit.getOnlinePlayers()) {

			
		String kit = Habilidade.NomeDoKit(Habilidade.getAbility(p1));
		int millis = Main.Andamento * 1000;
		SimpleDateFormat df = new SimpleDateFormat("mm:ss");
		String time = df.format(Integer.valueOf(millis));
		int online = Bukkit.getOnlinePlayers().size();
		
		
		ArrayList scoreboard = new ArrayList();
	    scoreboard.add("");
	    scoreboard.add("§fTime §7" + StringTimer.TimerGame(Main.Andamento));
	    scoreboard.add("§fPlayers §7" + online + "/" + Bukkit.getServer().getMaxPlayers());
	    scoreboard.add("§fKit §a" + kit);
	    scoreboard.add("");
	    scoreboard.add("§fRank §a" + Rank(p1));
	    scoreboard.add("§fGroup §a" + Main.getGroup(p1));
	    scoreboard.add("§fKills §a" + CMDListener.getKs(p1));
	    scoreboard.add("");
	    scoreboard.add("  §a" + Main.site + " ");
	    TTA_Scoreboards s = new TTA_Scoreboards(p, Arrays.asList("§aHG", "§bHG", "§cHG", "§fHG" , "§9HG" , "§1HG" , "§8HG" , "§4HG"), scoreboard);
	}
            }
        },  0L, 20L);
	}

	public static void resetScoreboard(Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		p.setScoreboard(manager.getNewScoreboard());
	}
}
