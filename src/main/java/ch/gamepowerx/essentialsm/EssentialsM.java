package ch.gamepowerx.essentialsm;

import ch.gamepowerx.essentialsm.commands.*;
import ch.gamepowerx.essentialsm.tabcompleter.Tpacompleter;
import com.sun.istack.internal.NotNull;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class EssentialsM extends JavaPlugin
{
    public static EssentialsM main;
    public static String PREFIX;
    public static FileConfiguration getConfigFile;
    public static HashMap<Player,Boolean> flyEnabled = new HashMap<>();
    public static HashMap<Player, ArrayList<Player>> tpas = new HashMap();
    public static HashMap<Player,Player> lastMsg = new HashMap<>();
    private File langConfigFile;
    private static HashMap<String,String> fallbackLangMap;
    private static FileConfiguration langConfig;
    public void onEnable() {
        loadConfig();
        loadLangConfig();
        loadFallbackLangMap();
        EssentialsM.main = this;
        PREFIX = getLang("prefix");
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("gamemode").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Gamemode());
        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("heal").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Heal());
        this.getCommand("teleport").setExecutor(new Teleport());
        this.getCommand("teleport").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Teleport());
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("fly").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Fly());
        this.getCommand("speed").setExecutor(new Speed());
        this.getCommand("speed").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Speed());
        this.getCommand("tpohere").setExecutor(new Tpohere());
        this.getCommand("tpohere").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Teleport());
        this.getCommand("killall").setExecutor(new Killall());
        this.getCommand("killall").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Killall());
        this.getCommand("tpa").setExecutor(new Tpa());
        this.getCommand("tpa").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Tpa());
        this.getCommand("tpaaccept").setExecutor(new Tpaaccept());
        this.getCommand("tpaaccept").setTabCompleter(new Tpacompleter());
        this.getCommand("tpadeny").setExecutor(new Tpadeny());
        this.getCommand("tpadeny").setTabCompleter(new Tpacompleter());
        this.getCommand("invsee").setExecutor(new Invsee());
        this.getCommand("invsee").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Invsee());
        this.getCommand("msg").setExecutor(new Msg());
        this.getCommand("msg").setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Msg());
        this.getCommand("respond").setExecutor(new Respond());
        Bukkit.getPluginManager().registerEvents(new Listeners(),this);
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

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        getConfigFile = getConfig();
    }

    private void loadLangConfig() {
        langConfigFile = new File(getDataFolder(), "lang.yml");
        if (!langConfigFile.exists()) {
            langConfigFile.getParentFile().mkdirs();
            saveResource("lang.yml", false);
        }
        langConfig = new YamlConfiguration();
        try {
            langConfig.load(langConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void loadFallbackLangMap(){
        fallbackLangMap = new HashMap<>();
        fallbackLangMap.put("Prefix","§6[EssentialsM] §r");
        fallbackLangMap.put("SetPlayerGamemode","§aDu hast §6%s §aGamemode auf §6% §agesetzt!");
        fallbackLangMap.put("OnlyPlayersHaveGamemodes","§cDu kannst nur den Gamemode von einem Spieler ändern!");
        fallbackLangMap.put("Gamemodes.Survival","Survival");
        fallbackLangMap.put("Gamemodes.Creative","Creative");
        fallbackLangMap.put("Gamemodes.Adventure","Adventure");
        fallbackLangMap.put("Gamemodes.Spectator","Spectator");
        fallbackLangMap.put("SetPlayerFlyMode","§aDu hast §6%s §aFlugmodus §6%§a!");
        fallbackLangMap.put("FlyModes.Disabled","deaktiviert");
        fallbackLangMap.put("FlyModes.Enabled","aktiviert");
        fallbackLangMap.put("TeleportedPlayer","§aDu hast §6%§a zu §6%§a teleportiert!");
        fallbackLangMap.put("InvalidCoordinates","§cUngültige Koordinaten!");
        fallbackLangMap.put("HealedPlayer","§aDu hast den Spieler §6%§a geheilt!");
        fallbackLangMap.put("KilledSelectedEntities","§aDie Ausgewählten Entitäten wurden gelöscht!");
        fallbackLangMap.put("MSGPrefix","§6[MSG] §r");
        fallbackLangMap.put("GetMSG","§a% §6> §aDich §6»§f ");
        fallbackLangMap.put("SendMSG","§aDu §6>§a % §6»§f ");
        fallbackLangMap.put("SetPlayerSpeed","§aGeschwindigkeit von §6%§a wurde auf §6%§a gesetzt!");
        fallbackLangMap.put("SentPlayerTPA","§aDu hast §6%§a eine Teleportierungsanfrage gesendet!");
        fallbackLangMap.put("GetPlayerTPA","§aDu hast eine Teleportierungsanfrage von §6%§a erhalten!");
        fallbackLangMap.put("AcceptPlayerTPA","§aZum Annehmen §6/Tpaaccept %§a eingeben!");
        fallbackLangMap.put("DenyPlayerTPA","§cZum Ablehnen §6/Tpadeny %§c eingeben!");
        fallbackLangMap.put("AlreadySendPlayerTPA","§cDu hast dem Spieler §6%§c schon eine Anfrage gesendet!");
        fallbackLangMap.put("YouAcceptedPlayerTPA","§aDu hast die Teleportierungsanfrage von §6%§a angenommen!");
        fallbackLangMap.put("YouDeniedPlayerTPA","§cDu hast die Teleportierungsanfrage von §6%§c abgelehnt!");
        fallbackLangMap.put("OtherAcceptedPlayerTPA","§6%§a hat deine Teleportierungsanfrage angenommen!");
        fallbackLangMap.put("OtherDeniedPlayerTPA","§6%§c hat deine Teleportierungsanfrage abgelehnt!");
        fallbackLangMap.put("CancelledPlayerTPA","§cDu hast deine Teleportierungsanfrage an §6%§c abgebrochen!");
        fallbackLangMap.put("HasNotSendTPA","§cDer Spieler §6%§a hat dir keine Teleportierungsanfrage gesendet!");
        fallbackLangMap.put("YouHaveNoTPAs","§cDu hast keine Teleportierungsanfragen!");
        fallbackLangMap.put("TeleportedHere","§aDu hast §6%§a zu dir teleportiert!");
        fallbackLangMap.put("OnlyPlayersCanRunThisCommand","§cNur Spieler können diesen Befehl ausführen!");
        fallbackLangMap.put("PlayerNotFound","§cDer Spieler wurde nicht gefunden!");
        fallbackLangMap.put("FalseArgs","§cUngültige Argumente! Bitte verwende: %");
        fallbackLangMap.put("FalseArg","§cUngültiges Argument/e!");
    }

    public static FileConfiguration getLangConfig() {
        return langConfig;
    }
    public static String getLangWithSpace(String key){
        return " "+langConfig.getString(key)+" ";
    }
    @NotNull
    public static String getLang(String key){
        if(langConfig.get(key)!=null) {
            return langConfig.getString(key);
        }else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[EssentialsM] Could not get Lang from lang.yml! Getting Lang from FallbackLangManager!");
            return fallbackLangMap.get(key);
        }
    }

}
