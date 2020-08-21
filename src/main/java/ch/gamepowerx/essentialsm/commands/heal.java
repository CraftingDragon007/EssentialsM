package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
<<<<<<< Updated upstream
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;

public class heal implements CommandExecutor {
    private Player target;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                target = (Player)sender;
                target.setHealth(20);
                target.setFoodLevel(20);
                for(PotionEffectType potionEffect :PotionEffectType.values()){
                    target.removePotionEffect(potionEffect);
                }
                sender.sendMessage(PREFIX+ChatColor.GREEN+"Du hast den Spieler "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" geheilt!");
            }else sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst nur Spieler heilen!");
        }else if(args.length==1){
            if(Bukkit.getPlayer(args[0])!=null){
                target = Bukkit.getPlayer(args[0]);
                target = (Player)sender;
                target.setHealth(20);
                target.setFoodLevel(20);
                for(PotionEffectType potionEffect :PotionEffectType.values()){
                    target.removePotionEffect(potionEffect);
                }
                sender.sendMessage(PREFIX+ChatColor.GREEN+"Du hast den Spieler "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" geheilt!");
            }else sender.sendMessage(PREFIX + ChatColor.RED+"Der Spieler wurde nicht gefunden!");
        }else sender.sendMessage(PREFIX+ChatColor.RED+"Ungültige Argumente! Bitte verwende:" +ChatColor.GOLD+"/heal <Spieler>"+ChatColor.RED+"!");
=======
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class heal implements CommandExecutor
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
                sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast den Spieler " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + " geheilt!");
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Du kannst nur Spieler heilen!");
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
                sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast den Spieler " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + " geheilt!");
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
            }
        }
        else {
            sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Ung\u00fcltige Argumente! Bitte verwende:" + ChatColor.GOLD + "/heal <Spieler>" + ChatColor.RED + "!");
        }
>>>>>>> Stashed changes
        return true;
    }
}
