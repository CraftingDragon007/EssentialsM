package ch.gamepowerx.essentialsm.tabcompleter;

<<<<<<< Updated upstream
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class heal implements TabCompleter {
    private List<String> returnArgs;
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1){
            if(!Bukkit.getOnlinePlayers().isEmpty()) {
                for (Player player : Bukkit.getOnlinePlayers()){
                    returnArgs.add(player.getName());
                }
            }
        }
        return returnArgs;
=======
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.List;
import org.bukkit.command.TabCompleter;

public class heal implements TabCompleter
{
    private List<String> returnArgs;
    
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        this.returnArgs.clear();
        if (args.length == 1 && !Bukkit.getOnlinePlayers().isEmpty()) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                this.returnArgs.add(player.getName());
            }
        }
        return this.returnArgs;
>>>>>>> Stashed changes
    }
}
