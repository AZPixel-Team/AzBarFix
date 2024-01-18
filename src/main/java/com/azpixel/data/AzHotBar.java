package com.azpixel.data;

import com.azpixel.AzBarFix;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class AzHotBar {

    private String calculateBarValue(Player p, String maxPath, String currentPath) {
        double max = Double.parseDouble(PlaceholderAPI.setPlaceholders(p, AzBarFix.getInstance().getConfig().getString(maxPath)));
        double current = Double.parseDouble(PlaceholderAPI.setPlaceholders(p, AzBarFix.getInstance().getConfig().getString(currentPath)));
        double result = (AzBarFix.getInstance().getConfig().getDouble("index") / max) * current;
        return String.valueOf((int) result);
    }

    public String getBarHealth(Player p) {
        return calculateBarValue(p, "AzHotBar.Health.Max", "AzHotBar.Health.Current");
    }

    public String getBarFood(Player p) {
        return calculateBarValue(p, "AzHotBar.Food.Max", "AzHotBar.Food.Current");
    }

    public String getBarArmor(Player p) {
        return calculateBarValue(p, "AzHotBar.Armor.Max", "AzHotBar.Armor.Current");
    }

    public String getBarOxy(Player p) {
        return calculateBarValue(p, "AzHotBar.Oxy.Max", "AzHotBar.Oxy.Current");
    }

    public String getBarMana(Player p) {
        return calculateBarValue(p, "AzHotBar.Mana.Max", "AzHotBar.Mana.Current");
    }

    public String getBarStamina(Player p) {
        return calculateBarValue(p, "AzHotBar.Stamina.Max", "AzHotBar.Stamina.Current");
    }
}
