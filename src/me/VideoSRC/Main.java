package me.VideoSRC;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;

import me.VideoSRC.api.Arquivos;
import me.VideoSRC.api.EspectadoresManager;
import me.VideoSRC.api.Habilidade;
import me.VideoSRC.api.SecondEvent;
import me.VideoSRC.api.Strings;
import me.VideoSRC.borda.BorderBlocks;
import me.VideoSRC.borda.BorderMove;
import me.VideoSRC.borda.BorderType;
import me.VideoSRC.borda.WorldBorder;
import me.VideoSRC.comandos.CMDAdmin;
import me.VideoSRC.comandos.CMDArena;
import me.VideoSRC.comandos.CMDDano;
import me.VideoSRC.comandos.CMDFeast;
import me.VideoSRC.comandos.CMDInv;
import me.VideoSRC.comandos.CMDJogo;
import me.VideoSRC.comandos.CMDKit;
import me.VideoSRC.comandos.CMDKitDisable;
import me.VideoSRC.comandos.CMDKitDisableAll;
import me.VideoSRC.comandos.CMDListener;
import me.VideoSRC.comandos.CMDPvP;
import me.VideoSRC.comandos.CMDSkit;
import me.VideoSRC.comandos.CMDSpec;
import me.VideoSRC.comandos.CMDSpecTp;
import me.VideoSRC.comandos.CMDStart;
import me.VideoSRC.comandos.CMDTeleportar;
import me.VideoSRC.comandos.CMDTell;
import me.VideoSRC.comandos.CMDTimer;
import me.VideoSRC.comandos.CMDWatch;
import me.VideoSRC.eventos.Compass;
import me.VideoSRC.eventos.DanoEvt;
import me.VideoSRC.eventos.DeathPlayerMSG;
import me.VideoSRC.eventos.DropItem;
import me.VideoSRC.eventos.EventosExtras;
import me.VideoSRC.eventos.IniciandoEvt;
import me.VideoSRC.eventos.LoadKits;
import me.VideoSRC.eventos.LoadTag;
import me.VideoSRC.eventos.PreAndamento;
import me.VideoSRC.eventos.PreDeathEvt;
import me.VideoSRC.eventos.PreGameEvt;
import me.VideoSRC.eventos.PreInvencibilidadeEvt;
import me.VideoSRC.eventos.PreJoin;
import me.VideoSRC.eventos.ReceberXP;
import me.VideoSRC.kits.Achilles;
import me.VideoSRC.kits.Anchor;
import me.VideoSRC.kits.BungeeAPI;
import me.VideoSRC.kits.CopyCat;
import me.VideoSRC.kits.Crafter;
import me.VideoSRC.kits.Cultivator;
import me.VideoSRC.kits.Demoman;
import me.VideoSRC.kits.Endermage;
import me.VideoSRC.kits.Enderman;
import me.VideoSRC.kits.Fireman;
import me.VideoSRC.kits.Fisherman;
import me.VideoSRC.kits.Forger;
import me.VideoSRC.kits.Gladiator;
import me.VideoSRC.kits.Hulk;
import me.VideoSRC.kits.JackHammer;
import me.VideoSRC.kits.Jellyfish;
import me.VideoSRC.kits.Kangaroo;
import me.VideoSRC.kits.KangarooPreGame;
import me.VideoSRC.kits.Launcher;
import me.VideoSRC.kits.Lumberjack;
import me.VideoSRC.kits.Madman;
import me.VideoSRC.kits.Miner;
import me.VideoSRC.kits.Monk;
import me.VideoSRC.kits.Ninja;
import me.VideoSRC.kits.Poseidon;
import me.VideoSRC.kits.Pyro;
import me.VideoSRC.kits.Reaper;
import me.VideoSRC.kits.Snail;
import me.VideoSRC.kits.Specialist;
import me.VideoSRC.kits.Stomper;
import me.VideoSRC.kits.Surprise;
import me.VideoSRC.kits.Switcher;
import me.VideoSRC.kits.Tank;
import me.VideoSRC.kits.Thor;
import me.VideoSRC.kits.Timelord;
import me.VideoSRC.kits.Tower;
import me.VideoSRC.kits.Turtle;
import me.VideoSRC.kits.Viking;
import me.VideoSRC.kits.Viper;
import me.VideoSRC.kits.Worm;
import me.VideoSRC.menus.GuiRank;
import me.VideoSRC.menus.MenuKits1;
import me.VideoSRC.outros.ChecarVitoria;
import me.VideoSRC.outros.Manager;
import me.VideoSRC.pontos.SistemaPontos;
import me.VideoSRC.tempos.Iniciando;
import me.VideoSRC.tempos.Invencibilidade;
import me.VideoSRC.utils.MyConfigManager;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;

