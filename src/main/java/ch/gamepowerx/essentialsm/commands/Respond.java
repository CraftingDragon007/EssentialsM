package ch.gamepowerx.essentialsm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;
import static ch.gamepowerx.essentialsm.commands.Msg.msgPrefix;

public class Respond implements CommandExecutor {
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
                    player.sendMessage(msgPrefix+getLang("SendMSG").replace("%",target.getName())+message);
                    target.sendMessage(msgPrefix+getLang("GetMSG").replace("%",player.getName())+message);
                }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%","/Msg <Spieler> <Nachricht>"));
            }else sender.sendMessage(PREFIX+getLang("OnlyPlayersCanRunThisCommand"));
        }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%","/Msg <Spieler> <Nachricht>"));
        return true;
    }
}
