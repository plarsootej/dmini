package me.net.minigames.paintball;

import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.methods.GrenadesCountdowns;

public class PaintBallHandler {
	
	static MainClass plugin;
	public PaintBallHandler (MainClass instance) {
		plugin = instance;
	}
	
	//classes
	public static GrenadesCountdowns GrenadesCountdowns;
	
	public static void loadPaintBallClasses () {
		
		GrenadesCountdowns = new GrenadesCountdowns(plugin);
		
	}

}
