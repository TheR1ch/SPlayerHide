package org.main.ph;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.main.ph.Commands.Command;
import org.main.ph.Commands.HVCommand;
import org.main.ph.Listeners.PlayerListener;
import org.main.ph.Utils.Color;

import java.util.HashMap;

public final class PH extends JavaPlugin {

    public static PH Instance;

    public PH(){
        Instance = this;
    }

    @Override
    public void onEnable() {

        saveDefaultConfig();

        if (this.getConfig().getBoolean("Settings.GiveItemJoin")){
            this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        }
        this.getServer().getPluginCommand("shelp").setExecutor(new HVCommand());
        this.getServer().getPluginCommand("hideplayers").setExecutor(new Command());
        Bukkit.getLogger().info(Color.translate("SPlayerHide&r &#2A8DFBis started!"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
