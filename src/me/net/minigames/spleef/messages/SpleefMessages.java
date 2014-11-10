package me.net.minigames.spleef.messages;

import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SpleefMessages {
	
	public static String Lose = "§aToo Bad, You Lost!";
	public static String Winner = "§aYou have Won the game!";
	public static String DeletedArena = "§aArena Succesfully deleted!";
	public static String ArenaDoesntExists = "§cThat Arena doesn't exists!";
	public static String ArenaDisabled = "§aArena succesfully disabled!";
	public static String ArenaEnabled = "§aArea succesfully enabled";
	public static String spectate = "§aYou are now spectating!";
	public static String PlayerOnlyCmd = "§cPlayer Command Only!";
	public static String Permmss = "§cYou don't have the permission to use that command!";
	public static String leaveMessage = "§aYou have succesfully left Spleef Minigame!";
	public static String kicked = "§aYou have been kicked from the spleef minigame!";
	public static String joinedtoothers = "§f{PLAYER} §aJoined the Spleef Minigame!";
	public static String leavedtoothers = "§f{PLAYER} §aLeft the spleef minigame!";
	public static String kickedtoothers = "§f{PLAYER} §aHas been kicked from the Spleef Minigame!";
	public static String Disabling = "§aDisabling all arena's for reloading";
	public static String ToLongName = "§cArena Name cannot be longer than 15 Characters!";
	public static String arenaStillRunning = "§cThat arena is still running!";
	
	public static void JoinMessage(Player player) {
		SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
		String arenaname = arena.getArenaName();
		player.sendMessage("§aYou have succesfully joined Spleef game in arena: §f" + arenaname);
	}
	public static void DisabledArena(Player player) {
		SArena arena = SpleefMain.SpleefMain.pdata.getPlayerArena(player.getName());
		String arenaname = arena.getArenaName();
		player.sendMessage("§f " + arenaname + "§c Is Disabled!");
	}
	public static void NotConfigured(Player player, String arenaname) {
		
		player.sendMessage("§f " + arenaname + "§c Is Not Configured!, Contact an admin");
	}
	public static void LostToOtherPlayers(SArena arena, Player player) {
		for(String p : SpleefMain.SpleefMain.pdata.getArenaPlayers(arena)) {
			Player targetP = Bukkit.getServer().getPlayerExact(p);
			targetP.sendMessage("§f" + player.getName() + " §a Fell");
		}
		
	}

}
