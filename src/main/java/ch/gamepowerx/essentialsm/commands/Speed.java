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

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Speed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==1){
            if(sender instanceof Player player) {
                int speed;
                try {
                    try {
                        if(args[0].equalsIgnoreCase("reset")){
                            args[0] = "1";
                        }
                        speed = Integer.parseInt(args[0]);
                        if (!(speed < 1 || speed > 10)) {
                            if(speed != 10)
                            speed++;
                            player.setWalkSpeed((float) speed / 10);
                            if(speed != 10)
                            speed--;
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
                int speed;
                try {
                    assert player != null;
                    try {
                        speed = Integer.parseInt(args[1]);
                        if (!(speed < 1 || speed > 10)) {
                            if(speed != 10)
                                speed++;
                            player.setWalkSpeed((float) speed / 10);
                            if(speed != 10)
                                speed--;
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
