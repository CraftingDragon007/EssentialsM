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
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class GMSP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                Player player = (Player) sender;
                player.setGameMode(GameMode.SPECTATOR);
                String[] text = getLang("SetPlayerGamemode").split("%");
                sender.sendMessage(EssentialsM.PREFIX + text[0] + player.getName() + text[1] + getLang("Gamemodes.Spectator") + text[2]);
            }
        }else if(args.length==1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null){
                target.setGameMode(GameMode.SPECTATOR);
                String[] text = getLang("SetPlayerGamemode").split("%");
                sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Spectator") + text[2]);
            }
        }
        return true;
    }
}
