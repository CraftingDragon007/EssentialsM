package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Enderchest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player player){
                player.openInventory(player.getEnderChest());
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Enderchest <Player>"));
        }else if(args.length==1){
            if(sender.hasPermission("essentialsm.ec.other")) {
                if (sender instanceof Player player) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        player.openInventory(target.getEnderChest());
                    } else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                } else if (Bukkit.getPlayer(args[0]) != null) {
                    Player player = Bukkit.getPlayer(args[0]);
                    assert player != null;
                    player.openInventory(player.getEnderChest());
                } else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/ec"));
        }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Enderchest (Player)"));
        return true;
    }
}
