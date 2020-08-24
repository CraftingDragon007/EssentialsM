package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;

public class killall implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            try {
                EntityType type = EntityType.valueOf(args[0]);
                for(World world : Bukkit.getWorlds()) {
                    for (Entity entity : world.getEntities()) {
                       if(entity.getType().equals(type)){
                           if(entity instanceof Player){
                               ((Player) entity).damage(((Player) entity).getHealth());
                           }else
                           entity.remove();
                       }
                    }
                }
                sender.sendMessage(PREFIX+ChatColor.GREEN+"Die Ausgewählten Entitäten wurden gelöscht!");
            } catch (IllegalArgumentException|NullPointerException e){
                sender.sendMessage(PREFIX+ ChatColor.RED+"Ungültiges Argument!");
            }
        }else if(args.length==2){
            try {
                EntityType type = EntityType.valueOf(args[0]);
                if(Bukkit.getWorld(args[1])!=null){
                    World world = Bukkit.getWorld(args[1]);
                    for (Entity entity : world.getEntities()) {
                        if(entity.getType().equals(type)){
                            entity.remove();
                        }
                    }
                    sender.sendMessage(PREFIX+ChatColor.GREEN+"Die Ausgewählten Entitäten wurden gelöscht!");
                }
            } catch (IllegalArgumentException|NullPointerException e){
                sender.sendMessage(PREFIX+ ChatColor.RED+"Ungültiges Argument!");
            }
        }
        return true;
    }
}
