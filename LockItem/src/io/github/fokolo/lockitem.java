package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class lockitem extends JavaPlugin {
	
	static Material[] items;
	
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		// Plugin myplugin = pm.getPlugin("LockItem");

		this.saveDefaultConfig();
		readConfig();

		pm.registerEvents(new inventoryclicks(), this);
		pm.registerEvents(new droptest(), this);
	}

	public void readConfig() {
		Integer itemsL = getConfig().getKeys(false).size();
		Integer i = 0;
		items = new Material[itemsL];
		while(i<itemsL){
			String key = i.toString();
			String cItem = getConfig().getString(key+".name");
			items[i]=Material.getMaterial(cItem);
			System.out.println(cItem);
			i++;
		}
		
	}

	@Override
	public void onDisable() {

	}
}
