package me.net.minigames.spleef.methods;

import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class SCountdown {
	
	public static SpleefMain SpleefMain;
	public static SArena arena;
	
	public SCountdown(SpleefMain SpleefMain2, SArena arena2) {
		arena = arena2;
		SpleefMain = SpleefMain2;
		count = arena.getCountdown();
		
	}
	   
	   
    private static int runtaskid;
    static int count;
	public void runArenaCountdown()
    {
            arena.setStarting(true);
            runtaskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.main, new Runnable() 
            {
                    public void run()
                    {
                            //check if countdown should be stopped for some various reasons
                            HashSet<String> arenaplayers = SpleefMain.pdata.getArenaPlayers(arena);
                            if (!arena.isArenaEnabled())
                            {
                                    stopArenaCountdown();
                            } else
                            if (arenaplayers.size() < 1)
                            {
 
                                    stopArenaCountdown();
                            } else
                            //start arena if countdown is 0
                            if (count == 0)
                            {
                                for (String pname : arenaplayers)
                                {
                                        Player p = Bukkit.getPlayerExact(pname);
                                        p.sendMessage("§aGO!");
                                }
                                    stopArenaCountdown();
                                    startArena();
                            } else
                            //countdown
                            {
                                    for (String pname : arenaplayers)
                                    {
                                            Player p = Bukkit.getPlayerExact(pname);
                                            p.sendMessage("§aSpleef Game Starting in §6" + count + "§a Seconds");
                                    }
                                    count--;
                            }
                    }
            }, 0, 20);
    }
	
	  private void stopArenaCountdown()
      {
              arena.setStarting(false);
              count = arena.getCountdown();
              Bukkit.getScheduler().cancelTask(runtaskid);
      }
	  private void startArena() {
		  arena.setRunning(true);
		  HashSet<String> arenaplayers = SpleefMain.pdata.getArenaPlayers(arena);
		  for(String pname : arenaplayers) {
			  Player p = Bukkit.getPlayerExact(pname);
			  arena.arenaph.spawnPlayer(p);
		  }
	  }

}
