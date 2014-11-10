package me.net.minigames.main.handlers;

import me.net.minigames.main.MainClass;
import me.net.minigames.main.methods.DisableLeave;
import me.net.minigames.paintball.PaintBallHandler;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.spleef.main.SpleefMain;
import me.net.minigames.teamdeathmatch.main.TeamDeathMatchMain;
import me.net.minigames.tntrun.main.TNTRunMain;

public class ClassHandler {
	
	MainClass plugin;
	public ClassHandler (MainClass instance) {
		plugin = instance;
	}
	
	//classes
	public PaintballMain PaintBallMain;
	public static PaintBallHandler PaintBallHandler;
	public TeamDeathMatchMain TeamDeathMatchMain;
	public SpleefMain SpleefMain;
	public TNTRunMain TNTRunMain;
	public DisableLeave DisableLeave;
	
	public void LoadClasses() {
		TeamDeathMatchMain = new TeamDeathMatchMain();
		PaintBallHandler = new PaintBallHandler(plugin);
		DisableLeave = new DisableLeave(plugin);
		TNTRunMain = new TNTRunMain(plugin);
	}

}
