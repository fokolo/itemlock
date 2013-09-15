package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class droptest implements Listener {

	@EventHandler
	public void PlayerDropItem(PlayerDropItemEvent event) {
		//vars
		Material[] ids = {Material.BOW,Material.ARROW,Material.IRON_SWORD,Material.ENDER_PEARL,Material.DIAMOND_CHESTPLATE};
		ItemStack item = event.getItemDrop().getItemStack();
		
		//check
		for (Material i : ids) {
			if (i == item.getType()) {
				event.setCancelled(true);
				break;
			}
		}
		if(item.getType()==Material.STICK){
			if(!item.getEnchantments().isEmpty())
			{
				event.setCancelled(true);
			}
		}
	}

}
