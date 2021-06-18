package me.martin.main.Commands;

import me.martin.main.DataFile.DataFile;
import me.martin.main.Main;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetJoinMessageCommand implements CommandExecutor {

    public SetJoinMessageCommand(Main main){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            if(args.length > 0){

                Player player = (Player) sender;

                DataFile.get().getConfigurationSection(player.getUniqueId().toString()).set("JoinMessage: ", args[0]);

                DataFile.save();

                DataFile.reloadData();

                player.sendMessage(BukkitColorFormat.formatColor("&aYour join message is now: " + DataFile.get().getConfigurationSection(player.getUniqueId().toString()).get("JoinMessage: ")));

            }else{

                Player player = (Player) sender;

                player.sendMessage(BukkitColorFormat.formatColor(DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getString("JoinMessage: ")));
                player.sendMessage(BukkitColorFormat.formatColor("&c/setmessage <joinmessage>"));

            }

        }

        return false;
    }
}
