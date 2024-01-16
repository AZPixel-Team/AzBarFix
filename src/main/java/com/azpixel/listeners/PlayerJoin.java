package com.azpixel.listeners;

import com.azpixel.AzBarFix;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.geysermc.geyser.api.GeyserApi;

public class PlayerJoin implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e){
        if (GeyserApi.api().isBedrockPlayer(e.getPlayer().getUniqueId()))
            AzBarFix.getInstance().createBossBar(e.getPlayer());
    }
}
