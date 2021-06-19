package me.martin.main.Commands;

import me.martin.main.DataFile.HomeDataFile;
import me.martin.main.Main;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

    public HomeCommand(Main main){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;

            if (HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).contains("Home: ")) {

                Location playerHome = new Location(player.getWorld(), (Double) HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").get("X:"), (Double) HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").get("Y:"), (Double) HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").get("Z:"), (float) HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").getDouble("Yaw:"), (float) HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").getDouble("Pitch:"));

                player.teleport(playerHome);

                player.sendMessage(BukkitColorFormat.formatColor("&6You are home!"));

            }else{

                player.sendMessage(BukkitColorFormat.formatColor("&cYou didn't set your home yet! Do /sethome!"));

            }
        }
        return false;
    }
}
