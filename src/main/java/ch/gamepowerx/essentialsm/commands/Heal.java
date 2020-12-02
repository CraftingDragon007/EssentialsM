package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Heal implements CommandExecutor
{
    private Player target;
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                (this.target = (Player)sender).setHealth(20.0);
                this.target.setFoodLevel(20);
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
            if (Bukkit.getPlayer(args[0]) != null) {
                this.target = Bukkit.getPlayer(args[0]);
                (this.target = (Player)sender).setHealth(20.0);
                this.target.setFoodLevel(20);
                for (final PotionEffectType potionEffect : PotionEffectType.values()) {
                    this.target.removePotionEffect(potionEffect);
                }
                sender.sendMessage(EssentialsM.PREFIX + getLang("HealedPlayer").replace("%", target.getName()));
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
            }
        }
        else {
            sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Heal <Player>"));
        }
        return true;
    }
}
