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

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Listeners implements Listener {
    public static final HashMap<Player, Double> godModeStats = new HashMap<>();
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
    public void onMessageSendEvent(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        //noinspection SpellCheckingInspection
        if(player.hasPermission("essentialsm.colorchat")){
            event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
        }
    }

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event){
        if(event.getEntity() instanceof Player player){
            if(godMode.getOrDefault(player, false)){
                event.setCancelled(true);
                double i = godModeStats.getOrDefault(player, 0D);
                i += event.getDamage();
                DecimalFormat df = new DecimalFormat("#.#");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "-" + df.format(event.getDamage()) + "HP! " + ChatColor.GOLD + df.format(i) + "HP Total!"));
                godModeStats.remove(player);
                godModeStats.put(player, i);
            }
        }
    }

    @EventHandler
    public void onPlayerHungerEvent(FoodLevelChangeEvent event){
        if(event.getEntity() instanceof Player player){
            if(godMode.getOrDefault(player, false)){
                event.setCancelled(true);
            }
        }
    }
}
