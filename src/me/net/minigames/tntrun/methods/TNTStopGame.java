package me.net.minigames.tntrun.methods;

import java.util.List;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.tntrun.locations.TNTTeleportLoc;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TNTStopGame {

	public static void StopGame(String arenaname) {
		
		TNTRunMain.running.put(arenaname, "false");
		
		TNTRestoreArena.restoreArena(arenaname);
		
		String list = TNTRunMain.inuse.get(arenaname);
		if(list.equals("list1")) {
			TNTRunMain.list1a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list1b.contains(p)) {
					Leave(p);
				}
			}
		}
		if(list.equals("list6")) {
			TNTRunMain.list6a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list6b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list3")) {
			TNTRunMain.list3a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list3b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list4")) {
			TNTRunMain.list4a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list4b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list5")) {
			TNTRunMain.list5a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list5b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list6")) {
			TNTRunMain.list6a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list6b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list7")) {
			TNTRunMain.list7a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list7b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list8")) {
			TNTRunMain.list8a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list8b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list9")) {
			TNTRunMain.list9a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list9b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		if(list.equals("list10")) {
			TNTRunMain.list10a.clear();
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(TNTRunMain.list10b.contains(p)) {
					Leave(p);
				}
			}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void Leave(Player p) {
		
		final String arenaname = TNTRunMain.joined.get(p.getName());
		//load inventory
		p.sendMessage("§aInventory Loaded");
		
		@SuppressWarnings("unchecked")
		List<ItemStack> savedInv = (List<ItemStack>)ConfigHandler.TNTInventories.get("Inventories."+p.getName());
		ItemStack[] inv = savedInv.toArray(new ItemStack[]{new ItemStack(Material.AIR, 1)});
		p.getInventory().setContents(inv);
		final int level = ConfigHandler.TNTInventories.getInt(p.getName() + "Level");
		p.setLevel(level);

		
		ConfigHandler.TNTInventories.removeKey("Inventories." + p.getName());
		ConfigHandler.TNTInventories.saveConfig();
		
		p.updateInventory();
		
		if(TNTRunMain.lobby.containsKey(p.getName())) {
			TNTRunMain.lobby.remove(p.getName());
		}
		if(TNTRunMain.joined.containsKey(p.getName())) {
			TNTRunMain.joined.remove(p.getName());
		}
		if(ConfigHandler.TNTUsers.contains(p.getName())) {
			final String world = ConfigHandler.TNTUsers.getString(p.getName() + ".JoinLoc.World");
			final int x = ConfigHandler.TNTUsers.getInt(p.getName() + ".JoinLoc.X");
			final int y = ConfigHandler.TNTUsers.getInt(p.getName() + ".JoinLoc.Y");
			final int z = ConfigHandler.TNTUsers.getInt(p.getName() + ".JoinLoc.Z");
			
			Location loc = new Location(Bukkit.getServer().getWorld(world), x, y, z);
			p.teleport(loc);
			
			ConfigHandler.TNTUsers.removeKey(p.getName());
			ConfigHandler.TNTUsers.saveConfig();
			
			
		}else {
			TNTTeleportLoc.TeleportLobbyLoc(p, arenaname);
		}
	}

}
