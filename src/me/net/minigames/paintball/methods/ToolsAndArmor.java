package me.net.minigames.paintball.methods;

import me.net.minigames.main.handlers.ConfigHandler;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

@SuppressWarnings("deprecation")
public class ToolsAndArmor {
	
	
	public static void getBlueArmor(Player player) {
		//helmet
			ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
			helmMeta.setColor(Color.BLUE);
			helmMeta.setDisplayName("§9Blue Team Helmet");
			helm.setItemMeta(helmMeta);
			player.getInventory().setHelmet(helm);
			
			//chestplate
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestplateMeta.setColor(Color.BLUE);
			chestplateMeta.setDisplayName("§9Blue Team chestplate");
			chestplate.setItemMeta(chestplateMeta);
			player.getInventory().setChestplate(chestplate);
			
			//leggings
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			leggingsMeta.setColor(Color.BLUE);
			leggingsMeta.setDisplayName("§9Blue Team leggings");
			leggings.setItemMeta(leggingsMeta);
			player.getInventory().setLeggings(leggings);
			
			//boots
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLUE);
			bootsMeta.setDisplayName("§9Blue Team boots");
			boots.setItemMeta(bootsMeta);
			player.getInventory().setBoots(boots);
			player.updateInventory();
		
	}
	 
		public static void getRedArmor(Player player) {
				//helmet
				ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
				LeatherArmorMeta helmMeta = (LeatherArmorMeta) helm.getItemMeta();
				helmMeta.setColor(Color.RED);
				helmMeta.setDisplayName("§cRed Team Helmet");
				helm.setItemMeta(helmMeta);
				player.getInventory().setHelmet(helm);
				
				//chestplate
				ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
				chestplateMeta.setColor(Color.RED);
				chestplateMeta.setDisplayName("§cRed Team chestplate");
				chestplate.setItemMeta(chestplateMeta);
				player.getInventory().setChestplate(chestplate);
				
				//leggings
				ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
				LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
				leggingsMeta.setColor(Color.RED);
				leggingsMeta.setDisplayName("§cRed Team leggings");
				leggings.setItemMeta(leggingsMeta);
				player.getInventory().setLeggings(leggings);
				
				//boots
				ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
				bootsMeta.setColor(Color.RED);
				bootsMeta.setDisplayName("§cRed Team boots");
				boots.setItemMeta(bootsMeta);
				player.getInventory().setBoots(boots);
				player.updateInventory();
			
		}
		
		public static void getTools(Player player) {
			Inventory pi = player.getInventory();
			
			/** ID's **/
			final int ShootWeaponID = ConfigHandler.Paintball.getInt("Weapons.Shoot-Weapon-ID");
			final int ShotGunID = ConfigHandler.Paintball.getInt("Weapons.ShotGun-ID");
			final int SniperID = ConfigHandler.Paintball.getInt("Weapons.SniperGun-ID");
			final int DamageGrenadeID = ConfigHandler.Paintball.getInt("Weapons.Damage-Grenade-ID");
			final int FlashGrenadeID = ConfigHandler.Paintball.getInt("Weapons.Flash-Grenade-ID");
			
			/** Names **/
			final String ShootWeaponName = ConfigHandler.Paintball.getString("Weapons.Shoot-Weapon-Name");
			final String ShotGunName = ConfigHandler.Paintball.getString("Weapons.ShotGun-Name");
			final String SniperName = ConfigHandler.Paintball.getString("Weapons.SniperGun-Name");
			final String DamageGrenadeName = ConfigHandler.Paintball.getString("Weapons.Damage-Grenade-Name");
			final String FlashGrenadeName = ConfigHandler.Paintball.getString("Weapons.Flash-Grenade-Name");
			
			if(ShootWeaponName != "None" && ShootWeaponName != null) {
				ItemStack shootweapon = new ItemStack(Material.getMaterial(ShootWeaponID));
				ItemMeta shootMeta = shootweapon.getItemMeta();
				shootMeta.setDisplayName(ShootWeaponName);
				shootweapon.setItemMeta(shootMeta);
				player.getInventory().addItem(shootweapon);
			}else {
				ItemStack shootweapon = new ItemStack(Material.getMaterial(ShootWeaponID));
				ItemMeta shootMeta = shootweapon.getItemMeta();
				shootMeta.setDisplayName(shootMeta.getDisplayName());
				shootweapon.setItemMeta(shootMeta);
				player.getInventory().addItem(shootweapon);
			}

			if(ShotGunName != "None" && ShotGunName != null) {
				ItemStack shotgun = new ItemStack(Material.getMaterial(ShotGunID));
				ItemMeta shotgunmeta = shotgun.getItemMeta();
				shotgunmeta.setDisplayName(ShotGunName);
				shotgun.setItemMeta(shotgunmeta);
				player.getInventory().addItem(shotgun);
			}else {
				ItemStack shotgun = new ItemStack(Material.getMaterial(ShotGunID));
				ItemMeta shotgunmeta = shotgun.getItemMeta();
				shotgunmeta.setDisplayName(shotgunmeta.getDisplayName());
				shotgun.setItemMeta(shotgunmeta);
				player.getInventory().addItem(shotgun);
			}
			if(SniperName != "None" && SniperName != null) {
				ItemStack sniper = new ItemStack(Material.getMaterial(SniperID));
				ItemMeta snipermeta = sniper.getItemMeta();
				snipermeta.setDisplayName(SniperName);
				sniper.setItemMeta(snipermeta);
				player.getInventory().addItem(sniper);
			}else {
				ItemStack sniper = new ItemStack(Material.getMaterial(SniperID));
				ItemMeta snipermeta = sniper.getItemMeta();
				snipermeta.setDisplayName(snipermeta.getDisplayName());
				sniper.setItemMeta(snipermeta);
				player.getInventory().addItem(sniper);
			}
			
			if(DamageGrenadeName != "None" && DamageGrenadeName != null) {
				ItemStack DamageGrenade = new ItemStack(Material.getMaterial(DamageGrenadeID));
				ItemMeta DamageGrenademeta = DamageGrenade.getItemMeta();
				DamageGrenademeta.setDisplayName(DamageGrenadeName);
				DamageGrenade.setItemMeta(DamageGrenademeta);
				player.getInventory().addItem(DamageGrenade);
			}else {
				ItemStack DamageGrenade = new ItemStack(Material.getMaterial(DamageGrenadeID));
				ItemMeta DamageGrenademeta = DamageGrenade.getItemMeta();
				DamageGrenademeta.setDisplayName(DamageGrenademeta.getDisplayName());
				DamageGrenade.setItemMeta(DamageGrenademeta);
				player.getInventory().addItem(DamageGrenade);
			}
			
			if(DamageGrenadeName != "None" && DamageGrenadeName != null) {
				ItemStack FlashGrenade = new ItemStack(Material.getMaterial(FlashGrenadeID));
				ItemMeta FlashGrenademeta = FlashGrenade.getItemMeta();
				FlashGrenademeta.setDisplayName(FlashGrenadeName);
				FlashGrenade.setItemMeta(FlashGrenademeta);
				player.getInventory().addItem(FlashGrenade);
			}else {
				ItemStack FlashGrenade = new ItemStack(Material.getMaterial(FlashGrenadeID));
				ItemMeta FlashGrenademeta = FlashGrenade.getItemMeta();
				FlashGrenademeta.setDisplayName(FlashGrenademeta.getDisplayName());
				FlashGrenade.setItemMeta(FlashGrenademeta);
				player.getInventory().addItem(FlashGrenade);
			}
			

			

			
			ItemStack[] snowballs = {new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.SNOW_BALL, 16)};
			pi.addItem(snowballs);
			player.updateInventory();
		}


}
