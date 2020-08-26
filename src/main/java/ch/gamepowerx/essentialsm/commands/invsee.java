package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;

public class invsee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(args.length==1) {
                Player player = (Player) sender;
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;
                    player.openInventory(target.getInventory());
                    //sender.sendMessage(PREFIX+ ChatColor.GREEN+"Du hast "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" zu dir teleportiert!");
                }else sender.sendMessage(PREFIX+ChatColor.RED+"Der Spieler wurde nicht gefunden!");
            }else sender.sendMessage(PREFIX+ChatColor.RED+"Bitte verwende: "+ChatColor.GOLD+ "/invsee (Spieler)"+ChatColor.RED+"!");
        } else sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst diesen Befehl nur als Spieler ausführen!");
        return true;
    }
}
