package ch.gamepowerx.essentialsm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Locale;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Spawnmob implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            try {
                EntityType type = EntityType.valueOf(args[0].toUpperCase().replace(' ','_'));
                String replace = type.toString().toLowerCase().replace('_', ' ');
                char[] chars = replace.toCharArray();
                String s = String.valueOf(chars[0]);
                s = s.toUpperCase();
                chars[0] = s.toCharArray()[0];
                replace = String.valueOf(chars);
                if(args.length==2){
                    for (int j = Integer.parseInt(args[1]); j > 0; j--) {
                        Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
                    }
                    player.sendMessage(PREFIX+getLang("SpawnedMobs").replace("%",args[1]+" "+ replace));
                }else {
                    Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
                    player.sendMessage(PREFIX+getLang("SpawnedMobs").replace("%","1 "+ replace));
                }
            }catch (IllegalArgumentException e){
                sender.sendMessage(PREFIX+getLang("FalseArg"));
            }
        }
        return true;
    }
}
