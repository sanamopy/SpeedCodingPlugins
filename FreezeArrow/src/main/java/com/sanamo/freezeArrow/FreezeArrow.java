package com.sanamo.freezeArrow;

import com.sanamo.freezeArrow.Listeners.ProjectileHitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class FreezeArrow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ProjectileHitEvent(), this);
        getLogger().info("FreezeArrow Plugin is Ready!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
