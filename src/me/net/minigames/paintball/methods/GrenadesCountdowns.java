package me.net.minigames.paintball.methods;

import java.util.ArrayList;
import java.util.List;

import me.net.minigames.main.MainClass;

import org.bukkit.entity.Player;

public class GrenadesCountdowns {

	MainClass plugin;
	public GrenadesCountdowns (MainClass instance) {
		plugin = instance;
	}
	
	
	public grenadeCountdown d = new grenadeCountdown();
	public fashCountdown d2 = new fashCountdown();
	
	public class grenadeCountdown implements Runnable{

		public Player player1;
		public List<Player> grenade1 = new ArrayList<Player>();
		
		public void setPlayer(Player player){
			player1 = player;
			
		}
		
		public void setList(List<Player> list){
			grenade1 = list;
			
			
		}
		
		public List<Player> getList(){
			return grenade1;
			
		}
		public void run() {
			try{
				Thread.sleep(5000);
					grenade1.remove(player1);
				}catch (Exception ignored){
			}
			
		}
	}

	public class fashCountdown implements Runnable{

		public Player player1;
		public List<Player> flash1 = new ArrayList<Player>();
		
		public void setPlayer(Player player){
			player1 = player;
			
		}
		
		public void setList(List<Player> list){
			flash1 = list;
			
			
		}
		
		public List<Player> getList(){
			return flash1;
			
		}
		public void run() {
			try{
				Thread.sleep(5000);
					flash1.remove(player1);
				}catch (Exception ignored){
			}
			
		}
	}
}
