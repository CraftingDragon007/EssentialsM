package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.tpas;

public class tpa implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player from = (Player) sender;
            if(args.length==1){
               Player to = Bukkit.getPlayer(args[0]);
               if(to!=null){
                   if(tpas.containsKey(to)) {
                       if (!tpas.get(to).contains(from)) {
                           tpas.get(to).add(from);
                           from.sendMessage(PREFIX+ChatColor.GREEN+"Du hast "+ChatColor.GOLD+to.getName()+ChatColor.GREEN+"eine Teleportierungsanfrage gesendet!");
                           to.sendMessage(PREFIX+ChatColor.GREEN+"Du hast eine Teleportierungsanfrage von "+ChatColor.GOLD+from.getName()+ChatColor.GREEN+" erhalten!");
                           to.sendMessage(PREFIX+ChatColor.GREEN+"Zum Annehmen " +ChatColor.GOLD+ "/tpaaccept "+from.getName()+ChatColor.GREEN +" eingeben!");
                           to.sendMessage(PREFIX+ChatColor.RED+"Zum Ablehnen "+ChatColor.GOLD+"/tpadeny "+from.getName()+ChatColor.RED+" eingeben!");
                       }else from.sendMessage(PREFIX+ChatColor.RED+"Du hast dem Spieler "+ChatColor.GOLD+to.getName()+ChatColor.RED+" schon eine Anfrage gesendet!");
                   }else {
                       ArrayList<Player> request = new ArrayList<>();
                       request.add(from);
                       tpas.put(to,request);
                       from.sendMessage(PREFIX+ChatColor.GREEN+"Du hast "+ChatColor.GOLD+to.getName()+ChatColor.GREEN+" eine Teleportierungsanfrage gesendet!");
                       to.sendMessage(PREFIX+ChatColor.GREEN+"Du hast eine Teleportierungsanfrage von "+ChatColor.GOLD+from.getName()+ChatColor.GREEN+" erhalten!");
                       to.sendMessage(PREFIX+ChatColor.GREEN+"Zum Annehmen " +ChatColor.GOLD+ "/tpaaccept "+from.getName()+ChatColor.GREEN +" eingeben!");
                       to.sendMessage(PREFIX+ChatColor.RED+"Zum Ablehnen "+ChatColor.GOLD+"/tpadeny "+from.getName()+ChatColor.RED+" eingeben!");
                   }
               }else sender.sendMessage(PREFIX+ChatColor.RED+"Der Spieler wurde nicht gefunden!");
            }else sender.sendMessage(PREFIX+ ChatColor.RED+"Bitte verwende: "+ChatColor.GOLD+"/tpa (Spieler)"+ChatColor.RED+"!");
        }else sender.sendMessage(PREFIX+ ChatColor.RED+"Du musst ein Spieler sein um diesen Befehl ausführen zu können!");
        return true;
    }
}
