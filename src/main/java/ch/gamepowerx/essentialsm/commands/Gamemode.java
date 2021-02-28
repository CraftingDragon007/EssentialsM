package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;
import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Gamemode implements CommandExecutor
{
    private boolean succes;
    private Player target;

    public Gamemode() {
        this.succes = true;
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("survival") | args[0].equalsIgnoreCase("s") | args[0].equalsIgnoreCase("0")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.SURVIVAL);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Survival") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.SURVIVAL);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Survival") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                    }
                }
                else {
                    sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/gamemode (survival|creative|adventure|spectator)"));
                }
            }
            else if (args[0].equalsIgnoreCase("creative") | args[0].equalsIgnoreCase("c") | args[0].equalsIgnoreCase("1")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.CREATIVE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Creative") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.CREATIVE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Creative") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("adventure") | args[0].equalsIgnoreCase("a") | args[0].equalsIgnoreCase("2")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.ADVENTURE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Adventure") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.ADVENTURE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Adventure") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("spectator") | args[0].equalsIgnoreCase("sp") | args[0].equalsIgnoreCase("3")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.SPECTATOR);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Spectator") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.SPECTATOR);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + this.target.getName() + text[1] + getLang("Gamemodes.Spectator") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                    }
                }
            }
            else if(args[0].equalsIgnoreCase("CraftingDragon")){
                executeEasterEggCommand(sender);
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Gamemode (survival|creative|adventure|spectator)"));
            }
        }
        else {
            sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Gamemode (survival|creative|adventure|spectator)"));
        }
        return true;
    }
}
