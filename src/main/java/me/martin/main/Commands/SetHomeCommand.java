package me.martin.main.Commands;

import me.martin.main.DataFile.DataFile;
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

            if(!DataFile.get().getConfigurationSection(player.getUniqueId().toString()).contains("Home: ")){

                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).createSection("Home: ").set("X:", player.getLocation().getX());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Y:", player.getLocation().getY());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Z:", player.getLocation().getZ());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Yaw:", player.getLocation().getYaw());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Pitch:", player.getLocation().getPitch());

                DataFile.save();

                DataFile.reloadData();


                player.sendMessage(BukkitColorFormat.formatColor("&6You've set home!"));

            }else{

                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("X:", player.getLocation().getX());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Y:", player.getLocation().getY());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Z:", player.getLocation().getZ());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Yaw:", player.getLocation().getYaw());
                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").set("Pitch:", player.getLocation().getPitch());

                DataFile.save();

                DataFile.reloadData();

                player.sendMessage(BukkitColorFormat.formatColor("&6You've overwritten your previous home!"));

            }

        }

        return false;
    }
}
