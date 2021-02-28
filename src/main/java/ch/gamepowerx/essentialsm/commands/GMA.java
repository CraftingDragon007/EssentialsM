package ch.gamepowerx.essentialsm.commands;

import ch.gamepowerx.essentialsm.EssentialsM;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class GMA implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length==0){
            if(sender instanceof Player){
                Player player = (Player) sender;
                player.setGameMode(GameMode.ADVENTURE);
                String[] text = getLang("SetPlayerGamemode").split("%");
                sender.sendMessage(EssentialsM.PREFIX + text[0] + player.getName() + text[1] + getLang("Gamemodes.Adventure") + text[2]);
            }
        }else if(args.length==1){
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null){
                target.setGameMode(GameMode.ADVENTURE);
                String[] text = getLang("SetPlayerGamemode").split("%");
                sender.sendMessage(EssentialsM.PREFIX + text[0] + target.getName() + text[1] + getLang("Gamemodes.Adventure") + text[2]);
            }
        }
        return true;
    }
}
