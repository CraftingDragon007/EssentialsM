package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Tpall implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.teleport((Player) sender);
                }
                sender.sendMessage(PREFIX+getLang("TeleportedHere").replace("%",getLang("AllPlayers")));
            }else sender.sendMessage(PREFIX+getLang("FalseArg"));
        }else if(args.length==1){
            Player player = Bukkit.getPlayer(args[0]);
            if(player!=null){
                for(Player target : Bukkit.getOnlinePlayers()){
                    target.teleport(player);
                }
            }else sender.sendMessage(PREFIX + getLang("PlayerNotFound"));
        }else sender.sendMessage(PREFIX+getLang("FalseArg"));
        return true;
    }
}
