package ch.gamepowerx.essentialsm.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class speed implements TabCompleter {
    private List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1){
            if(!Bukkit.getOnlinePlayers().isEmpty()){
                for(Player player : Bukkit.getOnlinePlayers()){
                    returnArgs.add((player.getName()));
                }
                returnArgs.add("0.1");
                returnArgs.add("0.2");
                returnArgs.add("0.3");
                returnArgs.add("0.4");
                returnArgs.add("0.5");
                returnArgs.add("0.6");
                returnArgs.add("0.7");
                returnArgs.add("0.8");
                returnArgs.add("0.9");
                returnArgs.add("1.0");
            }
        }else if(args.length==2){
            returnArgs.add("0.1");
            returnArgs.add("0.2");
            returnArgs.add("0.3");
            returnArgs.add("0.4");
            returnArgs.add("0.5");
            returnArgs.add("0.6");
            returnArgs.add("0.7");
            returnArgs.add("0.8");
            returnArgs.add("0.9");
            returnArgs.add("1.0");
        }
        return returnArgs;
    }
}
