package io.github.fokolo;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class inventoryclicks implements Listener {

	@EventHandler
	public void OnInventoryClick(InventoryClickEvent event) {

		// variables
		Material[] ids = lockitem.items;
		ItemStack item = event.getCurrentItem();
		HumanEntity p = event.getWhoClicked();

		// check
		if (p.getGameMode() != GameMode.CREATIVE && !IgnorePlayers.players.get(p.getName())) {
			if (event.getCurrentItem() != null) {
				for (Material i : ids) {
					if (i == item.getType()) {
						{
							event.setCancelled(true);
							break;
						}
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
}
