package io.github.fokolo;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IgnorePlayers implements CommandExecutor {

	static Map<String, Boolean> players = new HashMap<String, Boolean>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		// making sure command is valid
		if (args.length > 2) {
			sender.sendMessage("Too many arguments!");
			showHelp(sender);
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage("Not enough arguments!");
			showHelp(sender);
			return true;
		}
		if (args.length == 2) {
			if (Bukkit.getServer().getPlayer(args[1]) == null) {
				sender.sendMessage(args[1] + "is not online!");
				showHelp(sender);
				return true;
			}
		}else if(!(sender instanceof Player) && args.length == 1){
			sender.sendMessage("as the console you must type a username");
			showHelp(sender);
		}

		// command
		String firstarg = args[0];
		commands firstcommand = commands.valueOf(firstarg);
		switch (firstcommand) {
		case help:
			showHelp(sender);
			break;
		case lock:
			System.out.println("user typed lock");
			if (args.length == 1) {
				players.put(sender.getName(), true);
			} else {
				players.put(args[1], true);
			}
			break;
		case unlock:
			System.out.println("user typed unlock");
			if (args.length == 1) {
				players.put(sender.getName(), false);
			} else {
				players.put(args[1], false);
			}
			break;
		default:
			sender.sendMessage(ChatColor.GREEN + "Type /itemlock help for help");
			break;
		}
		return true;
	}

	void showHelp(CommandSender s) {
		s.sendMessage(ChatColor.RED + "Usage: /itemlock lock [player]");
		s.sendMessage(ChatColor.RED + "or: /itemlock unlock [player]");
	}
}
