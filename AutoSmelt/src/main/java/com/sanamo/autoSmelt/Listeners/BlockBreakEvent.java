package com.sanamo.autoSmelt.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

import static com.sanamo.autoSmelt.AutoSmelt.AutoSmeltToggled;

public class BlockBreakEvent implements Listener {

    private final Map<Material, Material> Drop = Map.of(
            Material.IRON_ORE, Material.IRON_INGOT,
            Material.GOLD_ORE, Material.GOLD_INGOT,
            Material.COPPER_ORE, Material.COPPER_INGOT,
            Material.ANCIENT_DEBRIS, Material.NETHERITE_INGOT,
            Material.DEEPSLATE_IRON_ORE, Material.IRON_INGOT,
            Material.DEEPSLATE_GOLD_ORE, Material.GOLD_INGOT,
            Material.DEEPSLATE_COPPER_ORE, Material.COPPER_INGOT
    );

    @EventHandler
    public void onBlockBreakEvent(org.bukkit.event.block.BlockBreakEvent event) {
        if (AutoSmeltToggled.contains(event.getPlayer().getUniqueId())) {
            Material blockBroken = event.getBlock().getBlockData().getMaterial();
            if (Drop.containsKey(blockBroken)) {
                Material dropItem = Drop.get(blockBroken);
                event.setDropItems(false);
                event.getBlock().getWorld().dropItemNaturally(
                        event.getBlock().getLocation(),
                        new ItemStack(dropItem)
                );
            }
        }
    }
}
