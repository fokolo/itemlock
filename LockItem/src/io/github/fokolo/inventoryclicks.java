package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class inventoryclicks implements Listener{

	@EventHandler
	public void OnInventoryClick(InventoryClickEvent event) {

		//vars
		Material[] ids = {Material.BOW,Material.ARROW,Material.IRON_SWORD,Material.ENDER_PEARL,Material.DIAMOND_CHESTPLATE};
		ItemStack item = event.getCurrentItem();
		
		//check
		if (event.getCurrentItem() != null) {
			for(Material i : ids){
				if(i==item.getType())
				{
					event.setCancelled(true);
					break;
				}
			}
			if(item.getType() == Material.STICK){
				if(!item.getEnchantments().isEmpty())
				{
					event.setCancelled(true);
				}
			}
		}
	}
}

