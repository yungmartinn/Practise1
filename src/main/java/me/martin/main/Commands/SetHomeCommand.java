package me.martin.main.Commands;

import me.martin.main.DataFile.HomeDataFile;
import me.martin.main.Main;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHomeCommand implements CommandExecutor {

    public SetHomeCommand(Main main){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(!HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).contains("Home: ")){

                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).createSection("Home: ").set("X:", player.getLocation().getX());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Y:", player.getLocation().getY());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Z:", player.getLocation().getZ());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Yaw:", player.getLocation().getYaw());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Pitch:", player.getLocation().getPitch());

                HomeDataFile.save();

                HomeDataFile.reloadData();


                player.sendMessage(BukkitColorFormat.formatColor("&6You've set home!"));

            }else{

                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("X:", player.getLocation().getX());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Y:", player.getLocation().getY());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Z:", player.getLocation().getZ());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Yaw:", player.getLocation().getYaw());
                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Pitch:", player.getLocation().getPitch());

                HomeDataFile.save();

                HomeDataFile.reloadData();

                player.sendMessage(BukkitColorFormat.formatColor("&6You've overwritten your previous home!"));

            }

        }

        return false;
    }
}
