package org.main.ph.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.main.ph.PH;
import org.main.ph.Utils.Color;

import java.io.IOException;
import java.util.Arrays;

public class HVCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player){
         Player player = (Player) commandSender;
         if (args.length < 1) {
             player.sendMessage(Color.translate(" \nПомощь по плагину: \n  \n /hideplayer - скрыть игроков/показать игроков \n "));
         } else if (args[0].equalsIgnoreCase("reload")) {
             PH.Instance.reloadConfig();
             player.sendTitle(Color.translate("&aSuccessful reload!"), "");
             player.spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation(), 20);
         }
        }
        return true;
    }
}
