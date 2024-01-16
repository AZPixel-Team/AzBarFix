package com.azpixel.listeners;

import com.azpixel.AzBarFix;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    private void onQuit(PlayerQuitEvent e){
        AzBarFix.getInstance().removeBossBar(e.getPlayer());
    }
}
