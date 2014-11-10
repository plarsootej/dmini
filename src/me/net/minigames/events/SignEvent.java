package me.net.minigames.events;

import me.net.minigames.Permissions.PaintballPermissions;
import me.net.minigames.Permissions.ParkourPermissions;
import me.net.minigames.Permissions.Permissions;
import me.net.minigames.Permissions.SpleefPermissions;
import me.net.minigames.Permissions.TDMPermissions;
import me.net.minigames.Permissions.TNTRunPermissions;
import me.net.minigames.main.MainClass;
import me.net.minigames.paintball.signs.PaintballSigns;
import me.net.minigames.parkour.signs.ParkourSigns;
import me.net.minigames.spleef.signs.SpleefSign;
import me.net.minigames.teamdeathmatch.signs.TeamDeathMatchSigns;
import me.net.minigames.tntrun.signs.TNTRunSigns;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignEvent implements Listener {

	MainClass plugin;

	public SignEvent(MainClass instance) {
		plugin = instance;
	}

	@EventHandler
	public void SignChangeEvent(SignChangeEvent event) {
		final String check = event.getLine(0);
		final String minigame = event.getLine(1);
		final String command = event.getLine(2);
		final Player player = event.getPlayer();

		final String par1 = event.getLine(0);
		final String par2 = event.getLine(1);

		if (check.equalsIgnoreCase("[DMinigames]")) {
			if (minigame.equalsIgnoreCase("[Spleef]")) {
				if (command.equalsIgnoreCase("Join")) {
					if (player.hasPermission(new SpleefPermissions().spleefadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new SpleefPermissions().spleefsign)) {
						SpleefSign.JoinSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fSPLEEF §ajoin sign");
						event.setCancelled(true);
					}

				}
				if (command.equalsIgnoreCase("Spectate")) {
					if (player.hasPermission(new SpleefPermissions().spleefadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new SpleefPermissions().spleefsign)) {
						SpleefSign.SpectateSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fSPLEEF §aSpectate sign");
						event.setCancelled(true);
					}
				}
			}
		}
		if (par1.equalsIgnoreCase("[Parkour]")) {
			if (par2.equalsIgnoreCase("CheckPoint")) {
				if (event.getPlayer().hasPermission(new ParkourPermissions().parkadmin)
						|| player.hasPermission(new Permissions().madmin)
						|| player.hasPermission(new Permissions().msign)
						|| player.hasPermission(new ParkourPermissions().parkoursign)) {
					ParkourSigns.CheckPointSign(event);
				} else {
					player.sendMessage("§cYou Don't have the permission to create a §fParkour §aCheckpoint sign");
					event.setCancelled(true);
				}

			}
		}
		if (check.equalsIgnoreCase("[DMinigames]")) {
			if (minigame.equalsIgnoreCase("[Parkour]")) {
				if (command.equalsIgnoreCase("Join")) {
					if (event.getPlayer().hasPermission(new ParkourPermissions().parkadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new ParkourPermissions().parkoursign)) {
						ParkourSigns.JoinSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fParkour §aJoin sign");
						event.setCancelled(true);
					}

				}
			}
		}
		if (check.equalsIgnoreCase("[DMinigames]")) {
			if (minigame.equalsIgnoreCase("[TDM]")) {
				if (command.equalsIgnoreCase("Join")) {
					if (event.getPlayer().hasPermission(new TDMPermissions().tdmadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new TDMPermissions().tdmsign)) {
						TeamDeathMatchSigns.JoinSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fTeam Deathmatch §aJoin sign");
						event.setCancelled(true);
					}
				}
				if (command.equalsIgnoreCase("spectate")) {
					if (event.getPlayer().hasPermission(new TDMPermissions().tdmadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new TDMPermissions().tdmsign)) {
						TeamDeathMatchSigns.SpectateSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fTeam Deathmatch §aSpectate sign");
						event.setCancelled(true);
					}
				}

			}
			if (minigame.equalsIgnoreCase("paintball")) {
				if (command.equalsIgnoreCase("Join")) {
					if (event.getPlayer().hasPermission(new PaintballPermissions().paintballadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new PaintballPermissions().paintballsign)) {
						PaintballSigns.JoinSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fPaintball §aJoin sign");
						event.setCancelled(true);
					}
				}
				if (command.equalsIgnoreCase("spectate")) {
					if (event.getPlayer().hasPermission(new PaintballPermissions().paintballadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new PaintballPermissions().paintballsign)) {
						PaintballSigns.SpectateSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fPaintball §aSpectate sign");
						event.setCancelled(true);
					}
				}
			}
			if( minigame.equalsIgnoreCase("[TNT Run]")) {
				if(command.equalsIgnoreCase("Join")) {
					if (event.getPlayer().hasPermission(new TNTRunPermissions().tntrunadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new TNTRunPermissions().tntrunsign)) {
						TNTRunSigns.JoinSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fTNT Run §ajoin sign");
						event.setCancelled(true);
					}
				}
				if(command.equalsIgnoreCase("Spectate")) {
					if (event.getPlayer().hasPermission(new TNTRunPermissions().tntrunadmin)
							|| player.hasPermission(new Permissions().madmin)
							|| player.hasPermission(new Permissions().msign)
							|| player.hasPermission(new TNTRunPermissions().tntrunsign)) {
						TNTRunSigns.SpectateSign(event);
					} else {
						player.sendMessage("§cYou Don't have the permission to create a §fTNT Run §aSpectate sign");
						event.setCancelled(true);
					}
				}
			}
		}

		if (check.equalsIgnoreCase("[TDM]")) {
			if (minigame.equalsIgnoreCase("kit")) {
				if (event.getPlayer().hasPermission(new TDMPermissions().tdmadmin)
						|| player.hasPermission(new Permissions().madmin)
						|| player.hasPermission(new Permissions().msign)
						|| player.hasPermission(new TDMPermissions().tdmsign)) {
					TeamDeathMatchSigns.KitSign(event);
				} else {
					player.sendMessage("§cYou Don't have the permission to create a §fTeam Deathmatch §aKit sign");
					event.setCancelled(true);
				}
			}
		}
	}

}
