/*
 *            EssentialsM basic command Plugin for Minecraft
 *                  Copyright (C) 2021 CraftingDragon007
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.CommandUtils;
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Teleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Entity target1;
        Entity target2;
        if(args.length==1){
            if(sender instanceof Player) {
                target1 = (Player) sender;
                target2 = CommandUtils.getTarget(target1, args[0]);
                if (target2 != null) {
                    target1.teleport(target2);
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + target2.getName() + text[2]);
                }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/tp <Player> <Player|Coordinates>"));
        }else if(args.length==2){
            target1 = CommandUtils.getTarget(sender, args[0]);
            if(target1 != null){
                target2 = CommandUtils.getTarget(sender, args[1]);
                if(target2 != null){
                    target1.teleport(target2);
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + target2.getName() + text[2]);
                }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
        }else if(args.length==3){
            if(sender instanceof Player){
                target1 = (Player)sender;
                try {
                    Location location = new Location(target1.getWorld(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                    target1.teleport(location);
                    //sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast dich zu " + ChatColor.GOLD+location.getX()+" "+location.getY()+" "+location.getZ()+ChatColor.GREEN+" teleportiert!");
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + location.getX()+" "+location.getY()+" "+location.getZ() + text[2]);
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX + getLang("InvalidCoordinates"));
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/tp <Player> <Player|Coordinates>"));
        }else if(args.length==4){
            target1 = CommandUtils.getTarget(sender, args[0]);
            if(target1 != null){
                try {
                    Location location = new Location(target1.getWorld(), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                    target1.teleport(location);
                    String[] text = getLang("TeleportedPlayer").split("%");
                    sender.sendMessage(EssentialsM.PREFIX + text[0] + target1.getName() + text[1] + location.getX() + " " + location.getY() + " " + location.getZ() + text[2]);
                    //sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast "+ ChatColor.GOLD+ target1.getName() +" zu " + ChatColor.GOLD+location.getX()+" "+location.getY()+" "+location.getZ()+ChatColor.GREEN+" teleportiert!");
                } catch (NumberFormatException e) {
                    sender.sendMessage(PREFIX + getLang("InvalidCoordinates"));
                }
            }
        }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/tp (Player|Coordinates) <Player|Coordinates>"));
        return true;
    }
}
