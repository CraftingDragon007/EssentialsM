package ch.gamepowerx.essentialsm.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class Killall implements TabCompleter {
    private List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1){
            for(EntityType entityType : EntityType.values()){
                returnArgs.add(entityType.name());
            }
        }else if(args.length==2){
            for(World world : Bukkit.getWorlds()){
                returnArgs.add(world.getName());
            }
        }
        return returnArgs;
    }
}
