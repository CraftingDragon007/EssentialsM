package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                Player player = (Player)sender;
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    flyEnabled.put(player,false);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("FlyModes.Disabled"));
                }else if(!player.getAllowFlight()){
                    player.setAllowFlight(true);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("FlyModes.Enabled"));
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/fly <Player>"));
        }else if(args.length==1){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    flyEnabled.put(player,false);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("FlyModes.Disabled"));
                }else if(!player.getAllowFlight()){
                    player.setAllowFlight(true);
                    flyEnabled.put(player,true);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("FlyModes.Enabled"));
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
        }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/fly (Player)"));
        return true;
    }
}
