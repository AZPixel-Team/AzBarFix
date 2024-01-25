package com.azpixel.misc;

import com.azpixel.data.AzHotBar;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomExpansion extends PlaceholderExpansion {

    private static final int DEFAULT_MAX_VALUE = 20;
    private static final String IDENTIFIER = "azhotbar";
    private static final String AUTHOR = "ItzMintDzX";
    private static final String VERSION = "1.0";
    private static final AzHotBar az = new AzHotBar();
    private final Map<String, Function<Player, String>> placeholderHandlers = new HashMap<>();

    public CustomExpansion() {
        // Basic placeholders
        addPlaceholder("maxhp", p -> String.valueOf(p.getMaxHealth()));
        addPlaceholder("currenthp", p -> String.valueOf(p.getHealth()));
        addPlaceholder("maxfood", p -> String.valueOf(DEFAULT_MAX_VALUE));
        addPlaceholder("currentfood", p -> String.valueOf(p.getFoodLevel()));
        addPlaceholder("maxoxy", p -> String.valueOf(p.getMaximumAir()));
        addPlaceholder("currentoxy", p -> String.valueOf(p.getRemainingAir()));
        addPlaceholder("maxarmor", p -> String.valueOf(DEFAULT_MAX_VALUE));
        addPlaceholder("currentarmor", p -> String.valueOf(p.getAttribute(Attribute.GENERIC_ARMOR).getValue()));
        addPlaceholder("maxmana", p -> PlaceholderAPI.setPlaceholders(p, "%mmocore_stat_max_mana%"));
        addPlaceholder("currentmana", p -> PlaceholderAPI.setPlaceholders(p, "%mmocore_mana%"));
        addPlaceholder("maxstamina", p -> PlaceholderAPI.setPlaceholders(p, "%mmocore_stat_max_stamina%"));
        addPlaceholder("currentstamina", p -> PlaceholderAPI.setPlaceholders(p, "%mmocore_stamina%"));

        // Main expansion placeholders

        addPlaceholder("hp", az::getBarHealth);
        addPlaceholder("food", az::getBarFood);
        addPlaceholder("oxy", az::getBarOxy);
        addPlaceholder("armor", az::getBarArmor);
        addPlaceholder("mana", az::getBarMana);
        addPlaceholder("stamina", az::getBarStamina);
    }

    private void addPlaceholder(String name, Function<Player, String> handler) {
        placeholderHandlers.put(name, handler);
    }

    @Override
    public @NotNull String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public @NotNull String getAuthor() {
        return AUTHOR;
    }

    @Override
    public @NotNull String getVersion() {
        return VERSION;
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
        if (player == null) {
            return "";
        }
        Function<Player, String> handler = placeholderHandlers.get(params);
        if (handler != null) {
            return handler.apply(player);
        }
        return null;
    }
}
