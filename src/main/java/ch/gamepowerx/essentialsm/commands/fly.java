package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.flyEnabled;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                Player player = (Player)sender;
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    flyEnabled.put(player,false);
                    sender.sendMessage(PREFIX+ ChatColor.RED+"Flugmodus deaktiviert!");
                }else if(!player.getAllowFlight()){
                    player.setAllowFlight(true);
                    flyEnabled.put(player,true);
                    sender.sendMessage(PREFIX+ ChatColor.GREEN+"Flugmodus aktiviert!");
                }
            }
        }else if(args.length==1){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    flyEnabled.put(player,false);
                    sender.sendMessage(PREFIX+ ChatColor.RED+"Flugmodus von "+ChatColor.GOLD+player.getName()+ ChatColor.GREEN+" deaktiviert!");
                }else if(!player.getAllowFlight()){
                    player.setAllowFlight(true);
                    flyEnabled.put(player,true);
                    sender.sendMessage(PREFIX+ ChatColor.GREEN+"Flugmodus von " + ChatColor.GOLD + player.getName() +ChatColor.GREEN+ " aktiviert!");
                }
            }
        }
        return true;
    }
}
