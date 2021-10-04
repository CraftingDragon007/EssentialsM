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

import java.util.ArrayList;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Tpa implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player from = (Player) sender;
            if(args.length==1){
               Player to = Bukkit.getPlayer(args[0]);
               if(to!=null){
                   if(tpas.containsKey(to)) {
                       if (!tpas.get(to).contains(from)) {
                           tpas.get(to).add(from);
                           from.sendMessage(PREFIX+getLang("SentPlayerTPA").replace("%",to.getName()));
                           to.sendMessage(PREFIX+getLang("GetPlayerTPA").replace("%",from.getName()));
                           to.sendMessage(PREFIX+getLang("AcceptPlayerTPA").replace("%",from.getName()));
                           to.sendMessage(PREFIX+getLang("DenyPlayerTPA").replace("%", from.getName()));
                       }else from.sendMessage(PREFIX+getLang("AlreadySendPlayerTPA").replace("%",to.getName()));
                   }else {
                       ArrayList<Player> request = new ArrayList<>();
                       request.add(from);
                       tpas.put(to,request);
                       from.sendMessage(PREFIX+getLang("SentPlayerTPA").replace("%",to.getName()));
                       to.sendMessage(PREFIX+getLang("GetPlayerTPA").replace("%",from.getName()));
                       to.sendMessage(PREFIX+getLang("AcceptPlayerTPA").replace("%",from.getName()));
                       to.sendMessage(PREFIX+getLang("DenyPlayerTPA").replace("%", from.getName()));
                   }
               }else sender.sendMessage(PREFIX+getLang("PlayerNotFound"));
            }else sender.sendMessage(PREFIX+getLang("FalseArgs").replace("%","/Tpa <Player>"));
        }else sender.sendMessage(PREFIX+getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
