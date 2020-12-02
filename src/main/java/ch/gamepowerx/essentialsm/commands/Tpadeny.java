package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Tpadeny implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                Player from = Bukkit.getPlayer(args[0]);
                if (from != null) {
                    if (tpas.containsKey(player)){
                        if(tpas.get(player).contains(from)){
                            sender.sendMessage(PREFIX + getLang("YouDeniedPlayerTPA").replace("%", from.getName()));
                            from.sendMessage(PREFIX + getLang("OtherDeniedPlayerTPA").replace("%",sender.getName()));
                            tpas.get(player).remove(from);
                        }else sender.sendMessage(PREFIX+getLang("HasNotSendTPA").replace("%",from.getName()));
                    }else if(tpas.containsKey(from)){
                     if(tpas.get(from).contains(player)){
                         sender.sendMessage(PREFIX+getLang("CancelledPlayerTPA").replace("%", from.getName()));
                         tpas.get(from).remove(player);
                     }
                    }else sender.sendMessage(PREFIX+getLang("YouHaveNoTPAs"));
                } else sender.sendMessage(PREFIX + getLang("PlayerNotFound"));
            } else sender.sendMessage(PREFIX + getLang("FalseArgs").replace("%","/Tpadeny <Player>"));
        }else sender.sendMessage(PREFIX + getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