public class Main extends JavaPlugin implements Listener {
	public static Plugin instance;
	public static Main main;
	public static Iniciando GAMESTATE;
	public static boolean PreGame;
	public static boolean PreInvencibilidade;
	public static boolean Partida;
	public static boolean Finalizando;
	public static boolean Dano;
	public static Plugin plugin;
	public static Main pl;
	public static int Andamento = 0;
	public static Integer TimerIniciando = Integer.valueOf(300);
	public static Integer TimerInvencibilidade = Integer.valueOf(120);
	public static FileConfiguration config;
	public static Logger log = Logger.getLogger("Minecraft");
	public static Boolean Feast = Boolean.valueOf(true);
	public static Integer TempoFeast = Integer.valueOf(300);
	public static Boolean BausFeast = Boolean.valueOf(true);
	public static List<String> saiu = new ArrayList();
	static BukkitScheduler sh = Bukkit.getScheduler();
	public static Integer MinimoJogadores = Integer.valueOf(3);
	public static Boolean ProtecaoFeast = Boolean.valueOf(true);
	public static ArrayList<String> Watch = new ArrayList();
	public static ArrayList<String> mortos = new ArrayList();
	public static ArrayList<String> score = new ArrayList<>();
	public static ArrayList<Block> blockf = new ArrayList();
	public static List<Player> Tempo = new ArrayList();
	public static ArrayList<String> Relogar = new ArrayList();
	public static ArrayList<String> Jogadores = new ArrayList();
	public static HashMap<String, ItemStack[]> skit = new HashMap();
	public static HashMap<String, ItemStack[]> armor = new HashMap();
	public static final Random RANDOM = new Random();
	public static String nomeserver;	
	public static String scoreb;
	public static String site;
	public static String reload;
	public static String auto1;
	public static String auto2;
	public static String auto3;

	public void onLoad() {
		Bukkit.getLogger().info("Removing world!");
		Bukkit.getServer().unloadWorld("world", false);
		deletarMundo(new File("world"));
	}

	public static Main getMain() {
		return main;
	}

