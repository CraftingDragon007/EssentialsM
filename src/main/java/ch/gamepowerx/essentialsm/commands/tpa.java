package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

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
                           from.sendMessage(PREFIX+getLang("SentPlayerTPA").replace("%",to.getName()));
                           to.sendMessage(PREFIX+getLang("GetPlayerTPA").replace("%",from.getName()));
                           to.sendMessage(PREFIX+getLang("AcceptPlayerTPA").replace("%",from.getName()));
                           to.sendMessage(PREFIX+getLang("DenyPlayerTPA").replace("%", from.getName()));
                       }else from.sendMessage(PREFIX+getLang("AlreadySendPlayerTPA").replace("%",to.getName()));
                   }else {
                       ArrayList<Player> request = new ArrayList<>();
                       request.add(from);
                       tpas.put(to,request);
                       from.sendMessage(PREFIX+getLang("SentPlayerTPA").replace("%",to.getName()));
                       to.sendMessage(PREFIX+getLang("GetPlayerTPA").replace("%",from.getName()));
                       to.sendMessage(PREFIX+getLang("AcceptPlayerTPA").replace("%",from.getName()));
                       to.sendMessage(PREFIX+getLang("DenyPlayerTPA").replace("%", from.getName()));
                   }
               }else sender.sendMessage(PREFIX+getLang("PlayerNotFound"));
            }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%","/tpa <Player>"));
        }else sender.sendMessage(PREFIX+getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
