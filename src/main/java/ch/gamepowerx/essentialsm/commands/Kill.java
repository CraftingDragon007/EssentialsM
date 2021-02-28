package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.CommandUtils;
import com.sun.istack.internal.NotNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Kill implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                ((Player)sender).setHealth(0.0);
                sender.sendMessage(PREFIX + getLang("KilledSelectedEntities"));
            }else sender.sendMessage(PREFIX + getLang("FalseArg"));
        }else
        if(args.length==1){
            Entity[] entities = CommandUtils.getTargets(sender, args[0]);
            if(entities != null) {
                for (Entity e : entities) {
                    if (e instanceof LivingEntity) {
                        ((LivingEntity) e).setHealth(0.0);
                    }
                }
                sender.sendMessage(PREFIX + getLang("KilledSelectedEntities"));
            }else {
                sender.sendMessage(PREFIX + getLang("FalseArg"));
                return true;
            }

        }else sender.sendMessage(PREFIX + getLang("FalseArg"));
        return true;
    }
}
