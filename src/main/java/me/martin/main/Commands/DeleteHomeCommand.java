package me.martin.main.Commands;

import me.martin.main.DataFile.HomeDataFile;
import me.martin.main.Main;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeleteHomeCommand implements CommandExecutor {

    public DeleteHomeCommand(Main main){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).contains("Home: ")){

                HomeDataFile.get().getConfigurationSection(player.getUniqueId().toString()).set("Home: ", null);

                HomeDataFile.save();

                HomeDataFile.reloadData();

                player.sendMessage(BukkitColorFormat.formatColor("&cYou have deleted your home!"));

            }else{

                player.sendMessage(BukkitColorFormat.formatColor("&cYou don't have any home!"));

            }

        }

        return false;
    }
}
