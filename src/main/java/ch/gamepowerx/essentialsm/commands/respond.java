package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.lastMsg;
import static ch.gamepowerx.essentialsm.commands.msg.msgPrefix;

public class respond implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length >= 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(lastMsg.get(player)!=null){
                    Player target = lastMsg.get(player);
                    lastMsg.put(player,target);
                    lastMsg.put(target,player);
                    StringBuilder message = new StringBuilder();
                    int count = 0;
                    while(count < args.length) {
                        message.append(args[count]);
                        message.append(" ");
                        count++;
                    }
                    message = new StringBuilder(message.toString().replace("&", "§"));
                    assert target != null;
                    player.sendMessage(msgPrefix+ChatColor.GREEN+"Du"+ChatColor.GOLD+" > "+ChatColor.GREEN+target.getName()+ChatColor.GOLD +"»"+ChatColor.WHITE+" "+message);
                    target.sendMessage(msgPrefix+ChatColor.GREEN+player.getName()+ChatColor.GOLD+" > "+ChatColor.GREEN+"Dich"+ChatColor.GOLD +"»"+ChatColor.WHITE+" "+message);
                }else sender.sendMessage(PREFIX+ChatColor.RED+"Bitte verwende "+ChatColor.GOLD+"/msg (Spieler) (Nachricht) "+ChatColor.RED+"um deine Nachricht zu senden!");
            }else sender.sendMessage(PREFIX+ChatColor.RED+"Du musst diesen Befehl als Spieler ausführen!");
        }else sender.sendMessage(PREFIX+ChatColor.RED+"Bitte verwende: "+ChatColor.GOLD+"/respond (Nachricht)"+ChatColor.RED+"!");
        return true;
    }
}
