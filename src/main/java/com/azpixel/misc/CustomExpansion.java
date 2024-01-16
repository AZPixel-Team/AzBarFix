package com.azpixel.misc;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "azhotbar";
    }

    @Override
    public @NotNull String getAuthor() {
        return "ItzMintDzX";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null){
            return "";
        }
        if (params.equals("maxhp"))
            return String.valueOf(player.getMaxHealth());

        if (params.equals("currenthp"))
            return String.valueOf(player.getHealth());

        if (params.equals("maxfood"))
            return String.valueOf(20);

        if (params.equals("currentfood"))
            return String.valueOf(player.getFoodLevel());

        if (params.equals("maxoxy"))
            return String.valueOf(player.getMaximumAir());

        if (params.equals("currentoxy"))
            return String.valueOf(player.getRemainingAir());

        if (params.equals("maxarmor"))
            return String.valueOf(20);

        if (params.equals("currentarmor"))
            return String.valueOf(player.getAttribute(Attribute.GENERIC_ARMOR).getValue());
        return null;
    }
}