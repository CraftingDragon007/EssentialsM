

package ch.gamepowerx.essentialsm.tabcompleter;

import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.TabCompleter;

public class Gamemode implements TabCompleter
{
    private List<String> returnArgs;
    
    public Gamemode() {
        this.returnArgs = new ArrayList<String>();
    }
    
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        this.returnArgs.clear();
        if (args.length == 1) {
            this.returnArgs.add("survival");
            this.returnArgs.add("creative");
            this.returnArgs.add("adventure");
            this.returnArgs.add("spectator");
        }
        else if (args.length == 2 && !Bukkit.getOnlinePlayers().isEmpty()) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                this.returnArgs.add(player.getName());
            }
        }
        return this.returnArgs;
    }
}
