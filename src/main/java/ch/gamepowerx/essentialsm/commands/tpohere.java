package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;

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
                   sender.sendMessage(PREFIX+ChatColor.GREEN+"Du hast "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" zu dir teleportiert!");
                }
            } else sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst diesen Befehl nur als Spieler ausführen!");
        }
        return true;
    }
}
