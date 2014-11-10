package me.net.minigames.tntrun.methods;

import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.entity.Player;

public class TNTCheckList {

	public static void CheckList(Player player, String arenaname) {
		
		if(TNTRunMain.list1a.contains(player)) {
			int size = TNTRunMain.list1a.size();
			if(size >= 1) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list1a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list1a.remove(player);
				
			}

		}
		if(TNTRunMain.list2a.contains(player)) {
			int size = TNTRunMain.list2a.size();
			if(size >= 2) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list2a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list2a.remove(player);
				
			}
		}
		if(TNTRunMain.list3a.contains(player)) {
			int size = TNTRunMain.list3a.size();
			if(size >= 3) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list3a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list3a.remove(player);
				
			}

		}
		if(TNTRunMain.list4a.contains(player)) {
			int size = TNTRunMain.list4a.size();
			if(size >= 4) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list4a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list4a.remove(player);
				
			}

		}
		if(TNTRunMain.list5a.contains(player)) {
			int size = TNTRunMain.list5a.size();
			if(size >= 5) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list5a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list5a.remove(player);
				
			}

		}
		if(TNTRunMain.list6a.contains(player)) {
			int size = TNTRunMain.list6a.size();
			if(size >= 6) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list6a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list6a.remove(player);
				
			}

		}
		if(TNTRunMain.list7a.contains(player)) {
			int size = TNTRunMain.list7a.size();
			if(size >= 7) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list7a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list7a.remove(player);
				
			}

		}
		if(TNTRunMain.list8a.contains(player)) {
			int size = TNTRunMain.list8a.size();
			if(size >= 8) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list8a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list8a.remove(player);
				
			}

		}
		if(TNTRunMain.list9a.contains(player)) {
			int size = TNTRunMain.list9a.size();
			if(size >= 9) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list9a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list9a.remove(player);
				
			}

		}
		if(TNTRunMain.list10a.contains(player)) {
			int size = TNTRunMain.list10a.size();
			if(size >= 10) {
				player.sendMessage("§cToo bad You lost");
				TNTRunMain.list10a.remove(player);
				
			}
			if(size <= 1) {
				player.sendMessage("§acongratulations You won");
				TNTStopGame.StopGame(arenaname);
				TNTRunMain.list10a.remove(player);
				
			}

		}
	}

}
