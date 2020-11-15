package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class tpohere implements CommandExecutor {
    private Player target;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (Bukkit.getPlayer(args[0]) != null) {
                   target = Bukkit.getPlayer(args[0]);
                   target.teleport(player);
                   sender.sendMessage(PREFIX+getLang("TeleportedHere").replace("%", target.getName()));
                }
            } else sender.sendMessage(PREFIX + getLang("OnlyPlayersCanRunThisCommand"));
        }
        return true;
    }
}
