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

@SuppressWarnings("SpellCheckingInspection")
public class Tpaaccept implements CommandExecutor {
    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            if(args.length == 0){
                Player from = tpas.get(player).get(tpas.get(player).size() - 1);
                if (from != null) {
                    if (tpas.containsKey(player)){
                        if(tpas.get(player).contains(from)){
                            sender.sendMessage(PREFIX + getLang("YouAcceptedPlayerTPA").replace("%", from.getName()));
                            from.sendMessage(PREFIX + getLang("OtherAcceptedPlayerTPA").replace("%", sender.getName()));
                            tpas.get(from).remove(player);
                            from.teleport(player);
                        }else sender.sendMessage(PREFIX+getLang("HasNotSendTPA").replace("%",from.getName()));
                    } else sender.sendMessage(PREFIX+getLang("YouHaveNoTPAs"));
                } else sender.sendMessage(PREFIX + getLang("PlayerNotFound"));
            }else
            if (args.length == 1) {
                Player from = Bukkit.getPlayer(args[0]);
                if (from != null) {
                    if (tpas.containsKey(player)){
                        if(tpas.get(player).contains(from)){
                            sender.sendMessage(PREFIX + getLang("YouAcceptedPlayerTPA").replace("%", from.getName()));
                            from.sendMessage(PREFIX + getLang("OtherAcceptedPlayerTPA").replace("%", sender.getName()));
                            from.teleport(player);
                            tpas.get(player).remove(from);
                        }else sender.sendMessage(PREFIX+getLang("HasNotSendTPA").replace("%",from.getName()));
                    } else sender.sendMessage(PREFIX+getLang("YouHaveNoTPAs"));
                } else sender.sendMessage(PREFIX + getLang("PlayerNotFound"));
            } else sender.sendMessage(PREFIX + getLang("FalseArgs").replace("%","/tpaccept <Player>"));
        }else sender.sendMessage(PREFIX+getLang("OnlyPlayersCanRunThisCommand"));
        return true;
    }
}
