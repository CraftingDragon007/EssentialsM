package ch.gamepowerx.essentialsm.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
<<<<<<< Updated upstream
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.*;

public class gamemode implements CommandExecutor {
    private boolean succes = true;
    private Player target;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(args.length == 0)) {
            if (args[0].equalsIgnoreCase("survival") | args[0].equalsIgnoreCase("s") | args[0].equalsIgnoreCase("0")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        target = (Player) sender;
                        target.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Überleben" + ChatColor.GREEN + " gesetzt!");
                    } else
                        sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler ändern!");
                } else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        target = Bukkit.getPlayer(args[1]);
                        target.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Überleben" + ChatColor.GREEN + " gesetzt!");
                    } else sender.sendMessage(PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                } else
                    sender.sendMessage(PREFIX + ChatColor.RED + "Ungültige Argumente! Bitte verwende: /gamemode (survival|creative|adventure|spectator)");
            } else if (args[0].equalsIgnoreCase("creative") | args[0].equalsIgnoreCase("c") | args[0].equalsIgnoreCase("1")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        target = (Player) sender;
                        target.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Kreativ" + ChatColor.GREEN + " gesetzt!");
                    } else
                        sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler ändern!");
                } else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        target = Bukkit.getPlayer(args[1]);
                        target.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Kreativ" + ChatColor.GREEN + " gesetzt!");
                    } else sender.sendMessage(PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                }
            } else if (args[0].equalsIgnoreCase("adventure") | args[0].equalsIgnoreCase("a") | args[0].equalsIgnoreCase("2")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        target = (Player) sender;
                        target.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Abenteuer" + ChatColor.GREEN + " gesetzt!");
                    } else
                        sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler ändern!");
                } else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        target = Bukkit.getPlayer(args[1]);
                        target.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Abenteuer" + ChatColor.GREEN + " gesetzt!");
                    } else sender.sendMessage(PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                }
            } else if (args[0].equalsIgnoreCase("spectator") | args[0].equalsIgnoreCase("sp") | args[0].equalsIgnoreCase("3")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        target = (Player) sender;
                        target.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Zuschauer" + ChatColor.GREEN + " gesetzt!");
                    } else
                        sender.sendMessage(PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler ändern!");
                } else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        target = Bukkit.getPlayer(args[1]);
                        target.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Zuschauer" + ChatColor.GREEN + " gesetzt!");
                    } else sender.sendMessage(PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                }
            } else
                sender.sendMessage(PREFIX + ChatColor.RED + "Bitte verwende /gamemode (survival|creative|adventure|spectator");
        }else sender.sendMessage(PREFIX+ChatColor.GOLD+"Wechsel deinen Spielmodus: /gamemode (survival|creative|adventure|spectator)");
=======
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class gamemode implements CommandExecutor
{
    private boolean succes;
    private Player target;
    
    public gamemode() {
        this.succes = true;
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("survival") | args[0].equalsIgnoreCase("s") | args[0].equalsIgnoreCase("0")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "\u00dcberleben" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler \u00e4ndern!");
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "\u00dcberleben" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                    }
                }
                else {
                    sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Ung\u00fcltige Argumente! Bitte verwende: /gamemode (survival|creative|adventure|spectator)");
                }
            }
            else if (args[0].equalsIgnoreCase("creative") | args[0].equalsIgnoreCase("c") | args[0].equalsIgnoreCase("1")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Kreativ" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler \u00e4ndern!");
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Kreativ" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("adventure") | args[0].equalsIgnoreCase("a") | args[0].equalsIgnoreCase("2")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Abenteuer" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler \u00e4ndern!");
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Abenteuer" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("spectator") | args[0].equalsIgnoreCase("sp") | args[0].equalsIgnoreCase("3")) {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        (this.target = (Player)sender).setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Zuschauer" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Du kannst nur den Gamemode von einem Spieler \u00e4ndern!");
                    }
                }
                else if (args.length == 2) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        (this.target = Bukkit.getPlayer(args[1])).setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.GREEN + "Du hast " + ChatColor.GOLD + this.target.getName() + ChatColor.GREEN + "'s Spielmodus auf " + ChatColor.GOLD + "Zuschauer" + ChatColor.GREEN + " gesetzt!");
                    }
                    else {
                        sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Der Spieler wurde nicht gefunden!");
                    }
                }
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + ChatColor.RED + "Bitte verwende /gamemode (survival|creative|adventure|spectator");
            }
        }
        else {
            sender.sendMessage(EssentialsM.PREFIX + ChatColor.GOLD + "Wechsel deinen Spielmodus: /gamemode (survival|creative|adventure|spectator)");
        }
>>>>>>> Stashed changes
        return true;
    }
}
