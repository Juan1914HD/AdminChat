package me.javipepe.adminchat;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main
        extends JavaPlugin
{
    public void onEnable()
    {
        getLogger().info("[AdminChat] Enabled");
    }

    public void onDisable()
    {
        getLogger().info("[AdminChat] Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("a"))
        {
            if (sender.isOp()) {
                if (args.length < 2)
                {
                    sender.sendMessage(ChatColor.RED + "Usage: /a chat [message]");
                }
                else
                {
                    String ReportName = args[0];
                    String ReportReson = "";
                    for (int i = 1; i <= args.length - 1; i++)
                    {
                        ReportReson = ReportReson + args[i];
                        if (i != args.length - 1) {
                            ReportReson = ReportReson + " ";
                        }
                    }
                    Player[] arrayOfPlayer;
                    int j = (arrayOfPlayer = getServer().getOnlinePlayers()).length;
                    for (int i = 0; i < j; i++)
                    {
                        Player player = arrayOfPlayer[i];
                        Player s = (Player) sender
                        Location location = player.getLocation();
                        if (player.isOp())
                        {
                            player.sendMessage(ChatColor.WHITE + "[" + ChatColor.GOLD + "A" + ChatColor.WHITE + "]" + ChatColor.WHITE + " [" + ChatColor.GOLD + "world1" + ChatColor.WHITE + "] " + ChatColor.DARK_AQUA + s.getDisplayName() + ChatColor.YELLOW + ": " + ReportReson);
                            player.playSound(location, Sound.NOTE_BASS_GUITAR, 1.0F, 0.0F);
                        }
                    }
                }
            }else{
                sender.sendMessage(ChatColor.RED + "You don´t have permission to use adminchat!");
                return false;
            }
            return true;
        }

        return false;
    }
}
