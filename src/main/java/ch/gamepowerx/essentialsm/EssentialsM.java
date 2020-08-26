package ch.gamepowerx.essentialsm;

import ch.gamepowerx.essentialsm.commands.*;
import ch.gamepowerx.essentialsm.tabcompleter.tpacompleter;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class EssentialsM extends JavaPlugin
{
    public static EssentialsM main;
    public static String PREFIX;

    public static HashMap<Player,Boolean> flyEnabled = new HashMap<>();
    public static HashMap<Player, ArrayList<Player>> tpas = new HashMap();
    public static HashMap<Player,Player> lastMsg = new HashMap<>();

    public void onEnable() {
        EssentialsM.main = this;
        this.getCommand("gamemode").setExecutor((CommandExecutor)new gamemode());
        this.getCommand("gamemode").setTabCompleter((TabCompleter)new ch.gamepowerx.essentialsm.tabcompleter.gamemode());
        this.getCommand("heal").setExecutor((CommandExecutor)new heal());
        this.getCommand("heal").setTabCompleter((TabCompleter)new ch.gamepowerx.essentialsm.tabcompleter.heal());
        this.getCommand("teleport").setExecutor(new teleport());
        this.getCommand("teleport").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.teleport());
        this.getCommand("fly").setExecutor(new fly());
        this.getCommand("fly").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.fly());
        this.getCommand("speed").setExecutor(new speed());
        this.getCommand("speed").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.speed());
        this.getCommand("tpohere").setExecutor(new tpohere());
        this.getCommand("tpohere").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.teleport());
        this.getCommand("killall").setExecutor(new killall());
        this.getCommand("killall").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.killall());
        this.getCommand("tpa").setExecutor(new tpa());
        this.getCommand("tpa").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.tpa());
        this.getCommand("tpaaccept").setExecutor(new tpaaccept());
        this.getCommand("tpaaccept").setTabCompleter(new tpacompleter());
        this.getCommand("tpadeny").setExecutor(new tpadeny());
        this.getCommand("tpadeny").setTabCompleter(new tpacompleter());
        this.getCommand("invsee").setExecutor(new invsee());
        this.getCommand("invsee").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.invsee());
        this.getCommand("msg").setExecutor(new msg());
        this.getCommand("msg").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.msg());
        this.getCommand("respond").setExecutor(new respond());
        Bukkit.getPluginManager().registerEvents(new listeners(),this);
        Bukkit.getConsoleSender().sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Das Plugin wurde erfolgreich aktiviert!");
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Das Plugin wurde erfolgreich deaktiviert!");
    }
    
    public static EssentialsM getPlugin() {
        return EssentialsM.main;
    }
    
    static {
        EssentialsM.PREFIX = ChatColor.GOLD + "[EssentialsM] " + ChatColor.RESET;
    }
}
