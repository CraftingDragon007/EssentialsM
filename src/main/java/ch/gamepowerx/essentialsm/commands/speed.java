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
            if(sender instanceof Player) {
                Player player = (Player) sender;
                try {
                    player.setFlySpeed(Float.parseFloat(args[0]));
                    player.setWalkSpeed(Float.parseFloat(args[0]));
                    sender.sendMessage(PREFIX+ ChatColor.GREEN+"Deine Geschwindigkeit wurde auf "+ChatColor.GOLD+player.getWalkSpeed()+ChatColor.GREEN+"!");
                } catch (IllegalArgumentException e) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "Ungültige Zahl!");
                }
            }
        }else if(args.length==2){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                try {
                    assert player != null;
                    player.setFlySpeed(Float.parseFloat(args[1]));
                    player.setWalkSpeed(Float.parseFloat(args[1]));
                    sender.sendMessage(PREFIX+ ChatColor.GREEN+"Geschwindigkeit von "+ChatColor.GOLD+player.getName()+ ChatColor.GREEN+" wurde auf "+ChatColor.GOLD+player.getWalkSpeed()+ChatColor.GREEN+"!");
                } catch (IllegalArgumentException e) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "Ungültige Zahl!");
                }
            }
        }
        return true;
    }
}
