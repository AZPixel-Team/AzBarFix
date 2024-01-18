package com.azpixel.commands;

import com.azpixel.AzBarFix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AzBarCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!sender.hasPermission("azhotbar.admin")) {
            sender.sendMessage(AzBarFix.getInstance().getConfig().getString("Message.NoPermission"));
            return false;
        }
        if (strings.length == 0) {
            sender.sendMessage(AzBarFix.getInstance().getConfig().getString("Message.Wrong-Commands"));
            return false;
        } else if (strings[0].equalsIgnoreCase("reload") || strings[0].equalsIgnoreCase("rl")) {
            AzBarFix.getInstance().reloadConfig();
            sender.sendMessage(AzBarFix.getInstance().getConfig().getString("Message.Reload-Successful"));
            return true;
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
