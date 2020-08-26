package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.lastMsg;

public class msg implements CommandExecutor {
    public static String msgPrefix = ChatColor.GOLD+"[MSG] "+ChatColor.RESET;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                if(args.length>=2) {
                Player player = (Player) sender;
                if(Bukkit.getPlayer(args[0])!=null){
                    Player target = Bukkit.getPlayer(args[0]);
                    lastMsg.put(player,target);
                    lastMsg.put(target,player);
                    StringBuilder message = new StringBuilder();
                    int count = 1;
                    while(count < args.length) {
                        message.append(args[count]);
                        message.append(" ");
                        count++;
                    }
                    message = new StringBuilder(message.toString().replace("&", "§"));
                    assert target != null;
                    player.sendMessage(msgPrefix+ChatColor.GREEN+"Du"+ChatColor.GOLD+" > "+ChatColor.GREEN+target.getName()+ChatColor.GOLD +"»"+ChatColor.WHITE+" "+message);
                    target.sendMessage(msgPrefix+ChatColor.GREEN+player.getName()+ChatColor.GOLD+" > "+ChatColor.GREEN+"Dich"+ChatColor.GOLD +"»"+ChatColor.WHITE+" "+message);
                }else sender.sendMessage(PREFIX+ChatColor.RED+"Der Spieler wurde nicht gefunden!");
            }else sender.sendMessage(PREFIX+ChatColor.RED+"Bitte verwende: "+ChatColor.GOLD+"/msg (Spieler) (Nachricht)"+ChatColor.RED+"!");
        }else sender.sendMessage(PREFIX+ChatColor.RED+"Du musst diesen Befehl als Spieler ausführen!");
        return true;
    }
}
