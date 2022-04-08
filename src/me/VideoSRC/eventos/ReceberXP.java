package me.VideoSRC.eventos;

import java.util.ArrayList;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.VideoSRC.Main;
import me.VideoSRC.pontos.SistemaPontos;

public class ReceberXP implements Listener {
	public static ArrayList<Player> killss2 = new ArrayList();

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
	if (!(event.getEntity() instanceof Player)) {
				return;
		}
		Player p = (Player) event.getEntity();
		if ((Main.Partida) && (killss2.contains(p)) && (event.getEntity() != null)
				&& (event.getEntity().getKiller() != null) && (event.getEntity().getType() == EntityType.PLAYER)
				&& (event.getEntity().getKiller().getType() == EntityType.PLAYER)) {
			Player killer = event.getEntity().getKiller();
			Player morta = (Player) event.getEntity();
			SistemaPontos.darDinheiro(killer, 5);
			killer.sendMessage("§cPOINTS§7, You received five points!");
		}
	}
}