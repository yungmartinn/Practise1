package me.martin.main;

import me.martin.main.Commands.*;
import me.martin.main.DataFile.DataFile;
import me.martin.main.EventListeners.PlayerFirstJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static PluginManager pluginManager;

    @Override
    public void onEnable() {

        DataFile.setupDataFile();

        registerCommands();

        registerEvents();

    }

    @Override
    public void onDisable() {

        DataFile.save();

    }

    public void registerCommands(){

        getCommand("datareload").setExecutor(new ReloadDataCommand(this));

        getCommand("setmessage").setExecutor(new SetJoinMessageCommand(this));

        getCommand("sethome").setExecutor(new SetHomeCommand(this));

        getCommand("home").setExecutor(new HomeCommand(this));

        getCommand("delhome").setExecutor(new DeleteHomeCommand(this));

    }

    public void registerEvents(){

        pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerFirstJoin(), this);

    }

}
