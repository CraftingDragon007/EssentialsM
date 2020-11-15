package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class msg implements CommandExecutor {
    public static String msgPrefix = getLang("MSGPrefix");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                if(args.length>=2) {
                Player player = (Player) sender;
                if(Bukkit.getPlayer(args[0])!=null){
                    Player target = Bukkit.getPlayer(args[0]);
                    lastMsg.put(player,target);
                    lastMsg.put(target,player);
                    StringBuilder message = new StringBuilder();
                    int count = 1;
                    while(count < args.length) {
                        message.append(args[count]);
                        message.append(" ");
                        count++;
                    }
                    message = new StringBuilder(message.toString().replace("&", "§"));
                    assert target != null;
                    player.sendMessage(msgPrefix+getLang("SendMSG").replace("%",target.getName())+message);
                    target.sendMessage(msgPrefix+getLang("GetMSG").replace("%",player.getName())+message);
                }else sender.sendMessage(PREFIX+getLang("PlayerNotFound"));
            }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%","/msg <Spieler> <Nachricht>"));
        }else sender.sendMessage(PREFIX + getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
