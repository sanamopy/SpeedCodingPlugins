package com.sanamo.autoSmelt.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static com.sanamo.autoSmelt.AutoSmelt.AutoSmeltToggled;

public class AutoSmeltCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        // Check make sure the command is ran by a player
        if (!(commandSender instanceof final Player player)) {
            commandSender.sendMessage(ChatColor.RED + "Only players can run this command!");
            return true;
        }
        UUID uuid = player.getUniqueId();

        // Check if they have auto smelt enabled
        if (AutoSmeltToggled.contains(uuid)) {
            // Remove auto smelt
            AutoSmeltToggled.remove(uuid);
            player.sendMessage(ChatColor.RED + "Removed your AutoSmelt feature.");
        } else {
            // Add auto smelt
            AutoSmeltToggled.add(uuid);
            player.sendMessage(ChatColor.GREEN + "You have been granted the AutoSmelt feature.");
        }

        return false;
    }
}
