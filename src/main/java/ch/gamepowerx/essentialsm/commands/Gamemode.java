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

import org.bukkit.Bukkit;
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class Gamemode implements CommandExecutor
{

    public Gamemode() {

    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length != 0) {
            Player target;
            if (args[0].equalsIgnoreCase("survival") | args[0].equalsIgnoreCase("s") | args[0].equalsIgnoreCase("0")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (target = (Player)sender).setGameMode(GameMode.SURVIVAL);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Survival") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (Objects.requireNonNull(target = Bukkit.getPlayer(args[1]))).setGameMode(GameMode.SURVIVAL);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Survival") + text[2]);
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
                        (target = (Player)sender).setGameMode(GameMode.CREATIVE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Creative") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (Objects.requireNonNull(target = Bukkit.getPlayer(args[1]))).setGameMode(GameMode.CREATIVE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Creative") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("adventure") | args[0].equalsIgnoreCase("a") | args[0].equalsIgnoreCase("2")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (target = (Player)sender).setGameMode(GameMode.ADVENTURE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Adventure") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (Objects.requireNonNull(target = Bukkit.getPlayer(args[1]))).setGameMode(GameMode.ADVENTURE);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Adventure") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("spectator") | args[0].equalsIgnoreCase("sp") | args[0].equalsIgnoreCase("3")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (target = (Player)sender).setGameMode(GameMode.SPECTATOR);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Spectator") + text[2]);
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + getLang("OnlyPlayersHaveGamemodes"));
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (Objects.requireNonNull(target = Bukkit.getPlayer(args[1]))).setGameMode(GameMode.SPECTATOR);
                        String[] text = getLang("SetPlayerGamemode").split("%");
                        sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Spectator") + text[2]);
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
