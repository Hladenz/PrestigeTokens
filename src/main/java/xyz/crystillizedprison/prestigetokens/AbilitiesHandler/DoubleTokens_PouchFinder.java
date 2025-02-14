package xyz.crystillizedprison.prestigetokens.AbilitiesHandler;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.Random;

public class DoubleTokens_PouchFinder implements CommandExecutor {

    public DoubleTokens_PouchFinder(PrestigeTokens main) {
        Main = main;
    }

    PrestigeTokens Main;

    public static Boolean getChance(double chance) {
        Random rand = new Random();
        double random = Math.random() * 100;

        return random <= chance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player)sender;
            if (!p.hasPermission("ptokens.Admin")){
                return true;
            }
        }

        Player p = Bukkit.getPlayer(args[0]);
        int DoubleTokens = Main.GetPlayerDoubleTokens(p);
        int PouchFinder = Main.GetPlayerPouchFinder(p);
        System.out.println("Played Mined 100 blocks p:" + p.getName() + " DT:" + DoubleTokens + " PFf" +PouchFinder);
        if (PouchFinder != 0){
            if (getChance(2 + ((PouchFinder-1)*1 ) )){
            //COMMON
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "amc pouch give " + p.getName() + " Common");
                if (!Main.getPftoggle().contains(p)) {
                    p.sendMessage(ChatColor.DARK_AQUA + "Pouch Finder Got you A " + ChatColor.AQUA + " Common " + ChatColor.DARK_AQUA + "Pouch");
                }
            }else if (getChance(2 + ((PouchFinder-15)*0.15 ) )  && PouchFinder >= 15){
            //RARE
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "amc pouch give " + p.getName() + " Rare");
                if (!Main.getPftoggle().contains(p)) {
                    p.sendMessage(ChatColor.DARK_AQUA + "Pouch Finder Got you A " + ChatColor.AQUA + " Rare " + ChatColor.DARK_AQUA + "Pouch");
                }
            }else if (getChance((PouchFinder-25)*0.01 ) && PouchFinder >= 25){
            //LEGENDARY
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "amc pouch give " + p.getName() + " Legendary");
                if (!Main.getPftoggle().contains(p)) {
                    p.sendMessage(ChatColor.DARK_AQUA + "Pouch Finder Got you A " + ChatColor.AQUA + " Legendary " + ChatColor.DARK_AQUA + "Pouch");
                }

            }
        }

        if (DoubleTokens != 0){
            if (getChance(16 + ((DoubleTokens-1)*4 ) )){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "te givetokens " + p.getName() + " 2");
            }else if (getChance(3 + ((DoubleTokens-1)*2 ) )  && DoubleTokens >= 13){
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "te givetokens " + p.getName() + " 3");
            }else{
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "te givetokens " + p.getName() + " 1");
            }
        }else{
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            Bukkit.dispatchCommand(console, "te givetokens " + p.getName() + " 1");
        }

        return false;
    }
}
