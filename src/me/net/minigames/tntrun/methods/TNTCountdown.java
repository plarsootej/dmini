package me.net.minigames.tntrun.methods;

import java.util.HashSet;

import me.net.minigames.main.MainClass;
import me.net.minigames.tntrun.handlers.TNTArena;
import me.net.minigames.tntrun.handlers.TNTPlayerDataStore;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TNTCountDown {
	private TNTArena arena;
	private TNTRunMain TNTRunMain;
	
	public TNTCountDown(TNTRunMain TNTRunMain, TNTArena arena) {
		this.arena = arena;
		this.TNTRunMain = TNTRunMain;
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
	                            HashSet<String> arenaplayers = TNTRunMain.pdata.getLobbyPlayers(arena);
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
	                                        p.sendMessage("§aYou have §f10 §aSeconds to find you start possition!");
	                                        
	                                }
	                                    stopArenaCountdown();
	                                    startArena();
	                                    startGameCountdown();
	                                    
	                                    TNTRunMain.pdata.getLobbyPlayers(arena).clear();
	                            } else
	                            //countdown
	                            {
	                                    for (String pname : arenaplayers)
	                                    {
	                                            Player p = Bukkit.getPlayerExact(pname);
	                                            p.sendMessage("§aTeleporting to TNT Arena in §6" + count + "§a Seconds");
	                                    }
	                                    count--;
	                            }
	                    }


	            }, 0, 20);
	    }
		
		private int countdown3;
		private int count3 = 10;
		public void startGameCountdown() {
			arena.setCounting(true);
			countdown3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.main, new Runnable() 
            {
				public void run()
                {
					 HashSet<String> lobbyplayers = TNTRunMain.pdata.getArenaPlayers(arena);
					if (lobbyplayers.size() < 1)
                    {

                            stopArenaCountdown3();
                    } else
                    //start arena if countdown is 0
                    if (count3 == 0)
                    {
                        for (String pname : lobbyplayers)
                        {
                                Player p = Bukkit.getPlayerExact(pname);
                                p.sendMessage("§aGO!");
                                startGame(p);
                                stopArenaCountdown3();
                        }
                           
                           
                    } else
                    //countdown
                    {
                            for (String pname : lobbyplayers)
                            {
                                    Player p = Bukkit.getPlayerExact(pname);
                                    p.sendMessage("§aTNT Run game starts in §6" + count3 + "§a Seconds");
                            }
                            count3--;
                    }
                }
            }, 0, 20);
			
		}
		
		public void startGame(Player player) {
			TNTPlayerDataStore.playing.add(player.getName());
			
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
		  
		  public void stopArenaCountdown3() {
			  count3 = 10;
			  Bukkit.getScheduler().cancelTask(countdown3);
		  }
		  public void startLobbiedRunning() {
			  for(String p : TNTRunMain.pdata.getLobbyPlayers(arena)) {
				  Player player = Bukkit.getPlayerExact(p);
				  arena.arenaph.startLobbied(player);
			  }
		  }
		  private void startArena() {
			  for(String p : TNTRunMain.pdata.getArenaPlayers(arena)) {
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
					 HashSet<String> lobbyplayers = TNTRunMain.pdata.getLobbyPlayers(arena);
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
