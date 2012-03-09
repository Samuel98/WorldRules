package uk.co.jacekk.bukkit.worldrules;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WorldRulesWorldRulesExecutor implements CommandExecutor {
	
	private WorldRules plugin;
	
	public WorldRulesWorldRulesExecutor(WorldRules plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if (args.length == 0){
			sender.sendMessage(ChatColor.RED + "Usage: /worldrules <option> [args]");
			sender.sendMessage(ChatColor.RED + "Available Options:");
			sender.sendMessage(ChatColor.RED + "  reload - Reloads the rules from the config file.");
			return true;
		}
		
		String option = args[0];
		
		if (option.equalsIgnoreCase("reload") || option.equalsIgnoreCase("r")){
			plugin.config.reload();
			sender.sendMessage(ChatColor.GREEN + "WorldRules configuration reloaded.");
		}
		
		return true;
	}
	
}
