package ch.gamepowerx.essentialsm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static ch.gamepowerx.essentialsm.EssentialsM.PREFIX;
import static ch.gamepowerx.essentialsm.EssentialsM.flyEnabled;

public class listeners implements Listener {
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
        event.setQuitMessage("");
    }
    @EventHandler
    public void onPlayerKickedEvent(PlayerKickEvent event){
        Bukkit.broadcastMessage(PREFIX+ ChatColor.GOLD+"Der Spieler "+ChatColor.RED+event.getPlayer().getName()+ChatColor.GOLD+" war \"leider\" nicht artig und wurde vom Server geworfen!");

    }
}
