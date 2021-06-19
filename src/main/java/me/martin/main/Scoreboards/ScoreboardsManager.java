package me.martin.main.Scoreboards;

import jdk.internal.org.jline.reader.ConfigurationPath;
import me.martin.main.Main;
import me.martin.main.Utils.BukkitColorFormat;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardsManager {

    private static Main plugin = (Main) Main.getProvidingPlugin(Main.class);

    private static ScoreboardManager scoreboardManager;
    private static Scoreboard scoreboard;
    private static Objective objective;

    //Scores
    private static Score line0;
    private static Score line1;
    private static Score line2;
    private static Score line3;
    private static Score line4;
    private static Score line5;
    private static Score line6;

    public static Scoreboard createScoreboard(Player player){

        String scoreboard_name = plugin.getConfig().getString("Scoreboard.Name");

        String server_ip = plugin.getConfig().getString("Scoreboard.Server_IP");

        //Setting up scoreboard
        scoreboardManager = Bukkit.getScoreboardManager();

        scoreboard = scoreboardManager.getNewScoreboard();

        objective = scoreboard.registerNewObjective("Scoreboard", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.setDisplayName(BukkitColorFormat.formatColor(scoreboard_name));

        line0 = objective.getScore(BukkitColorFormat.formatColor("&bMob Kills: &f" + player.getStatistic(Statistic.MOB_KILLS)));

        line1 = objective.getScore(BukkitColorFormat.formatColor("&bPlayer Kills: &f" + player.getStatistic(Statistic.PLAYER_KILLS)));

        line2 = objective.getScore(BukkitColorFormat.formatColor("&bDeaths: &f" + player.getStatistic(Statistic.DEATHS)));

        line3 = objective.getScore(BukkitColorFormat.formatColor("&bPlayer: &f" + player.getDisplayName()));

        line4 = objective.getScore(BukkitColorFormat.formatColor("&bServer: &f" + server_ip));

        line5 = objective.getScore(BukkitColorFormat.formatColor("&8&m-----------------------------"));

        line6 = objective.getScore(BukkitColorFormat.formatColor("&8&m-----------------------------&r"));

        //Settings lines to scoreboard
        line5.setScore(6);
        line0.setScore(5);
        line1.setScore(4);
        line2.setScore(3);
        line3.setScore(2);
        line4.setScore(1);
        line6.setScore(0);

        return scoreboard;
    }

    public static void displayScoreboard(Player player, Scoreboard scoreboard){

        player.setScoreboard(scoreboard);

    }

}
