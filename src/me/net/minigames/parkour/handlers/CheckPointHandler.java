package me.net.minigames.parkour.handlers;

import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.messages.Messages;
import me.net.minigames.parkour.messages.ParkourMessages;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class CheckPointHandler {

	@SuppressWarnings("deprecation")
	public static void SaveCheckPoint(Player player, Block block) {
		Sign sign = (Sign) block.getState();
		String arenaname = sign.getLine(2).replace("§4", "");
		String checkpoint = sign.getLine(3);
		int checkpointint = Integer.parseInt(checkpoint);
		String oldcheckpoint = ParkourMain.ParkourMain.pdata.getPlayerCheckPoint(player.getName());
		int oldcheckpointint = Integer.parseInt(oldcheckpoint);
		if(ParkourMain.ParkourMain.pdata.arenanames.containsKey(arenaname)) {
			if(oldcheckpointint < checkpointint) {
				ParkourMain.ParkourMain.pdata.setPlayerCheckpoint(player.getName(), checkpoint);
				player.sendMessage("§aSuccesully reached checkpoint :§6" + checkpoint);
				player.playEffect(player.getLocation(), Effect.POTION_BREAK, 2);
				player.setFoodLevel(20);
			}else {
				player.sendMessage("§aYou have already reached this checkpoint");
			}
			
		}else {
			Messages.sendMessage(player, ParkourMessages.ArenaDoesntExists);
		}
		
	}

	public static void CreateCheckPoint(Location loc, String checkpoint, String arenaname) {
		PArena arena = ParkourMain.ParkourMain.pdata.getArenaByName(arenaname);
		arena.addCheckPoint(loc, checkpoint);
		arena.saveToConfig();
	}

}
