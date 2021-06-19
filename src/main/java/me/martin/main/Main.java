package me.martin.main;

import me.martin.main.Commands.*;
import me.martin.main.DataFile.HomeDataFile;
import me.martin.main.Scoreboards.ScoreboardEvents.UpdateScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static PluginManager pluginManager;

    @Override
    public void onEnable() {

        HomeDataFile.setupDataFile();

        registerCommands();

        registerEvents();

        config();

    }

    @Override
    public void onDisable() {

        HomeDataFile.save();

    }

    public void registerCommands(){

        getCommand("datareload").setExecutor(new ReloadDataCommand(this));

        getCommand("sethome").setExecutor(new SetHomeCommand(this));

        getCommand("home").setExecutor(new HomeCommand(this));

        getCommand("delhome").setExecutor(new DeleteHomeCommand(this));

    }

    public void registerEvents(){

        pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new UpdateScoreboard(this), this);

    }

    public void config(){

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

}
