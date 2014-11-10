package me.net.minigames.teamdeathmatch.scoreboards;


import java.util.HashMap;



import me.net.minigames.teamdeathmatch.events.TKillEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class TScoreBoard {
	
	private static HashMap<String, Scoreboard> scoreboard = new HashMap<String, Scoreboard>();
	
	public static void CreateScoreBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective(player.getName(), "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("§4" + player.getName());
		
		int killnumber = 0;
		int deathnumber = 0;
		
		Score kills = objective.getScore(Bukkit.getOfflinePlayer("§aKills:"));
		kills.setScore(killnumber);
		Score deaths = objective.getScore(Bukkit.getOfflinePlayer("§aDeaths:"));
		deaths.setScore(deathnumber);
		
		scoreboard.put(player.getName(), board);
	}
	
	public static void loadOnJoin(Player player) {
		CreateScoreBoard(player);
		Scoreboard sb = scoreboard.get(player.getName());
		player.setScoreboard(sb);
	}

	public static void updatekillerScoreBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective(player.getName(), "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("§4" + player.getName());
		
		int killnumber = TKillEvent.kills.get(player.getName());
		int deathnumber;
		if(TKillEvent.deaths.containsKey(player.getName())) {
			deathnumber = TKillEvent.deaths.get(player.getName());
		}else {
			deathnumber = 0;
		}
		
		Score kills = objective.getScore(Bukkit.getOfflinePlayer("§aKills:"));
		kills.setScore(killnumber);
		Score deaths = objective.getScore(Bukkit.getOfflinePlayer("§aDeaths:"));
		deaths.setScore(deathnumber);
		
		scoreboard.put(player.getName(), board);
		
		player.setScoreboard(board);
	}
	public static void updatekdeathScoreBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective(player.getName(), "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("§4" + player.getName());
		
		int deathnumber = TKillEvent.deaths.get(player.getName());
		int killnumber;
		if(TKillEvent.kills.containsKey(player.getName())) {
			killnumber = TKillEvent.kills.get(player.getName());
		}else {
			killnumber = 0;
		}
		
		Score kills = objective.getScore(Bukkit.getOfflinePlayer("§aKills:"));
		kills.setScore(killnumber);
		Score deaths = objective.getScore(Bukkit.getOfflinePlayer("§aDeaths:"));
		deaths.setScore(deathnumber);
		
		scoreboard.put(player.getName(), board);
		
		player.setScoreboard(board);
	}
	
	
	public static void removeScoreBoard(Player player) {
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		
		player.setScoreboard(manager.getNewScoreboard());
	}
	
}
