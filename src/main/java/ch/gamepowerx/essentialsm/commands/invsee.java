package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class invsee implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(args.length==1) {
                Player player = (Player) sender;
                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    assert target != null;
                    player.openInventory(target.getInventory());
                    //sender.sendMessage(PREFIX+ ChatColor.GREEN+"Du hast "+ChatColor.GOLD+target.getName()+ChatColor.GREEN+" zu dir teleportiert!");
                }else sender.sendMessage(PREFIX+getLang("PlayerNotFound"));
            }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%", "/invsee <Player>"));
        } else sender.sendMessage(PREFIX + getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
