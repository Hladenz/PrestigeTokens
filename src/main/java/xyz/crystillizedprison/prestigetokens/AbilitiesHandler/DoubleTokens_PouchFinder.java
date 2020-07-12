package xyz.crystillizedprison.prestigetokens.AbilitiesHandler;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import xyz.crystallizedprison.petssystem.Pet;
import xyz.crystallizedprison.petssystem.PetsSystem;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.Random;

public class DoubleTokens_PouchFinder implements CommandExecutor {

    public DoubleTokens_PouchFinder(PrestigeTokens main) {
        Main = main;
        pets = main.getPets();
    }

    PrestigeTokens Main;
    PetsSystem pets;

    public static Boolean getChance(double chance) {
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
        if (PouchFinder != 0){
            if (getChance(0.5 + ((PouchFinder-1)*0.1 ) )){
            //COMMON
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "amc pouch give " + p.getName() + " Common");
                if (!Main.getPftoggle().contains(p)) {
                    p.sendMessage(ChatColor.DARK_AQUA + "Pouch Finder Got you A " + ChatColor.AQUA + " Common " + ChatColor.DARK_AQUA + "Pouch");
                }
            }else if (getChance(0.05 + ((PouchFinder-35)*0.01 ) )  && PouchFinder >= 35){
            //RARE
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "amc pouch give " + p.getName() + " Rare");
                if (!Main.getPftoggle().contains(p)) {
                    p.sendMessage(ChatColor.DARK_AQUA + "Pouch Finder Got you A " + ChatColor.AQUA + " Rare " + ChatColor.DARK_AQUA + "Pouch");
                }
            }else if (getChance((PouchFinder-75)*0.0001 ) && PouchFinder >= 75){
            //LEGENDARY
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                Bukkit.dispatchCommand(console, "amc pouch give " + p.getName() + " Legendary");
                if (!Main.getPftoggle().contains(p)) {
                    p.sendMessage(ChatColor.DARK_AQUA + "Pouch Finder Got you A " + ChatColor.AQUA + " Legendary " + ChatColor.DARK_AQUA + "Pouch");
                }

            }
        }

        if (pets.GetPlayerInfo(p).getPet() != null){
            if (pets.GetPlayerInfo(p).getPet().equals(Pet.MOLE)){
                Main.getEcon().depositPlayer(p,100000);
            }
        }

        if (DoubleTokens != 0){
            if (getChance(0.5 + ((DoubleTokens-1)*0.45 ) )){
                if (pets.GetPlayerInfo(p).getPet() != null){
                    if (pets.GetPlayerInfo(p).getPet().equals(Pet.LUCKYJACK)){
                        Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(2,p) * 2);
                        return true;
                    }
                }
                Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(2,p));
            }else if (getChance(0.005 + ((DoubleTokens-75)*0.5 ) )  && DoubleTokens >= 75){
                if (pets.GetPlayerInfo(p).getPet() != null){
                    if (pets.GetPlayerInfo(p).getPet().equals(Pet.LUCKYJACK)){
                        Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(3,p) * 2);
                        return true;
                    }
                }
                Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(3,p));
            }else{
                if (pets.GetPlayerInfo(p).getPet() != null){
                    if (pets.GetPlayerInfo(p).getPet().equals(Pet.LUCKYJACK)){
                        Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(1,p) * 2);
                        return true;
                    }
                }
                Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(1,p));
            }
        }else{
            if (pets.GetPlayerInfo(p).getPet() != null){
                if (pets.GetPlayerInfo(p).getPet().equals(Pet.LUCKYJACK)){
                    Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(1,p) * 2);
                    return true;
                }
            }
            Main.getTe().setTokens(p,Main.getTe().getTokens(p)+Main.getTokenBooster().GetBooster(1,p));

        }

        return false;
    }
}
