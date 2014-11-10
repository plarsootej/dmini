package me.net.minigames.main.handlers;

import me.net.minigames.paintball.signs.PaJoinSign;
import me.net.minigames.paintball.signs.PaSpectateSign;
import me.net.minigames.parkour.handlers.PCheckPointHandler;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.parkour.signs.PJoinSign;
import me.net.minigames.spleef.signs.SJoinSign;
import me.net.minigames.spleef.signs.SSpectateSign;
import me.net.minigames.teamdeathmatch.signs.TDMJoinSign;
import me.net.minigames.teamdeathmatch.signs.TDMKitSign;
import me.net.minigames.teamdeathmatch.signs.TDMSpectateSign;
import me.net.minigames.tntrun.signs.TNTJoinSign;
import me.net.minigames.tntrun.signs.TNTSpectateSign;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

public class SignHandler {

	public static void HandlerSigns(Player player, Block block) {
		Sign sign = (Sign) block.getState();
		if(sign.getLine(0).equalsIgnoreCase("§6[DMinigames]")) {
			if(sign.getLine(1).equalsIgnoreCase("§0[§bSpleef§0]")) {
				
				/** Spleef Join Sign **/
				if(sign.getLine(2).equalsIgnoreCase("§aJoin")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					SJoinSign.Join(player, arenaname);
				}
				/** Spleef Spectate Sign**/
				if(sign.getLine(2).equalsIgnoreCase("§aSpectate")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					SSpectateSign.Spectate(player, arenaname);
				}
			}
		}
		if(sign.getLine(0).equalsIgnoreCase("§0[§bParkour§0]")) {
			if(sign.getLine(1).equalsIgnoreCase("§aCheckPoint")) {
				if(ParkourMain.ParkourMain.pdata.plingame.containsKey(player.getName())) {
					PCheckPointHandler.SaveCheckPoint(player, block);
				}
				
			}
		}
		if(sign.getLine(0).equalsIgnoreCase("§6[DMinigames]")) {
			if(sign.getLine(1).equalsIgnoreCase("§0[§bParkour§0]")) {
				
				/** parkour Join Sign **/
				if(sign.getLine(2).equalsIgnoreCase("§aJoin")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					PJoinSign.Join(player, arenaname);
				}

			}
			if(sign.getLine(1).equalsIgnoreCase("§0[§bTDM§0]")) {
				if(sign.getLine(2).equalsIgnoreCase("§aJoin")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					TDMJoinSign.Join(player, arenaname);
				}
				if(sign.getLine(2).equalsIgnoreCase("§aSpectate")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					TDMSpectateSign.Spectate(player, arenaname);
				}
			}
			if(sign.getLine(1).equalsIgnoreCase("§0[§bPaint§0]")) {
				if(sign.getLine(2).equalsIgnoreCase("§aJoin")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					PaJoinSign.Join(player, arenaname);
				}
				if(sign.getLine(2).equalsIgnoreCase("§aSpectate")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					PaSpectateSign.Spectate(player, arenaname);
				}
			}
			if(sign.getLine(1).equalsIgnoreCase("§0[§bTNT Run§0]")) {
				if(sign.getLine(2).equalsIgnoreCase("§aJoin")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					TNTJoinSign.Join(player, arenaname);
				}
				if(sign.getLine(2).equalsIgnoreCase("§aSpectate")) {
					String arenaname = sign.getLine(3).replace("§4", "");
					TNTSpectateSign.Spectate(player, arenaname);
				}
			}
		}
		if(sign.getLine(0).equalsIgnoreCase("§0[§bTDM§0]")) {
			
			
			/** Team DeathMatch Kit sign **/
			if(sign.getLine(1).equalsIgnoreCase("§aKit")) {
				String kitname = sign.getLine(2).replace("§4", "");
				TDMKitSign.kit(player, kitname);
			}
			 
		}
		
	}
	
	

}
