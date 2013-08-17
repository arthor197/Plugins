package me.ksmit799197.moderator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Broadcast
{
	public static void server(String m)
	{
		Bukkit.getServer().broadcastMessage(ChatColor.RED+"["+ChatColor.GREEN+"ServerEssentials"+ChatColor.RED+"] "+ChatColor.WHITE+m);
	}
	
	public static void console(String m)
	{
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), m);
	}
	
	public static void player(String c, String p, String m)
	{
		if (Bukkit.getServer().getPlayer(p).isOnline())
		{
			Bukkit.getServer().getPlayer(p).sendMessage(ChatColor.RED+"["+ChatColor.GREEN+"ServerEssentials"+ChatColor.RED+"] "+ChatColor.GRAY+m);
		}
		else if(!Bukkit.getServer().getPlayer(p).isOnline())
		{
			Bukkit.getServer().getPlayer(c).sendMessage(ChatColor.RED+"That person is not online.");
		}
	}
}

