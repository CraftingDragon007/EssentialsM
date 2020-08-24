package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.tpas;

public class tpaaccept implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                Player from = Bukkit.getPlayer(args[0]);
                if (from != null) {
                    if (tpas.containsKey(player)){
                        if(tpas.get(player).contains(from)){
                            sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast die Teleportierungsanfrage von " + ChatColor.GOLD + from.getName() + ChatColor.GREEN + " angenommen!");
                            from.sendMessage(PREFIX + ChatColor.GOLD + sender.getName() + ChatColor.GREEN + " hat deine Teleportierungsanfrage angenommen!");
                            from.teleport(player);
                            tpas.get(player).remove(from);
                        }else sender.sendMessage(PREFIX+ChatColor.RED+"Der Spieler "+ChatColor.GOLD+from.getName()+ChatColor.RED+" hat dir keine Teleportierungsanfrage gesendet!");
                    } else sender.sendMessage(PREFIX+ChatColor.RED+"Du hast keine Teleportierungsanfragen!");
                } else from.sendMessage(PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
            } else sender.sendMessage(PREFIX + ChatColor.RED + "Bitte verwende: " + ChatColor.GOLD + "/tpaccept (Spieler) " + ChatColor.RED + "!");
        }
        return true;
    }
}
