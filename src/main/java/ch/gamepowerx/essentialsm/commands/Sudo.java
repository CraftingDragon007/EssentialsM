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
            StringBuilder message = new StringBuilder();
            int count = 1;
            while(count < args.length) {
                message.append(args[count]);
                message.append(" ");
                count++;
            }
            if(target != null){
                if(!(args[1].startsWith("c:"))) {
                    Bukkit.dispatchCommand(target, message.toString());
                }else target.chat(message.toString().replace("c:", ""));
                sender.sendMessage(PREFIX + getLang("CommandExecutedSuccessfully"));
            }else sender.sendMessage(PREFIX + getLang("PlayerNotFound"));
        }else sender.sendMessage(PREFIX + getLang("FalseArgs").replace("%", "/sudo <Spieler> <Befehl>"));
        return true;
    }
}
