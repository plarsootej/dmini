package me.net.minigames.Permissions;

import org.bukkit.permissions.Permission;

public class Permissions {
	
	private String n = "dm.";

	
	//Permission groups
	/**Main Permissions**/
	public Permission madmin = new Permission (n+"admin");
	public Permission mmoderator = new Permission(n+"moderator");
	public Permission msign = new Permission("dm.createsign");
	public Permission mreload = new Permission("dm.reload");
	
}
