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
                returnArgs.add("1");
                returnArgs.add("2");
                returnArgs.add("3");
                returnArgs.add("4");
                returnArgs.add("5");
                returnArgs.add("6");
                returnArgs.add("7");
                returnArgs.add("8");
                returnArgs.add("9");
                returnArgs.add("10");
                returnArgs.add("reset");
            }
        }else if(args.length==2){
            returnArgs.add("1");
            returnArgs.add("2");
            returnArgs.add("3");
            returnArgs.add("4");
            returnArgs.add("5");
            returnArgs.add("6");
            returnArgs.add("7");
            returnArgs.add("8");
            returnArgs.add("9");
            returnArgs.add("10");
            returnArgs.add("reset");
        }
        return returnArgs;
    }
}
