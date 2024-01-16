package com.azpixel.Listener;

import com.azpixel.AzBarFix;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.geysermc.geyser.api.GeyserApi;

public class PlayerChangeWorld implements Listener {

    @EventHandler
    private void onChangeWorld(PlayerChangedWorldEvent e){
        if (GeyserApi.api().isBedrockPlayer(e.getPlayer().getUniqueId())){
            AzBarFix.getInstance().removeBossBar(e.getPlayer());
            Bukkit.getScheduler().runTaskLater(AzBarFix.getInstance(),()-> AzBarFix.getInstance().createBossBar(e.getPlayer()),20);
        }
    }
}
