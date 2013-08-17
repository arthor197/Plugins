package me.ksmit799197.moderator;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.ksmit799197.moderator.Broadcast;

public class Main extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Disabled");
	}
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled");
	}

	public boolean onCommand(CommandSender s, Command c, String commandLabel, String[] a){
		if(commandLabel.equalsIgnoreCase("freeze")){
			if(a.length == 0)
			{
				return false;
			}
			
			Player t = s.getServer().getPlayer(a[0]);
			
			if(!t.isOnline())
			{
				Broadcast.player(s.getName(), s.getName(), "That person is not online");
				return true;
			}
			else if(t.isOnline() && !(t.getCustomName() == "Frozen"))
			{
				t.setCustomName("Frozen");
				return true;
			}
			else if(t.isOnline() && t.getCustomName() == "Frozen")
			{
				t.setCustomName(t.getDisplayName());
				return true;
			}
		}
		return false;
			
		}
	}	
