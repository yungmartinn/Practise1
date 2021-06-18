package me.martin.main.Utils;

import org.bukkit.ChatColor;

public class BukkitColorFormat {

    public static String formatColor(String string){

        return ChatColor.translateAlternateColorCodes('&', string);

    }

}
