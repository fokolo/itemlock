package io.github.fokolo;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class IgnorePlayers {

	static Map<String, Boolean> players = new HashMap<String, Boolean>();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("unlock")) {
			if (args[0] == null) {
				if (players.containsKey(sender.getName())) {
					players.remove(sender.getName());
					players.put(sender.getName(), true);
				} else {
					players.put(sender.getName(), true);
				}
			} else {
				if (Bukkit.getServer().getPlayer(args[0]) == null) {
					sender.sendMessage("Invalid username");
					return false;
				} else {
					if (players.containsKey(sender.getName())) {
						players.remove(sender.getName());
						players.put(args[0], true);
					} else {
						players.put(args[0], true);
					}

				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("lock")) {
			if (args[0] == null) {
				if (players.containsKey(sender.getName())) {
					players.remove(sender.getName());
					players.put(sender.getName(), false);
				} else {
					players.put(sender.getName(), false);
				}
			} else {
				if (Bukkit.getServer().getPlayer(args[0]) == null) {
					sender.sendMessage("Invalid username");
					return false;
				} else {
					if (players.containsKey(sender.getName())) {
						players.remove(sender.getName());
						players.put(args[0], false);
					} else {
						players.put(args[0], false);
					}

				}
			}

		}
		return true;
	}
}
