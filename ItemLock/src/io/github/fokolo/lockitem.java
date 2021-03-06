package io.github.fokolo;

import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class lockitem extends JavaPlugin {
	
	static Material[] items;
	
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();

		this.saveDefaultConfig();
		readConfig();
		
		getCommand("itemlock").setExecutor(new IgnorePlayers());
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
			i++;
		}
		
	}

	@Override
	public void onDisable() {

	}
}
