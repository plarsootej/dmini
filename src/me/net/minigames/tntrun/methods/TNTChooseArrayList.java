package me.net.minigames.tntrun.methods;

import me.net.minigames.main.MainClass;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TNTChooseArrayList {

	public static void ChooseList(Player p, final String arenaname) {
		if(TNTRunMain.inuse.containsKey("false")) {
			String list = TNTRunMain.inuse.get("false");

			if(list.equals("list1")) {
				TNTRunMain.list1a.add(p);
				TNTRunMain.list1b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list2")) {
				TNTRunMain.list2a.add(p);
				TNTRunMain.list2b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list3")) {
				TNTRunMain.list3a.add(p);
				TNTRunMain.list3b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list4")) {
				TNTRunMain.list4a.add(p);
				TNTRunMain.list4b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list5")) {
				TNTRunMain.list5a.add(p);
				TNTRunMain.list5b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list6")) {
				TNTRunMain.list6a.add(p);
				TNTRunMain.list6b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list7")) {
				TNTRunMain.list7a.add(p);
				TNTRunMain.list7b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list8")) {
				TNTRunMain.list8a.add(p);
				TNTRunMain.list8b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list9")) {
				TNTRunMain.list9a.add(p);
				TNTRunMain.list9b.add(p);
				delay(arenaname, list);
			}
			if(list.equals("list10")) {
				TNTRunMain.list10a.add(p);
				TNTRunMain.list10b.add(p);
				delay(arenaname, list);
			}
			
			
			
		}
		if(TNTRunMain.inuse.containsKey(arenaname)) {
			String list = TNTRunMain.inuse.get(arenaname);
			if(list.equals("list1")) {
				TNTRunMain.list1a.add(p);
				TNTRunMain.list1b.add(p);
			}
			if(list.equals("list2")) {
				TNTRunMain.list2a.add(p);
				TNTRunMain.list2b.add(p);
			}
			if(list.equals("list3")) {
				TNTRunMain.list3a.add(p);
				TNTRunMain.list3b.add(p);
			}
			if(list.equals("list4")) {
				TNTRunMain.list4a.add(p);
				TNTRunMain.list4b.add(p);
			}
			if(list.equals("list5")) {
				TNTRunMain.list5a.add(p);
				TNTRunMain.list5b.add(p);
			}
			if(list.equals("list6")) {
				TNTRunMain.list6a.add(p);
				TNTRunMain.list6b.add(p);
			}
			if(list.equals("list7")) {
				TNTRunMain.list7a.add(p);
				TNTRunMain.list7b.add(p);
			}
			if(list.equals("list8")) {
				TNTRunMain.list8a.add(p);
				TNTRunMain.list8b.add(p);
			}
			if(list.equals("list9")) {
				TNTRunMain.list9a.add(p);
				TNTRunMain.list9b.add(p);
			}
			if(list.equals("list10")) {
				TNTRunMain.list10a.add(p);
				TNTRunMain.list10b.add(p);
			}
		}
		
		
	}
	
	public static void delay(final String arenaname, final String list) {
		long delay = 4;
		Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.main, new Runnable()
        {
                public void run()
                {
                	TNTRunMain.inuse.put(arenaname, list);
                }
        }, delay);
	}

}
