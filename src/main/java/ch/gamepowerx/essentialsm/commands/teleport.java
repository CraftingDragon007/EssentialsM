package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;

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
                    sender.sendMessage(PREFIX+ChatColor.GREEN+"Du wurdest zu "+ChatColor.GOLD+target2.getName()+ChatColor.GOLD+" teleportiert!");
                }else sender.sendMessage(PREFIX+ ChatColor.RED+"Der Spieler wurde nicht gefunden!");
            }else sender.sendMessage(PREFIX+ ChatColor.RED+"Du kannst dich nicht zu einem Spieler teleportieren!");
        }else if(args.length==2){
            if(Bukkit.getPlayer(args[0])!=null){
                target1 = Bukkit.getPlayer(args[0]);
                if(Bukkit.getPlayer(args[1])!=null){
                    target2 = Bukkit.getPlayer(args[1]);
                    target1.teleport(target2);
                    sender.sendMessage(PREFIX+ChatColor.GREEN+"Du hast "+ChatColor.GOLD+target1.getName()+ChatColor.GREEN+" zu "+ChatColor.GOLD+target2.getName()+ChatColor.GREEN+" teleportiert!");
                }else sender.sendMessage(PREFIX+ ChatColor.RED+"Der/die Spieler wurde/n nicht gefunden!");
            }else sender.sendMessage(PREFIX+ ChatColor.RED+"Der/die Spieler wurde/n nicht gefunden!");
        }else if(args.length==3){
            if(sender instanceof Player){
                target1 = (Player)sender;
                try {
                    Location location = new Location(target1.getWorld(),Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                    target1.teleport(location);
                    sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast dich zu " + ChatColor.GOLD+location.getX()+" "+location.getY()+" "+location.getZ()+ChatColor.GREEN+" teleportiert!");
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX+ChatColor.RED+"Ungültige Koordinaten!");
                }
            }else sender.sendMessage(PREFIX+ ChatColor.RED+"Du kannst dich teleportieren!");
        }else if(args.length==4){
            if(Bukkit.getPlayer(args[0])!=null){
                target1 = Bukkit.getPlayer(args[0]);
                try {
                    Location location = new Location(target1.getWorld(),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                    target1.teleport(location);
                    sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast "+ ChatColor.GOLD+ target1.getName() +" zu " + ChatColor.GOLD+location.getX()+" "+location.getY()+" "+location.getZ()+ChatColor.GREEN+" teleportiert!");
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX+ChatColor.RED+"Ungültige Koordinaten!");
                }
            }
        }else sender.sendMessage(PREFIX+ChatColor.RED+"Ungültige Argumente! Bitte verwende: "+ChatColor.GOLD+"/tp (Spieler|Koordinaten) <Spieler|Koordinaten>");
        return true;
    }
}
