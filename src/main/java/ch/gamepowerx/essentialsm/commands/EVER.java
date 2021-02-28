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

import ch.gamepowerx.essentialsm.EssentialsM;
import com.sun.istack.internal.NotNull;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EVER implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ChatColor.GOLD + "[" + ChatColor.GREEN + "EssentialsM" + ChatColor.GOLD + "] " + ChatColor.GREEN + "Version: " + EssentialsM.getVersion());
        sender.sendMessage(ChatColor.GREEN + "Report Problems, Bugs and Errors to\n" + ChatColor.GOLD + "https://github.com/CraftingDragon007/EssentialsM/issues");
        return true;
    }
}
