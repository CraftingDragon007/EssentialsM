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

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class Spawnmob implements TabCompleter {
    private final List<String> returnArgs = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        returnArgs.clear();
        if(args.length==1) {
            for(EntityType type : EntityType.values()){
                returnArgs.add(type.toString());
            }
        }else if(args.length==2){
            returnArgs.add(String.valueOf(1));
            returnArgs.add(String.valueOf(2));
            returnArgs.add(String.valueOf(3));
            returnArgs.add(String.valueOf(4));
            returnArgs.add(String.valueOf(5));
            returnArgs.add(String.valueOf(6));
            returnArgs.add(String.valueOf(7));
            returnArgs.add(String.valueOf(8));
            returnArgs.add(String.valueOf(9));
            returnArgs.add(String.valueOf(10));
            returnArgs.add(String.valueOf(11));
            returnArgs.add(String.valueOf(12));
            returnArgs.add(String.valueOf(13));
            returnArgs.add(String.valueOf(14));
            returnArgs.add(String.valueOf(15));
            returnArgs.add(String.valueOf(16));
            returnArgs.add(String.valueOf(17));
            returnArgs.add(String.valueOf(18));
            returnArgs.add(String.valueOf(19));
            returnArgs.add(String.valueOf(20));
        }
        return returnArgs;
    }
}
