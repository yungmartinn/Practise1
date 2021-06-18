package me.martin.main.Commands;

import me.martin.main.DataFile.DataFile;
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

            if (DataFile.get().getConfigurationSection(player.getUniqueId().toString()).contains("Home: ")) {

                Location playerHome = new Location(player.getWorld(), (Double) DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").get("X:"), (Double) DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").get("Y:"), (Double) DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").get("Z:"), (float) DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").getDouble("Yaw:"), (float) DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getConfigurationSection("Home: ").getDouble("Pitch:"));

                player.teleport(playerHome);

                player.sendMessage(BukkitColorFormat.formatColor("&6You are home!"));

            }else{

                player.sendMessage(BukkitColorFormat.formatColor("&cYou didn't set your home yet! Do /sethome!"));

            }
        }
        return false;
    }
}
