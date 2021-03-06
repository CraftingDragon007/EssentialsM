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

package ch.gamepowerx.essentialsm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.event.server.ServerCommandEvent;

import java.util.List;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Listeners implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        event.setJoinMessage("");
        if(flyEnabled.containsKey(event.getPlayer())){
            if(flyEnabled.get(event.getPlayer())){
                Player player = event.getPlayer();
                player.setAllowFlight(true);
                player.setFlying(true);
            }
        }
    }
    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent event){
        for(List<Player> list : tpas.values()){
            list.remove(event.getPlayer());
        }
        lastMsg.values().removeIf(p -> p.equals(event.getPlayer()));
        event.setQuitMessage("");
    }
    @EventHandler
    public void onPlayerKickedEvent(PlayerKickEvent event){
        //Bukkit.broadcastMessage(PREFIX+ ChatColor.GOLD+"Der Spieler "+ChatColor.RED+event.getPlayer().getName()+ChatColor.GOLD+" war \"leider\" nicht artig und wurde vom Server geworfen!");
    }
    @EventHandler
    public void onCommandExecuteEvent(ServerCommandEvent event){

    }

    @EventHandler
    public void onMessageSendEvent(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("essentialsm.colorchat")){
            event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
        }
    }
}
