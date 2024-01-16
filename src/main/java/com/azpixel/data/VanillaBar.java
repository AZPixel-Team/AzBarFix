package com.azpixel.data;

import com.azpixel.AzBarFix;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class VanillaBar {


    public int barHealth(Player p){
        int maxHP = Integer.parseInt(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("HotBar.Health.Max")));
        int currentHP = Integer.parseInt(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("HotBar.Health.Current")));
        int hp = (16 / maxHP) * currentHP;
        return hp;
    }
}
