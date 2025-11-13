package com.sanamo.freezeArrow.Listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ProjectileHitEvent implements Listener {

    @EventHandler
    public void onProjectileHitEvent(org.bukkit.event.entity.ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof Arrow arrow)) {return;}
        if (!(arrow.getShooter() instanceof org.bukkit.entity.Player)) return;

        Entity hitEntity = event.getHitEntity();
        if (hitEntity instanceof LivingEntity living) {
            living.addPotionEffect(new PotionEffect(
                    PotionEffectType.SLOWNESS,
                    3 * 20, // 3 seconds (20 ticks per second)
                    255,    // amplifier 255 = completely immobile
                    false, false, true
            ));
            living.getWorld().playSound(living.getLocation(), "block.snow.break", 1f, 1f);
        }
    }
}
