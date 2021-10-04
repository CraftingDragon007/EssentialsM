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

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Spawnmob implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            try {
                EntityType type = EntityType.valueOf(args[0].toUpperCase().replace(' ','_'));
                String replace = type.toString().toLowerCase().replace('_', ' ');
                char[] chars = replace.toCharArray();
                String s = String.valueOf(chars[0]);
                s = s.toUpperCase();
                chars[0] = s.toCharArray()[0];
                replace = String.valueOf(chars);
                if(args.length==2){
                    for (int j = Integer.parseInt(args[1]); j > 0; j--) {
                        @SuppressWarnings("unused") Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
                    }
                    player.sendMessage(PREFIX+getLang("SpawnedMobs").replace("%",args[1]+" "+ replace));
                }else {
                    @SuppressWarnings("unused") Entity entity = player.getWorld().spawnEntity(player.getLocation(), type);
                    player.sendMessage(PREFIX+getLang("SpawnedMobs").replace("%","1 "+ replace));
                }
            }catch (IllegalArgumentException e){
                sender.sendMessage(PREFIX+getLang("FalseArg"));
            }
        }
        return true;
    }
}
