package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.flyEnabled;

public class speed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            if(sender instanceof Player){
                Player player = (Player)sender;
                try {
                    player.setFlySpeed(Integer.parseInt(args[0]));
                    player.setWalkSpeed(Integer.parseInt(args[0]));
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX+ChatColor.RED+"Ungültige Zahl!");
                }
                sender.sendMessage(PREFIX+ ChatColor.RED+"Flugmodus deaktiviert!");
            }
        }else if(args.length==2){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                try {
                    player.setFlySpeed(Integer.parseInt(args[0]));
                    player.setWalkSpeed(Integer.parseInt(args[0]));
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX+ChatColor.RED+"Ungültige Zahl!");
                }
                sender.sendMessage(PREFIX+ ChatColor.GREEN+"Geschwindigkeit von "+ChatColor.GOLD+player.getName()+ ChatColor.GREEN+" wurde auf"+ChatColor.GOLD+args[1]+"!");
            }
        }
        return true;
    }
}