	@SuppressWarnings("unused")
	public void onEnable() {
		plugin = this;

		getLogger().info(" ");
		getLogger().info(" ");

		getServer().getPluginManager().registerEvents(this, this);
		getConfig().addDefault("Time", Integer.valueOf(10));
		Bukkit.getWorld("world").setSpawnLocation(0, 120, 0);

		String nomeserver2 = getConfig().getString("nomeserver");
		String nome2 = getConfig().getString("nome");
		String site2 = getConfig().getString("site");
		String rel = getConfig().getString("reload");
		String rel2 = getConfig().getString("auto1");
		String rel3 = getConfig().getString("auto2");
		String rel4 = getConfig().getString("auto3");
		nomeserver = nomeserver2;
		scoreb = nome2;
		site = site2;
		reload = rel;
		auto1 = rel2;
		auto2 = rel3;
		auto3 = rel4;
        plugin = this;
		instance = this;
		PreGame = true;
		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider != null) {
		    LuckPerms api = provider.getProvider();
		    
		}
		new Iniciando();
		new Surprise();
		Jogadores.clear();
		saveDefaultConfig();
		config = getConfig();
		KangarooPreGame.Kangaroo = true;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Eventos();
		Comandos();
		Arquivos();
		KitHabilidades();
		Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.HARD);

		ItemStack Resultado = new ItemStack(Material.MUSHROOM_STEW, 1);
		ItemMeta Cactos = Resultado.getItemMeta();
		Resultado.setItemMeta(Cactos);

		ShapelessRecipe CraftCactos = new ShapelessRecipe(Resultado);
		CraftCactos.addIngredient(2, Material.CACTUS);
		CraftCactos.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCactos);
		ItemMeta Cocoa = Resultado.getItemMeta();
		Resultado.setItemMeta(Cocoa);

		ShapelessRecipe CraftCocoa = new ShapelessRecipe(Resultado);
		CraftCocoa.addIngredient(1, Material.COCOA_BEANS);
		CraftCocoa.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa);
		ItemMeta Flores = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores);
		
		ShapelessRecipe CraftCocoa1 = new ShapelessRecipe(Resultado);
		CraftCocoa1.addIngredient(1, Material.SEAGRASS);
		CraftCocoa1.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa1);
		ItemMeta Flores1 = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores1);
		
		ShapelessRecipe CraftCocoa2 = new ShapelessRecipe(Resultado);
		CraftCocoa2.addIngredient(1, Material.APPLE);
		CraftCocoa2.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa2);
		ItemMeta Flores2 = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores2);
		
		ShapelessRecipe CraftCocoa3 = new ShapelessRecipe(Resultado);
		CraftCocoa3.addIngredient(1, Material.WHEAT_SEEDS);
		CraftCocoa3.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa3);
		ItemMeta Flores3 = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores3);
		
		ShapelessRecipe CraftCocoa4 = new ShapelessRecipe(Resultado);
		CraftCocoa4.addIngredient(1, Material.BEETROOT_SEEDS);
		CraftCocoa4.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa4);
		ItemMeta Flores4 = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores4);
		
		ShapelessRecipe CraftCocoa5 = new ShapelessRecipe(Resultado);
		CraftCocoa5.addIngredient(1, Material.LILY_PAD);
		CraftCocoa5.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa5);
		ItemMeta Flores5 = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores5);
		
		ShapelessRecipe CraftCocoa6 = new ShapelessRecipe(Resultado);
		CraftCocoa6.addIngredient(1, Material.CARROT);
		CraftCocoa6.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa6);
		ItemMeta Flores6 = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores6);

		ShapelessRecipe CraftFlores = new ShapelessRecipe(Resultado);
		CraftFlores.addIngredient(1, Material.DANDELION);
		CraftFlores.addIngredient(1, Material.POPPY);
		CraftFlores.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftFlores);
		BorderBlocks.GerarBorda();
		SistemaPontos.manager = new MyConfigManager(this);
		SistemaPontos.CarregarDinheiro();
		BorderBlocks.GerarBorda();
		instance = this;
		getLogger().info("HG PLUGIN LOADED!");
	}

	public static void deletarMundo(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				deletarMundo(new File(dir, children[i]));
			}
		}
		dir.delete();
}


	public void Arquivos() {
		instance = this;
		new Arquivos();
	}

	

	public static Location getFeastLocation() {
		Random random = new Random();
		Location startFrom = ((World) Bukkit.getWorlds().get(0)).getSpawnLocation();
		Location loc;
		do {
			loc = startFrom.clone();
			loc.add((random.nextBoolean() ? 1 : -1) * random.nextInt(100), 60.0D,
					(random.nextBoolean() ? 1 : -1) * random.nextInt(100));
			int newY = ((World) Bukkit.getWorlds().get(0)).getHighestBlockYAt(loc);
			loc.setY(newY);
		} while (!WorldBorder.inBorder(loc, BorderType.WARN));
		return loc;
	}

	public void onDisable() {
		Jogadores.clear();
		Bukkit.getServer().getScheduler().cancelTasks(instance);;
		for (Player p : Bukkit.getOnlinePlayers()) {
			BungeeAPI.send(p, "lobby");
		}
		Bukkit.shutdown();
	}

	public void Comandos() {
		getCommand("start").setExecutor(new CMDStart());
		getCommand("kit").setExecutor(new CMDKit());
		getCommand("admin").setExecutor(new CMDAdmin(this));
		getCommand("specs").setExecutor(new CMDSpec());
		getCommand("game").setExecutor(new CMDJogo());
		getCommand("pvp").setExecutor(new CMDPvP());
		getCommand("ir").setExecutor(new CMDSpecTp());
		getCommand("forcefeast").setExecutor(new CMDFeast());
		getCommand("feast").setExecutor(new CMDFeast());
		getCommand("tell").setExecutor(new CMDTell());
		getCommand("tp").setExecutor(new CMDTeleportar());
		getCommand("s").setExecutor(new CMDTeleportar());
		getCommand("arena").setExecutor(new CMDArena());
		getCommand("inv").setExecutor(new CMDInv());
		getCommand("tpall").setExecutor(new CMDTimer());
		getCommand("invencibility").setExecutor(new CMDTimer());
		getCommand("hgtime").setExecutor(new CMDTimer());
		getCommand("pregame").setExecutor(new CMDTimer());
		getCommand("toggle").setExecutor(new CMDKitDisableAll());
		getCommand("togglekit").setExecutor(new CMDKitDisable());
		getCommand("watch").setExecutor(new CMDWatch());
		getCommand("damage").setExecutor(new CMDDano());
		getCommand("skit").setExecutor(new CMDSkit());
	}
	
	public void Eventos() {
		Bukkit.getServer().getPluginManager().registerEvents(new PreGameEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new IniciandoEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreInvencibilidadeEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreDeathEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreAndamento(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CMDListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new LoadTag(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DeathPlayerMSG(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CMDKitDisable(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DropItem(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Endermage(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Pyro(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CMDAdmin(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PreJoin(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new KangarooPreGame(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ChecarVitoria(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EspectadoresManager(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Compass(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new MenuKits1(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GuiRank(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EventosExtras(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new ReceberXP(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BorderMove(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new DanoEvt(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BorderMove(), this);
	}

	public void KitHabilidades() {
		Bukkit.getServer().getPluginManager().registerEvents(new Crafter(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Cultivator(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Demoman(), this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new Fisherman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Tower(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new JackHammer(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Forger(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CopyCat(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Gladiator(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Viking(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fireman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Hulk(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Jellyfish(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Achilles(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Kangaroo(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Enderman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Lumberjack(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Miner(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Anchor(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Monk(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Ninja(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Poseidon(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Reaper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Snail(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Specialist(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Stomper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Switcher(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Madman(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Tank(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Surprise(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Thor(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Timelord(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Launcher(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Turtle(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Viper(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Worm(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CMDAdmin(this), this);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Bukkit.getPluginManager().callEvent(new SecondEvent());
			}
		}, 20L, 60L);
	}

	public static Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin("CriticalMC");
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Strings.server);
			return true;
		}
		if (args.length < 1) {
			return true;
		}
		Player player = Bukkit.getPlayer(args[0]);
		if (player == null) {
			sender.sendMessage("§cJogador offline ou invalido!");
			return true;
		}
		sender.hasPermission("tag.mod");

		sender.sendMessage(Strings.perm);

		return true;
	}

	@EventHandler
	public void CommandPartida(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if ((Partida) && (event.getMessage().toLowerCase().startsWith("/kit "))) {
			p.sendMessage("§cThe game already starts!");
			event.setCancelled(true);
			return;
		}
	}

	ArrayList<String> NoKit = new ArrayList();

	@EventHandler
	public void NoKit(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if ((this.NoKit.contains(p.getName())) && (event.getMessage().toLowerCase().startsWith("/kit "))) {
			p.sendMessage("§cThe game already starts!");
			event.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void KitAndamento(PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (PreInvencibilidade) {
			if ((Habilidade.getAbility(p).equalsIgnoreCase("None")) && (p.hasPermission("HungerGames.Kit5"))) {
				if (e.getMessage().contains("/kit ")) {
					e.setCancelled(false);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(instance, new Runnable() {
						public void run() {
							LoadKits.CheckKits(p);
							Main.this.NoKit.add(p.getName());
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							if (Habilidade.getAbility(p).equalsIgnoreCase("Surprise")) {
								Surprise.setSurprise(p);
							}
						}
					}, 25L);
				}
			} else if (e.getMessage().contains("/kit ")) {
				e.setCancelled(true);
			}
		}
	}

	public static void IniciarPartida() {
		Iniciando.cancel();
		new Invencibilidade();
		PreGame = false;
		CMDKitDisable.KitsDisable = false;
		PreInvencibilidade = true;
		IniciandoEvt.Teleportar = false;
		((World) Bukkit.getServer().getWorlds().get(0)).setStorm(false);
		((World) Bukkit.getServer().getWorlds().get(0)).setThundering(false);
		Bukkit.broadcastMessage("§eInvencibility Ends on: §c02:00");
		Bukkit.getServer().getWorld("world").setDifficulty(Difficulty.NORMAL);
		for (Player Participando : Bukkit.getOnlinePlayers()) {
			if (Jogadores.contains(Participando.getName())) {
				Iniciando.RelogPreGame.remove(Participando);
				Participando.setAllowFlight(false);
				Participando.playSound(Participando.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 4.0F, 4.0F);
				Participando.setFlying(false);
				Participando.getInventory().clear();
				ReceberXP.killss2.add(Participando);
				Manager.darBussola(Participando);
				LoadKits.CheckKits(Participando);
				Participando.setHealth(20.0D);
				Participando.setFoodLevel(20);
				Participando.setFireTicks(0);
				Participando.setExhaustion(20.0F);
				if (Habilidade.getAbility(Participando).equalsIgnoreCase("Surprise")) {
					Surprise.setSurprise(Participando);
				}
			}
		}
	}

	public static String getGroup(Player p) {
		LuckPerms api = LuckPermsProvider.get();
		User user = api.getUserManager().getUser(p.getName());
		String prefix = user.getCachedData().getMetaData().getPrefix().replace("&", "§");
	    String spawnLocation = prefix;
	    return spawnLocation;
	}

}
