package me.net.minigames.paintball.events;

import me.net.minigames.main.handlers.ConfigHandler;
import me.net.minigames.paintball.PaintBallHandler;
import me.net.minigames.paintball.PaintballMain;
import me.net.minigames.paintball.methods.NormalGunMethod;
import me.net.minigames.paintball.methods.ShotGunMethod;
import me.net.minigames.paintball.methods.SniperMethod;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PaShootEvent {
	
	private static int ShootWeaponID = ConfigHandler.Paintball.getInt("Shoot-Weapon-ID");
	private static int ShotGunID = ConfigHandler.Paintball.getInt("ShotGun-ID");
	private static int SniperID = ConfigHandler.Paintball.getInt("SniperGun-ID");
	private static int DamageGrenadeID = ConfigHandler.Paintball.getInt("Damage-Grenade-ID");
	private static int FlashGrenadeID = ConfigHandler.Paintball.getInt("Flash-Grenade-ID");
	
	@SuppressWarnings("deprecation")
	public static void Shoot(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack inhand = player.getItemInHand();
		if(inhand.getType() == Material.getMaterial(SniperID)) {
			SniperMethod.Sniper(player, event);
		}
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			
			
			if(inhand.getType() == Material.getMaterial(ShootWeaponID)) {
				NormalGunMethod.NormalGun(player);	
			}
			if(inhand.getType() == Material.getMaterial(ShotGunID)) {
				ShotGunMethod.ShotGun(player);
			}

		}
		
		//Damage grenade
		if(event.getAction() == Action.RIGHT_CLICK_AIR) {
			
			if(player.getItemInHand().getType() == Material.getMaterial(DamageGrenadeID)) {
				if(!PaintballMain.grenade.contains(player)){ 
				PaintballMain.grenade.add(player);
				PaintBallHandler.GrenadesCountdowns.d.setList(PaintballMain.grenade);
				PaintBallHandler.GrenadesCountdowns.d.setPlayer(player);
				new Thread(PaintBallHandler.GrenadesCountdowns.d).start();
				final Item grenade = event.getPlayer().getWorld().dropItem(player.getTargetBlock(null, 50).getLocation(), new ItemStack(Material.getMaterial(DamageGrenadeID)));
				
				
				grenade.setVelocity(event.getPlayer().getEyeLocation().getDirection());
				player.getInventory().removeItem(grenade.getItemStack());
				grenade.remove();
				int x = grenade.getLocation().getBlockX();
				int y = grenade.getLocation().getBlockY();
				int z = grenade.getLocation().getBlockZ();
				grenade.getWorld().createExplosion(x, y, z, 4.0F, false, false);
			}
			}
		}
			//Flash Grenade
			if(event.getAction() == Action.RIGHT_CLICK_AIR){
				
				if(player.getItemInHand().getType() == Material.getMaterial(FlashGrenadeID)){
					if(!PaintballMain.flash.contains(player)){ 
						PaintballMain.flash.add(player);
						PaintBallHandler.GrenadesCountdowns.d2.setList(PaintballMain.flash);
						PaintBallHandler.GrenadesCountdowns.d2.setPlayer(player);
						new Thread(PaintBallHandler.GrenadesCountdowns.d2).start();
					final Item flash = event.getPlayer().getWorld().dropItem(player.getTargetBlock(null, 50).getLocation(), new ItemStack(Material.getMaterial(FlashGrenadeID)));
					
					
					flash.setVelocity(event.getPlayer().getEyeLocation().getDirection());
					player.getInventory().removeItem(flash.getItemStack());
					flash.remove();       
					for(Entity e : flash.getNearbyEntities(6, 4, 6)){
			            if(e.getType() == EntityType.PLAYER){
			                Player flashedplayers = (Player) e;
			                
			                
			                flashedplayers.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,(int) 60, 30));
				            flashedplayers.playEffect(flashedplayers.getLocation(), Effect.EXTINGUISH,50);
				            flashedplayers.playEffect(flashedplayers.getLocation(), Effect.GHAST_SHRIEK,50);
			            }
			        }

					}	
					
				}
		
			}
	}

}
