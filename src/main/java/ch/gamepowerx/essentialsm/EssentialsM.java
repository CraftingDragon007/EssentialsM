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

import ch.gamepowerx.essentialsm.commands.*;
import ch.gamepowerx.essentialsm.tabcompleter.Tpacompleter;
import ch.gamepowerx.notes.Notes;
import ch.gamepowerx.notes.Song;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@SuppressWarnings("unused")
public final class EssentialsM extends JavaPlugin
{
    public static EssentialsM main;
    private static String version;
    public static String PREFIX;
    public static FileConfiguration getConfigFile;
    public static final HashMap<Player, Boolean> flyEnabled = new HashMap<>();
    public static final HashMap<Player, ArrayList<Player>> tpas = new HashMap<>();
    public static final HashMap<Player, Player> lastMsg = new HashMap<>();
    public static final HashMap<Player, Boolean> godMode = new HashMap<>();
    private static HashMap<String, String> fallbackLangMap;
    private static FileConfiguration langConfig;
    @SuppressWarnings("SpellCheckingInspection")
    public void onEnable() {
        loadConfig();
        loadLangConfig();
        loadFallbackLangMap();
        EssentialsM.main = this;
        version = this.getDescription().getVersion();
        PREFIX = getLang("Prefix");
        Objects.requireNonNull(this.getCommand("gamemode")).setExecutor(new Gamemode());
        Objects.requireNonNull(this.getCommand("gamemode")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Gamemode());
        Objects.requireNonNull(this.getCommand("gmc")).setExecutor(new GMC());
        Objects.requireNonNull(this.getCommand("gms")).setExecutor(new GMS());
        Objects.requireNonNull(this.getCommand("gma")).setExecutor(new GMA());
        Objects.requireNonNull(this.getCommand("gmsp")).setExecutor(new GMSP());
        Objects.requireNonNull(this.getCommand("ever")).setExecutor(new EVER());
        Objects.requireNonNull(this.getCommand("heal")).setExecutor(new Heal());
        Objects.requireNonNull(this.getCommand("heal")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Heal());
        Objects.requireNonNull(this.getCommand("teleport")).setExecutor(new Teleport());
        Objects.requireNonNull(this.getCommand("teleport")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Teleport());
        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(this.getCommand("fly")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Fly());
        Objects.requireNonNull(this.getCommand("speed")).setExecutor(new Speed());
        Objects.requireNonNull(this.getCommand("speed")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Speed());
        Objects.requireNonNull(this.getCommand("tpohere")).setExecutor(new Tpohere());
        Objects.requireNonNull(this.getCommand("tpohere")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Teleport());
        Objects.requireNonNull(this.getCommand("kill")).setExecutor(new Kill());
        Objects.requireNonNull(this.getCommand("killall")).setExecutor(new Killall());
        Objects.requireNonNull(this.getCommand("killall")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Killall());
        Objects.requireNonNull(this.getCommand("tpa")).setExecutor(new Tpa());
        Objects.requireNonNull(this.getCommand("tpa")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Tpa());
        Objects.requireNonNull(this.getCommand("tpaaccept")).setExecutor(new Tpaaccept());
        Objects.requireNonNull(this.getCommand("tpaaccept")).setTabCompleter(new Tpacompleter());
        Objects.requireNonNull(this.getCommand("tpadeny")).setExecutor(new Tpadeny());
        Objects.requireNonNull(this.getCommand("tpadeny")).setTabCompleter(new Tpacompleter());
        Objects.requireNonNull(this.getCommand("invsee")).setExecutor(new Invsee());
        Objects.requireNonNull(this.getCommand("invsee")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Invsee());
        Objects.requireNonNull(this.getCommand("msg")).setExecutor(new Msg());
        Objects.requireNonNull(this.getCommand("msg")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Msg());
        Objects.requireNonNull(this.getCommand("respond")).setExecutor(new Respond());
        Objects.requireNonNull(this.getCommand("spawnmob")).setExecutor(new Spawnmob());
        Objects.requireNonNull(this.getCommand("spawnmob")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Spawnmob());
        Objects.requireNonNull(this.getCommand("tpall")).setExecutor(new Tpall());
        Objects.requireNonNull(this.getCommand("tpall")).setTabCompleter(new ch.gamepowerx.essentialsm.tabcompleter.Fly());
        Objects.requireNonNull(this.getCommand("sudo")).setExecutor(new Sudo());
        Bukkit.getPluginManager().registerEvents(new Listeners(),this);
        Bukkit.getConsoleSender().sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Das Plugin wurde erfolgreich aktiviert!");
    }
    
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Das Plugin wurde erfolgreich deaktiviert!");
    }
    
    public static EssentialsM getPlugin() {
        return EssentialsM.main;
    }

    public static String getVersion() {
        return version;
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
        File langConfigFile = new File(getDataFolder(), "lang.yml");
        if (!langConfigFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
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

    public static void executeEasterEggCommand(CommandSender sender){
        sender.sendMessage(PREFIX + getLang("EasterEgg"));
        Song song = new Song("NeverGonnaGiveYouUp","KekOnTheWorld", Instrument.PIANO);
        String[] args = ("0G -4T 0A -4T 0C -4T 0A -4T 0E -8T -2T 0E -8T 0D -8T -4T 0G -4T 0A -4T 0C -4T 0A -4T 0D -8T -2T 0D -8T 0C -8T 0B -4T 0A -2T -4T 0G -4T 0A -4T 0C -4T 0A -2T -2T 0C -8T -4T 0D -8T 0B -6T 0A -4T 0G -8T -2T 0G -8T 0D -8T -4T 0C").split(" ");
        if(!Notes.songs.contains(song)){
            Notes.songs.add(song);
        }
        int count = 0;
        while(count < args.length) {
            song.addNotes(Song.parseNote(args[count]));
            count++;
        }
        if(sender instanceof Player){
            song.playSong((Player) sender);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
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
        fallbackLangMap.put("Modes.Disabled","deaktiviert");
        fallbackLangMap.put("Modes.Enabled","aktiviert");
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
        fallbackLangMap.put("SpawnedMobs", "§aEs wurde/n % gespawnt!");
        fallbackLangMap.put("AllPlayers", "alle Spieler");
        fallbackLangMap.put("EasterEgg","§aGratuliere du hast den Easteregg Befehl gefunden!");
        fallbackLangMap.put("CommandExecutedSuccessfully", "§aDer Befehl wurde erfolgreich ausgeführt!");

        fallbackLangMap.put("OnlyPlayersCanRunThisCommand","§cNur Spieler können diesen Befehl ausführen!");
        fallbackLangMap.put("PlayerNotFound","§cDer Spieler wurde nicht gefunden!");
        fallbackLangMap.put("FalseArgs","§cUngültige Argumente! Bitte verwende: %");
        fallbackLangMap.put("FalseArg","§cUngültiges Argument/e!");
    }

    public static String getLang(String key){
        if(langConfig.get(key) != null) {
            return langConfig.getString(key);
        }else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[EssentialsM] Could not get Lang from lang.yml! Getting Lang from FallbackLangManager!");
            return fallbackLangMap.get(key);
        }
    }

}
