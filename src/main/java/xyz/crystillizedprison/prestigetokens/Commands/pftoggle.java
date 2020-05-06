package xyz.crystillizedprison.prestigetokens.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

public class pftoggle implements CommandExecutor {

    public pftoggle(PrestigeTokens main) {
        Main = main;
    }

    PrestigeTokens Main;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = ((Player) sender).getPlayer();

            if (Main.getPftoggle().contains(p)){
                p.sendMessage(ChatColor.DARK_AQUA+"Pouch Finder Notifcations Toggled " + ChatColor.AQUA + "ON");
                Main.getPftoggle().remove(p);
            }else{
                p.sendMessage(ChatColor.DARK_AQUA+"Pouch Finder Notifcations Toggled " + ChatColor.AQUA + "OFF");
                Main.getPftoggle().add(p);
            }
        }

        return false;
    }
}
