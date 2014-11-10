package me.net.minigames.paintball.handlers;

import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.PaintballMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PACountdown {
	private PAArenas arena;
	public PaintballMain PaintballMain;
	
	public PACountdown(PaintballMain paintballmain, PAArenas paArenas) {
		this.arena = paArenas;
		this.PaintballMain = paintballmain;
		count = paArenas.getCountdown();
		
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
	                            HashSet<String> arenaplayers = PaintballMain.pdata.getLobbyPlayers(arena);
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
	                                    
	                                    PaintballMain.pdata.getLobbyPlayers(arena).clear();
	                            } else
	                            //countdown
	                            {
	                                    for (String pname : arenaplayers)
	                                    {
	                                            Player p = Bukkit.getPlayerExact(pname);
	                                            p.sendMessage("§aPaitball Game Starting in §6" + count + "§a Seconds");
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
			  for(String p : PaintballMain.pdata.getLobbyPlayers(arena)) {
				  Player player = Bukkit.getPlayerExact(p);
				  arena.arenaph.startLobbied(player);
			  }
		  }
		  private void startArena() {
			  for(String p : PaintballMain.pdata.getArenaPlayers(arena)) {
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
					 HashSet<String> lobbyplayers = PaintballMain.pdata.getLobbyPlayers(arena);
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
                                    p.sendMessage("§aJoining Paitball Game in §6" + count + "§a Seconds");
                            }
                            count--;
                    }
                }
            }, 0, 20);
			
		}

}
