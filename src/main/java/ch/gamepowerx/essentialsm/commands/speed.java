package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class speed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                int speed = 1;
                try {
                    try {
                        if(args[0].equalsIgnoreCase("reset")){
                            args[0] = "1";
                        }
                        speed = Integer.parseInt(args[0]);
                        if (!(speed < 1 || speed > 10)) {
                            speed++;
                            player.setWalkSpeed((float) speed / 10);
                            player.setFlySpeed((float) speed / 10);
                            String[] text = getLang("SetPlayerSpeed").split("%");
                            sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + speed + text[2]);
                        }else sender.sendMessage(PREFIX + getLang("FalseArg"));
                    } catch (NumberFormatException e) {
                        sender.sendMessage(PREFIX + getLang("FalseArg"));
                        return true;
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }else if(args.length==2){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                int speed = 1;
                try {
                    assert player != null;
                    try {
                        speed = Integer.parseInt(args[1]);
                        if (!(speed < 1 || speed > 10)) {
                            player.setWalkSpeed((float) speed / 10);
                            player.setFlySpeed((float) speed / 10);
                            String[] text = getLang("SetPlayerSpeed").split("%");
                            sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + speed + text[2]);
                        }else sender.sendMessage(PREFIX + getLang("FalseArg"));
                    } catch (NumberFormatException e) {
                        sender.sendMessage(PREFIX + getLang("FalseArg"));
                        return true;
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
