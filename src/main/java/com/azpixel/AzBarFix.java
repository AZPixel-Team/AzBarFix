package com.azpixel;

import com.azpixel.Listener.PlayerChangeWorld;
import com.azpixel.Listener.PlayerJoin;
import com.azpixel.Listener.PlayerQuit;
import com.azpixel.commands.AzBarCommand;
import com.azpixel.misc.CustomExpansion;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class AzBarFix extends JavaPlugin implements Listener{

    private final Map<String, CommandExecutor> commandExecutors = new HashMap<>();
    private final Map<Player, BossBar> bb = new HashMap<>();
    private static AzBarFix instance;

    @Override
    public void onEnable() {
        new CustomExpansion().register();
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerCommands("azbar",new AzBarCommand());
        registerEvents(
                new PlayerJoin(),
                new PlayerQuit(),
                new PlayerChangeWorld()
        );
        for (Player p : Bukkit.getOnlinePlayers()) this.createBossBar(p);

        Bukkit.getServer().getScheduler().runTaskTimer(this, ()->{
            for (Map.Entry<Player, BossBar> e : this.bb.entrySet()){
                Player p = e.getKey();
                BossBar b = e.getValue();
                b.setProgress(1.0D);
            }
        }, 0, 10L);
    }

    private void registerCommands(String commandName, CommandExecutor executor){
        getCommand(commandName).setExecutor(executor);
        commandExecutors.put(commandName,executor);
    }
    private void registerEvents(Listener... listeners){
        PluginManager pluginManager = Bukkit.getPluginManager();
        Arrays.stream(listeners).forEach(listener -> pluginManager.registerEvents(listener,this));
    }
    public static AzBarFix getInstance(){
        return instance;
    }

    public void createBossBar(Player p) {
        BossBar bb = Bukkit.createBossBar("VeryGay", BarColor.YELLOW, BarStyle.SOLID);
        bb.addPlayer(p);
        this.bb.put(p, bb);
        bb.setVisible(true);
    }
    public void removeBossBar(Player p) {
        if (this.bb.containsKey(p)) {
            BossBar b = this.bb.get(p);
            b.removeAll();
            this.bb.remove(p);
        }
    }
    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers())
            this.removeBossBar(p);
    }
}
