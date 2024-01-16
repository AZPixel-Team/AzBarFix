package com.azpixel.Listener;

import com.azpixel.AzBarFix;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.geysermc.geyser.api.GeyserApi;

public class PlayerQuit implements Listener {

    @EventHandler
    private void onQuit(PlayerQuitEvent e){
        if (GeyserApi.api().isBedrockPlayer(e.getPlayer().getUniqueId()))
            AzBarFix.getInstance().removeBossBar(e.getPlayer());
    }
}
