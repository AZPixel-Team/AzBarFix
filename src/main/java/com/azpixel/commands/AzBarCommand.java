package com.azpixel.commands;

import com.azpixel.AzBarFix;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AzBarCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) sender;
        if (sender.hasPermission("azhotbar.admin")) {
            if (strings.length == 0) {
                sender.sendMessage(AzBarFix.getInstance().getConfig().getString("Message.Wrong-Commands"));
                return false;
            } else if (strings[0].equalsIgnoreCase("reload") || strings[0].equalsIgnoreCase("rl")) {
                AzBarFix.getInstance().reloadConfig();
                sender.sendMessage(AzBarFix.getInstance().getConfig().getString("Message.Reload-Successful"));
                return true;
            }
            if (strings[0].equalsIgnoreCase("test")){
                if (sender instanceof Player){
                    sender.sendMessage("Message: " + PlaceholderAPI.setPlaceholders(p,AzBarFix.getInstance().getConfig().getString("Message.Test")));
                    return true;
                }else {
                    sender.sendMessage(AzBarFix.getInstance().getConfig().getString("Message.Console-commands"));
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("azbar") && args.length == 1) {
            ArrayList<String> command = new ArrayList<>();
            command.add("reload");
            return command;
        }
        return null;
    }
}
