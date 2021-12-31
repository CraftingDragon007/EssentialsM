package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Sudo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 2){
            Player target = Bukkit.getPlayerExact(args[0]);
            if(target != null){
                if(!(args[1].startsWith("c:"))) {
                    Bukkit.dispatchCommand(target, args[1]);
                }else target.chat(args[1].replace("c:", ""));
                sender.sendMessage(PREFIX + getLang("CommandExecutedSuccessfully"));
            }else sender.sendMessage(PREFIX + getLang("PlayerNotFound"));
        }else sender.sendMessage(PREFIX + getLang("FalseArgs").replace("%", "/sudo <Spieler> <Befehl>"));
        return true;
    }
}
