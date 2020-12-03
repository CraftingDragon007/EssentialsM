package ch.gamepowerx.essentialsm.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Spawnmob implements TabCompleter {
    private List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1) {
            for(EntityType type : EntityType.values()){
                returnArgs.add(type.toString());
            }
        }else if(args.length==2){
            returnArgs.add(String.valueOf(1));
            returnArgs.add(String.valueOf(2));
            returnArgs.add(String.valueOf(3));
            returnArgs.add(String.valueOf(4));
            returnArgs.add(String.valueOf(5));
            returnArgs.add(String.valueOf(6));
            returnArgs.add(String.valueOf(7));
            returnArgs.add(String.valueOf(8));
            returnArgs.add(String.valueOf(9));
            returnArgs.add(String.valueOf(10));
            returnArgs.add(String.valueOf(11));
            returnArgs.add(String.valueOf(12));
            returnArgs.add(String.valueOf(13));
            returnArgs.add(String.valueOf(14));
            returnArgs.add(String.valueOf(15));
            returnArgs.add(String.valueOf(16));
            returnArgs.add(String.valueOf(17));
            returnArgs.add(String.valueOf(18));
            returnArgs.add(String.valueOf(19));
            returnArgs.add(String.valueOf(20));
        }
        return returnArgs;
    }
}
