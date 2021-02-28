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

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Msg implements CommandExecutor {
    public static String msgPrefix = getLang("MSGPrefix");
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
                    player.sendMessage(msgPrefix+getLang("SendMSG").replace("%",target.getName())+message);
                    target.sendMessage(msgPrefix+getLang("GetMSG").replace("%",player.getName())+message);
                    target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1,1);
                }else sender.sendMessage(PREFIX+getLang("PlayerNotFound"));
            }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%","/Msg <Spieler> <Nachricht>"));
        }else sender.sendMessage(PREFIX + getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
