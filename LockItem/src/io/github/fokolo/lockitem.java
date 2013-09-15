package io.github.fokolo;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class lockitem extends JavaPlugin {
	@Override
    public void onEnable(){
        
		getLogger().info("lockitem enabled");
        
		PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new inventoryclicks(), this);
        pm.registerEvents(new droptest(),this);
        }
 
    @Override
    public void onDisable() {
    	getLogger().info("Disabled");
    }      
}
