package me.martin.main.Commands;

import me.martin.main.DataFile.DataFile;
import me.martin.main.Main;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadDataCommand implements CommandExecutor {

    public ReloadDataCommand(Main main){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            DataFile.reloadData();

            player.sendMessage(BukkitColorFormat.formatColor("&aData file has been reloaded!"));

        }

        return false;
    }
}
