package me.net.minigames.main;

import java.io.IOException;
import java.util.logging.Logger;

import me.net.minigames.events.BlockBreak;
import me.net.minigames.events.BlockDamage;
import me.net.minigames.events.DamageEvent;
import me.net.minigames.events.DeathEvent;
import me.net.minigames.events.InteractEvent;
import me.net.minigames.events.ItemDrop;
import me.net.minigames.events.LeaveEvent;
import me.net.minigames.events.MoveEvent;
import me.net.minigames.events.RespawnEvent;
import me.net.minigames.events.SignEvent;
import me.net.minigames.events.TeleportEvent;
import me.net.minigames.main.handlers.ClassHandler;
import me.net.minigames.main.handlers.CommandHandler;
import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.main.handlers.MetricsHandler;
import me.net.minigames.main.handlers.Updater;
import me.net.minigames.main.handlers.Updater.UpdateType;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.methods.SniperMethod;
import me.net.minigames.parkour.main.ParkourMain;
import me.net.minigames.spleef.handlers.SArena;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.tntrun.main.TNTRunMain;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin{
	
	//classes
	public ClassHandler ch;
	public CommandHandler CommandHandler;
	public ConfigHandler ConfigHandler;
	public static MainClass main;
	public SpleefMain SpleefMain;
	public ParkourMain ParkourMain;
	public TeamDeathMatchMain TeamDeathMatchMain;
	public PaintballMain PaintballMain;
	public TNTRunMain TNTRunMain;
	public Updater Updater;
	
	public static Logger logger = Logger.getLogger("Minecraft");
	
	

	
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
		
	    if(this.getFile().getName().contains("-DEV")) {
	    	System.out.print("Loading DMinigames -DEV" + this.getDescription().getVersion());
	    	try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }

		main = this;
		ch = new ClassHandler(this);
		CommandHandler = new CommandHandler(this);
		ConfigHandler = new ConfigHandler(this);
		SpleefMain = new SpleefMain(this);
		ParkourMain = new ParkourMain(this);
		PaintballMain = new PaintballMain(this);
		TeamDeathMatchMain = new TeamDeathMatchMain();
		TNTRunMain = new TNTRunMain(this);
		ConfigHandler.LoadYamls();
		System.out.println("Loading DracinisMinigames...");
		PaintballMain.enablePaintBall();
		TeamDeathMatchMain.enableTDM();
		SpleefMain.EnableSpleef();
		TNTRunMain.EnableTNTRun();
		ParkourMain.enableParkour();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new BlockBreak(this), this);
		pm.registerEvents(new BlockDamage(this), this);
		pm.registerEvents(new DamageEvent(this), this);
		pm.registerEvents(new DeathEvent(this), this);
		pm.registerEvents(new InteractEvent(this), this);
		pm.registerEvents(new LeaveEvent(this), this);
		pm.registerEvents(new MoveEvent(this), this);
		pm.registerEvents(new RespawnEvent(this), this);
		pm.registerEvents(new SignEvent(this), this);
		pm.registerEvents(new ItemDrop(this), this);
		pm.registerEvents(new TeleportEvent(this), this);
		
		

		System.out.println("Paintball Succesfully loaded");
		System.out.println("Loading TeamDeathMatch");
		System.out.println("Team Deathmatch Succesfully loaded!");
		System.out.println("Loading Spleef");
		System.out.println("Spleef succesfully Enabled");
		System.out.println("Loading TNT Run");
		System.out.println("TNT Run Succesfully loaded!");
		System.out.println("Loading Parkour");
		System.out.println("Parkour Sucessfully loaded!");
		
		//updating
		if(this.getFile().getName().contains("-DEV")) {
			System.out.print("DMinigames is running on DEVELOPMENT BUILD, Updater Disabled");
		}else {
			if(ConfigHandler.MainConfig.getBoolean("Auto-Update-Download") == true) {
				Updater = new Updater(this, 63172, this.getFile(), UpdateType.DEFAULT, true);
			}
		}
		
		ch.LoadClasses();
		CommandHandler.ExecuteCommands();
		
		
		//Metrics
		
        try {
            MetricsHandler metrics = new MetricsHandler(this);
            metrics.start();
        } catch (IOException e) {
            // Failed to submit the stats :-(
        }
		

        
        
        if(SniperMethod.zoomLevels.isEmpty()) {
			SniperMethod.zoomLevels.add(3);
			SniperMethod.zoomLevels.add(8);
			SniperMethod.zoomLevels.add(10);
			SniperMethod.zoomLevels.add(15);
        }
        


	}
	
	@Override
	public void onDisable() {
		
		ch.DisableLeave.LeaveOnDisable();
		System.out.println("DracinisMinigames Disabled!");
		
        for (SArena arena : SpleefMain.pdata.getArenas())
        {
                arena.saveToConfig();
        }
        TeamDeathMatchMain.disableTDM();
        PaintballMain.disablePaintball();
        ch.TNTRunMain.DisableTNTRun();
	}

}
