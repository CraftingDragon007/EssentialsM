package ch.gamepowerx.essentialsm;

<<<<<<< Updated upstream
import ch.gamepowerx.essentialsm.commands.gamemode;
import ch.gamepowerx.essentialsm.commands.heal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialsM extends JavaPlugin {
public static EssentialsM main;
public static String PREFIX = ChatColor.GOLD+"[EssentialsM] "+ChatColor.RESET;
    @Override
    public void onEnable() {
        // Plugin startup logic
        main = this;
        getCommand("gamemode").setExecutor(new gamemode());
        getCommand("gamemode").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.gamemode());
        getCommand("heal").setExecutor(new heal());
        getCommand("heal").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.heal());
        Bukkit.getConsoleSender().sendMessage(PREFIX+ChatColor.GREEN+"Das Plugin wurde erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(PREFIX+ChatColor.RED+"Das Plugin wurde erfolgreich deaktiviert!");
    }

    public static EssentialsM getPlugin(){
        return main;
=======
import ch.gamepowerx.essentialsm.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class EssentialsM extends JavaPlugin
{
    public static EssentialsM main;
    public static String PREFIX;
    public static HashMap<Player,Boolean> flyEnabled = new HashMap<>();

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
>>>>>>> Stashed changes
    }
}
