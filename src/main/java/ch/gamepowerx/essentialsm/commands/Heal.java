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

import ch.gamepowerx.essentialsm.CommandUtils;
import org.bukkit.Bukkit;
import ch.gamepowerx.essentialsm.EssentialsM;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

import static ch.gamepowerx.essentialsm.EssentialsM.getLang;

public class Heal implements CommandExecutor
{
    private LivingEntity target;
    
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                if(target.getAttribute(Attribute.GENERIC_MAX_HEALTH)==null){
                    target.setHealth(20);
                }else
                target.setHealth(Objects.requireNonNull(target.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue());
                if(target instanceof Player)
                    ((Player)target).setFoodLevel(20);
                for (final PotionEffectType potionEffect : PotionEffectType.values()) {
                    this.target.removePotionEffect(potionEffect);
                }
                sender.sendMessage(EssentialsM.PREFIX + getLang("HealedPlayer").replace("%", target.getName()));
            }
            else {
                sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Heal <Player>"));
            }
        }
        else if (args.length == 1) {
            Bukkit.getConsoleSender().sendMessage(args[0]);
            Entity entity = CommandUtils.getTarget(sender, args[0]);
            if(entity instanceof LivingEntity){
                target = (LivingEntity) entity;
            }else {
                sender.sendMessage(EssentialsM.PREFIX + getLang("PlayerNotFound"));
                return true;
            }
            if(target.getAttribute(Attribute.GENERIC_MAX_HEALTH)==null){
                target.setHealth(20);
            }else
                target.setHealth(Objects.requireNonNull(target.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue());
            if(target instanceof Player)
                ((Player)target).setFoodLevel(20);
            for (final PotionEffectType potionEffect : PotionEffectType.values()) {
                target.removePotionEffect(potionEffect);
            }
            sender.sendMessage(EssentialsM.PREFIX + getLang("HealedPlayer").replace("%", target.getName()));
        }
        else {
            sender.sendMessage(EssentialsM.PREFIX + getLang("FalseArgs").replace("%","/Heal <Player>"));
        }
        return true;
    }
}
