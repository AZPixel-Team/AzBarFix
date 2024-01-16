package com.azpixel.data;

import com.azpixel.AzBarFix;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class AzHotBar {

    public String getBarHealth(Player p){
        double maxHP = Double.parseDouble(PlaceholderAPI.setPlaceholders(p, AzBarFix.getInstance().getConfig().getString("AzHotBar.Health.Max")));
        double currentHP = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Health.Current")));
        double hp = (16/maxHP) * currentHP;
        return String.valueOf((int)hp);
    }
    public String getBarFood(Player p){
        double maxFood = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Food.Max")));
        double currentFood = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Food.Current")));
        double food = (16/maxFood) * currentFood;
        return String.valueOf((int)food);
    }
    public String getBarArmor(Player p){
        double maxArmor = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Armor.Max")));
        double currentArmor = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Armor.Current")));
        double armor = (16/maxArmor) * currentArmor;
        return String.valueOf((int)armor);
    }
    public String getBarOxy(Player p){
        double maxOxy = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Oxy.Max")));
        double currentOxy = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Oxy.Current")));
        double oxy = (16/maxOxy) * currentOxy;
        return String.valueOf((int)oxy);
    }
    public String getBarMana(Player p){
        double maxMana = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Mana.Max")));
        double currentMana = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Mana.Current")));
        double mana = (16/maxMana) * currentMana;
        return String.valueOf((int)mana);
    }
    public String getBarStamina(Player p){
        double maxStamina = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Stamina.Max")));
        double currentStamina = Double.parseDouble(PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("AzHotBar.Stamina.Current")));
        double stamina = (16/maxStamina) * currentStamina;
        return String.valueOf((int)stamina);
    }
}
