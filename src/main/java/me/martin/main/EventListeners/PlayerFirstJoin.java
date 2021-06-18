package me.martin.main.EventListeners;

import me.martin.main.DataFile.DataFile;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        e.setJoinMessage(null);

        Player player = e.getPlayer();

        if(!DataFile.get().contains(player.getUniqueId().toString())){

            DataFile.get().createSection(player.getUniqueId().toString()).addDefault("JoinMessage: ", BukkitColorFormat.formatColor("&eWelcome back to the server!"));

            player.sendTitle(BukkitColorFormat.formatColor("&6Welcome to the server,"), BukkitColorFormat.formatColor("&e" + player.getDisplayName()));


        }else{

            player.sendMessage(BukkitColorFormat.formatColor(DataFile.get().getConfigurationSection(player.getUniqueId().toString()).getString("JoinMessage: ")));

        }

    }

}
