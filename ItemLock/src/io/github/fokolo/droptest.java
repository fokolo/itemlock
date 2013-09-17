package io.github.fokolo;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class droptest implements Listener {

	@EventHandler
	public void PlayerDropItem(PlayerDropItemEvent event) {
		// variables
		Material[] ids = lockitem.items;
		ItemStack item = event.getItemDrop().getItemStack();
		Player p = event.getPlayer();

		// check
		if (p.getGameMode() != GameMode.CREATIVE && !IgnorePlayers.players.get(p.getName())) {
			for (Material i : ids) {
				if (i == item.getType()) {
					event.setCancelled(true);
					break;
				}
			}
			if (item.getType() == Material.STICK) {
				if (!item.getEnchantments().isEmpty()) {
					event.setCancelled(true);
				}
			}
		}
	}

}
