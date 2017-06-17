package me.angrypostman.invisiblebats;

import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class InvisibleBats extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new Listener() {

            @EventHandler
            public void onCreatureSpawn(CreatureSpawnEvent event) {
                if (event.getEntityType()== EntityType.BAT)  {
                    Bat bat = (Bat) event.getEntity();
                    bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 999999999));
                }
            }

        }, this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

}
