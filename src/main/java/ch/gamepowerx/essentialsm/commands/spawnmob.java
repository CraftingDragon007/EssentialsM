package ch.gamepowerx.essentialsm.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;

public class spawnmob implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            try {
                EntityType type = EntityType.valueOf(args[0]);
                //Entity entity = player.
            }catch (IllegalArgumentException e){
                sender.sendMessage(PREFIX+"Ungültiges Argument!");
            }
        }
        return true;
    }
}
