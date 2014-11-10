package me.net.minigames.teamdeathmatch.methods;

import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.teamdeathmatch.handlers.TArenas;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TCountdown {
	private TArenas arena;
	private TeamDeathMatchMain TeamDeathMatchMain;
	
	public TCountdown(TeamDeathMatchMain TDMMain, TArenas arena) {
		this.arena = arena;
		this.TeamDeathMatchMain = TDMMain;
		count = arena.getCountdown();
		
	}

	 private static int runtaskid;
	 static int count;
		public void runArenaCountdown()
	    {
			 
	            arena.setStarting(true);
	            arena.setCounting(true);
	            runtaskid = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.main, new Runnable() 
	            {
	                    public void run()
	                    {
	                            //check if countdown should be stopped for some various reasons
	                            HashSet<String> arenaplayers = TeamDeathMatchMain.pdata.getLobbyPlayers(arena);
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
	                                    
	                                    TeamDeathMatchMain.pdata.getLobbyPlayers(arena).clear();
	                            } else
	                            //countdown
	                            {
	                                    for (String pname : arenaplayers)
	                                    {
	                                            Player p = Bukkit.getPlayerExact(pname);
	                                            p.sendMessage("§aTeam Deathmatch Game Starting in §6" + count + "§a Seconds");
	                                    }
	                                    count--;
	                            }
	                    }
	            }, 0, 20);
	    }
		
		  public void stopArenaCountdown()
	      {
	              arena.setStarting(false);
	              arena.setCounting(false);
	              count = arena.getCountdown();
	              Bukkit.getScheduler().cancelTask(runtaskid);
	      }
		  public void stopArenaCountdown2() {
			  arena.setCounting(false);
			  count = arena.getCountdown();
			  Bukkit.getScheduler().cancelTask(countdown2);
		  }
		  public void startLobbiedRunning() {
			  for(String p : TeamDeathMatchMain.pdata.getLobbyPlayers(arena)) {
				  Player player = Bukkit.getPlayerExact(p);
				  arena.arenaph.startLobbied(player);
			  }
		  }
		  private void startArena() {
			  for(String p : TeamDeathMatchMain.pdata.getArenaPlayers(arena)) {
				  Player player = Bukkit.getPlayerExact(p);
				  arena.arenaph.startGame(player);
				  arena.setRunning(true);
			  }
		  }
		  
		  
		private static int countdown2;
		
		public void Countdown2() {
			arena.setCounting(true);
			countdown2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.main, new Runnable() 
            {
				public void run()
                {
					 HashSet<String> lobbyplayers = TeamDeathMatchMain.pdata.getLobbyPlayers(arena);
					if (lobbyplayers.size() < 1)
                    {

                            stopArenaCountdown2();
                    } else
                    //start arena if countdown is 0
                    if (count == 0)
                    {
                        for (String pname : lobbyplayers)
                        {
                                Player p = Bukkit.getPlayerExact(pname);
                                p.sendMessage("§aGO!");
                        }
                            stopArenaCountdown2();
                            startLobbiedRunning();
                    } else
                    //countdown
                    {
                            for (String pname : lobbyplayers)
                            {
                                    Player p = Bukkit.getPlayerExact(pname);
                                    p.sendMessage("§aJoining Team Deathmatch Game in §6" + count + "§a Seconds");
                            }
                            count--;
                    }
                }
            }, 0, 20);
			
		}

}
