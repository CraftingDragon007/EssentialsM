package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Heal implements CommandExecutor
{
    private LivingEntity target;
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                if(target instanceof Player)
                    ((Player)target).setFoodLevel(20);
                for (final PotionEffectType potionEffect : PotionEffectType.values()) {
                    this.target.removePotionEffect(potionEffect);
                }
                sender.sendMessage(EssentialsM.PREFIX + getLang("HealedPlayer").replace("%", target.getName()));
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Heal <Player>"));
            }
        }
        else if (args.length == 1) {
            Bukkit.getConsoleSender().sendMessage(args[0]);
            Entity entity = CommandUtils.getTarget(sender, args[0]);
            if(entity!=null)
            Bukkit.getConsoleSender().sendMessage(entity.toString());
            if(entity instanceof LivingEntity){
                target = (LivingEntity) entity;
            }else {
                sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                return true;
            }
            target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            if(target instanceof Player)
                ((Player)target).setFoodLevel(20);
            for (final PotionEffectType potionEffect : PotionEffectType.values()) {
                target.removePotionEffect(potionEffect);
            }
            sender.sendMessage(EssentialsM.PREFIX + getLang("HealedPlayer").replace("%", target.getName()));
        }
        else {
            sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Heal <Player>"));
        }
        return true;
    }
}
