package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class GodMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player player){
                if(godMode.containsKey(player)){
                    if(godMode.get(player)){
                        godMode.remove(player);
                        godMode.put(player, false);
                        sender.sendMessage(PREFIX + getLang("GodMode") + ChatColor.RED + getLang("Modes.Disabled") + ChatColor.GOLD + "!");
                    }else {
                        godMode.remove(player);
                        godMode.put(player, true);
                        sender.sendMessage(PREFIX + getLang("GodMode") + ChatColor.GREEN + getLang("Modes.Enabled") + ChatColor.GOLD + "!");
                    }
                }else {
                    godMode.put(player, true);
                    sender.sendMessage(PREFIX + getLang("GodMode") + ChatColor.GREEN + getLang("Modes.Enabled") + ChatColor.GOLD + "!");
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/godmode (Player)"));
        }else if(args.length==1){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                assert player != null;
                if(godMode.containsKey(player)){
                    if(godMode.get(player)){
                        godMode.remove(player);
                        godMode.put(player, false);
                        sender.sendMessage(PREFIX + getLang("GodMode") + ChatColor.RED + getLang("Modes.Disabled") + ChatColor.GOLD + "!");
                    }else {
                        godMode.remove(player);
                        godMode.put(player, true);
                        sender.sendMessage(PREFIX + getLang("GodMode") + ChatColor.GREEN + getLang("Modes.Enabled") + ChatColor.GOLD + "!");
                    }
                }else {
                    godMode.put(player, true);
                    sender.sendMessage(PREFIX + getLang("GodMode") + ChatColor.GREEN + getLang("Modes.Enabled") + ChatColor.GOLD + "!");
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
        }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/godmode (Player)"));
        return true;
    }
}
