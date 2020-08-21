package ch.gamepowerx.essentialsm.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class teleport implements TabCompleter {
    private List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1){
            if(!Bukkit.getOnlinePlayers().isEmpty()){
                for(Player player:Bukkit.getOnlinePlayers()){
                    returnArgs.add(player.getName());
                }
            }
        }else if(args.length==2){
            if(!Bukkit.getOnlinePlayers().isEmpty()){
                for(Player player:Bukkit.getOnlinePlayers()){
                    returnArgs.add(player.getName());
                }
            }
        }
        return returnArgs;
    }
}
