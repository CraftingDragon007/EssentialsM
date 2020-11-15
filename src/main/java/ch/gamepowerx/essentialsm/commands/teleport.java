package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class teleport implements CommandExecutor {
    private Player target1;
    private Player target2;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            if(sender instanceof Player) {
                target1 = (Player) sender;
                if (Bukkit.getPlayer(args[0]) != null) {
                    target2 = Bukkit.getPlayer(args[0]);
                    target1.teleport(target2);
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + target2.getName() + text[2]);
                }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/tp <Player> <Player|Coordinates>"));
        }else if(args.length==2){
            if(Bukkit.getPlayer(args[0])!=null){
                target1 = Bukkit.getPlayer(args[0]);
                if(Bukkit.getPlayer(args[1])!=null){
                    target2 = Bukkit.getPlayer(args[1]);
                    target1.teleport(target2);
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + target2.getName() + text[2]);
                }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
        }else if(args.length==3){
            if(sender instanceof Player){
                target1 = (Player)sender;
                try {
                    Location location = new Location(target1.getWorld(),Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                    target1.teleport(location);
                    //sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast dich zu " + ChatColor.GOLD+location.getX()+" "+location.getY()+" "+location.getZ()+ChatColor.GREEN+" teleportiert!");
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + location.getX()+" "+location.getY()+" "+location.getZ() + text[2]);
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX+getLang("InvalidCoordinates"));
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/tp <Player> <Player|Coordinates>"));
        }else if(args.length==4){
            if(Bukkit.getPlayer(args[0])!=null){
                target1 = Bukkit.getPlayer(args[0]);
                try {
                    Location location = new Location(target1.getWorld(),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                    target1.teleport(location);
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + location.getX()+" "+location.getY()+" "+location.getZ() + text[2]);
                    //sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast "+ ChatColor.GOLD+ target1.getName() +" zu " + ChatColor.GOLD+location.getX()+" "+location.getY()+" "+location.getZ()+ChatColor.GREEN+" teleportiert!");
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX+getLang("InvalidCoordinates"));
                }
            }
        }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/tp (Player|Coordinates) <Player|Coordinates>"));
        return true;
    }
}
