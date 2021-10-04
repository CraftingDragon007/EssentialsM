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

package ch.gamepowerx.essentialsm.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Speed implements TabCompleter {
    private final List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1){
            if(!Bukkit.getOnlinePlayers().isEmpty()){
                for(Player player : Bukkit.getOnlinePlayers()){
                    returnArgs.add((player.getName()));
                }
                returnArgs.add("1");
                returnArgs.add("2");
                returnArgs.add("3");
                returnArgs.add("4");
                returnArgs.add("5");
                returnArgs.add("6");
                returnArgs.add("7");
                returnArgs.add("8");
                returnArgs.add("9");
                returnArgs.add("10");
                returnArgs.add("reset");
            }
        }else if(args.length==2){
            returnArgs.add("1");
            returnArgs.add("2");
            returnArgs.add("3");
            returnArgs.add("4");
            returnArgs.add("5");
            returnArgs.add("6");
            returnArgs.add("7");
            returnArgs.add("8");
            returnArgs.add("9");
            returnArgs.add("10");
            returnArgs.add("reset");
        }
        return returnArgs;
    }
}
