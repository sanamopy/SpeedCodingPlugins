package com.sanamo.autoSmelt;

import com.sanamo.autoSmelt.Commands.AutoSmeltCommand;
import com.sanamo.autoSmelt.Listeners.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class AutoSmelt extends JavaPlugin {
    public static List<UUID> AutoSmeltToggled = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("autosmelt")).setExecutor(new AutoSmeltCommand());
        getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this);
        getLogger().info("AutoSmelt successfully loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
