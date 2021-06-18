package me.martin.main.DataFile;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataFile {

    private static File file;
    private static FileConfiguration fileConfiguration;

    public static void setupDataFile(){

        file = new File(Bukkit.getServer().getPluginManager().getPlugin("MujPlugin").getDataFolder(), "data.yml");

        if(!file.exists()){

            try {
                file.createNewFile();
            }catch (IOException e){

            }

        }

        fileConfiguration = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get(){

        return fileConfiguration;

    }

    public static void save(){

        try {

            fileConfiguration.save(file);

        }catch (IOException e){
            System.out.println("Couldn't save the file!");
        }

    }

    public static void reloadData(){

        fileConfiguration = YamlConfiguration.loadConfiguration(file);

    }

}
