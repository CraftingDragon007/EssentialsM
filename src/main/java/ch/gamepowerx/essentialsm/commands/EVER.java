package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.EssentialsM;
import com.sun.istack.internal.NotNull;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EVER implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.GREEN + "EssentialsM" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Version: " + EssentialsM.getVersion());
        sender.sendMessage(ChatColor.GREEN + "Report Problems, Bugs and Errors to (Discord)\n" + ChatColor.GOLD + "CraftingDragon007#3792");
        return true;
    }
}
