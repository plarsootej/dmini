package me.net.minigames.tntrun.commands;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.main.TNTRunMain;
import me.net.minigames.tntrun.messages.TNTMessages;
import me.net.minigames.tntrun.messages.TNTRunMessages;
import me.net.minigames.tntrun.methods.TNTWandTool;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TNTCommandCreate {
	
	public static int ArenaID;
	
	@SuppressWarnings("deprecation")
	public static void TNTCreate(CommandSender sender, String[] args) {
		if(args.length == 2) {
			if(sender instanceof Player) {
				
				Player player = (Player) sender;
				
				String arenaname = args[1];
				if(!TNTRunMain.TNTRunMain.pdata.arenanames.containsKey(arenaname)) {
					if(arenaname.length() <= 15) {
						if(!(TNTWandTool.loc1.isEmpty()) && !(TNTWandTool.loc2.isEmpty())) {
							
							int x1 = TNTWandTool.loc1.get("X");
							int z1 = TNTWandTool.loc1.get("Z");
							int y1 = TNTWandTool.loc1.get("Y");
							String world = TNTWandTool.world.get("World");
							
							int x2 = TNTWandTool.loc2.get("X");
							int z2 = TNTWandTool.loc2.get("Z");
							int y2 = TNTWandTool.loc2.get("Y");
							
							final Location loc1 = new Location(Bukkit.getServer().getWorld(world), x1, y1, z1);
							final Location loc2 = new Location(Bukkit.getServer().getWorld(world), x2, y2, z2);
							
							
							TNTArena arena = new TNTArena(args[1], MainClass.main, TNTRunMain.TNTRunMain);
							
							arena.setArenaPoints(loc1, loc2);
							arena.saveToConfig();
							
							
							
							TNTWandTool.loc1.clear();
							TNTWandTool.loc2.clear();
							TNTWandTool.world.clear();
							
							if(TNTRunMain.wand.contains(sender.getName()) || TNTRunMain.wand.contains(sender)) {
								TNTRunMain.wand.remove(sender.getName());
								TNTRunMain.wand.remove(sender);
							}
							
							sender.sendMessage("§aArena succesfully created!");
							
							
							
							final int WandToolId = ConfigHandler.TNTMainConfig.getInt("Wand-Tool-ID");
							if(player.getInventory().contains(WandToolId)) {
								player.getInventory().remove(WandToolId);
								player.updateInventory();
							}
							
						}else {
							sender.sendMessage("§cLocations are not selected! Type §f/tnt wand");
						}
					}else {
						TNTMessages.sendMessage(player, TNTRunMessages.ToLongName);
					}
				}else {
					sender.sendMessage("§aThat arena already exists!");
					sender.sendMessage("§cTo delete the old arena with name: §6" +arenaname +" §f/tnt delete <arenaname>");
				}
				
			}else {
				TNTMessages.sendMessage(sender, TNTRunMessages.PlayerOnlyCmd);
			}
		}else {
			sender.sendMessage("§cCommand Ussage: §f/tnt create <arenaname>");
		}
	}

}
