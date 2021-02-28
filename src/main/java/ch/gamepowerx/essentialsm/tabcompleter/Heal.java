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

import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.List;
import org.bukkit.command.TabCompleter;

public class Heal implements TabCompleter
{
    private List<String> returnArgs = new ArrayList<>();
    
    public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        this.returnArgs.clear();
        if (args.length == 1) {
            if(!Bukkit.getOnlinePlayers().isEmpty()) {
                for (final Player player : Bukkit.getOnlinePlayers()) {
                    this.returnArgs.add(player.getName());
                }
            }
        }
        return this.returnArgs;
    }
}
