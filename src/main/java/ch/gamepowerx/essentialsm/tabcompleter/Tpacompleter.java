package ch.gamepowerx.essentialsm.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static ch.gamepowerx.essentialsm.EssentialsM.tpas;

public class Tpacompleter implements TabCompleter {
    private List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1)
        if(sender instanceof Player) {
            Player player = (Player)sender;
            if (tpas.containsKey(player)){
                if(!tpas.get(player).isEmpty())
                    for(Player player1 : tpas.get(player))
                        returnArgs.add(player1.getName());
            }
        }
        return returnArgs;
    }
}
