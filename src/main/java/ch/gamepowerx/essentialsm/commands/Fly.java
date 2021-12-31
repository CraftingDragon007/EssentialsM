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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length==0){
            if(sender instanceof Player player){
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    flyEnabled.put(player,false);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("Modes.Disabled"));
                }else if(!player.getAllowFlight()){
                    player.setAllowFlight(true);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("Modes.Enabled"));
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Fly <Player>"));
        }else if(args.length==1){
            if(Bukkit.getPlayer(args[0])!=null){
                Player player = Bukkit.getPlayer(args[0]);
                assert player != null;
                if(player.getAllowFlight()){
                    player.setAllowFlight(false);
                    flyEnabled.put(player,false);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("Modes.Disabled"));
                }else if(!player.getAllowFlight()){
                    player.setAllowFlight(true);
                    flyEnabled.put(player,true);
                    String[] text = getLang("SetPlayerFlyMode").split("%");
                    sender.sendMessage(PREFIX + text[0] + player.getName() + text[1] + getLang("Modes.Enabled"));
                }
            }else sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
        }else sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Fly (Player)"));
        return true;
    }
}
