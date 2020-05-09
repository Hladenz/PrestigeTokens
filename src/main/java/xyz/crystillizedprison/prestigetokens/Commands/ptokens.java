package xyz.crystillizedprison.prestigetokens.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.crystillizedprison.prestigetokens.Guis.MainMenu;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.ArrayList;
import java.util.List;

public class ptokens implements CommandExecutor {

    PrestigeTokens Main;

    public ptokens(PrestigeTokens main) {
        Main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player p = (Player) sender;

            if (args.length != 0) {

                if (args[0].equals("give") && p.hasPermission("ptokens.give")) {
                    if (args.length < 3) {
                        p.sendMessage(ChatColor.RED + "Invalid Format");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        p.sendMessage(ChatColor.RED + "Invalid Player");
                        return true;
                    }

                    Main.SetPlayerTokens(Bukkit.getPlayer(args[1]), Main.GetPlayerTokens(Bukkit.getPlayer(args[1])) + Integer.valueOf(args[2]) );

                    Bukkit.getPlayer(args[1]).sendMessage(ChatColor.DARK_AQUA + "You have received " + ChatColor.AQUA + args[2] + ChatColor.DARK_AQUA +" Prestige Tokens!" );

                }
                else if (args[0].equals("set") && p.hasPermission("ptokens.set")){

                    if (args.length < 3) {
                        p.sendMessage(ChatColor.RED + "Invalid Format");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        p.sendMessage(ChatColor.RED + "Invalid Player");
                        return true;
                    }

                    Main.SetPlayerTokens(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]) );

                }
                else if (args[0].equals("info") && p.hasPermission("ptokens.info")){

                    if (args.length < 2) {
                        p.sendMessage(ChatColor.RED + "Invalid Format");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        p.sendMessage(ChatColor.RED + "Invalid Player");
                        return true;
                    }

                   p.sendMessage(ChatColor.AQUA + "Pouch Finder:" + Main.GetPlayerPouchFinder(Bukkit.getPlayer(args[1])));
                   p.sendMessage(ChatColor.AQUA + "Double Sell:" + Main.GetPlayerDoubleSell(Bukkit.getPlayer(args[1])));
                   p.sendMessage(ChatColor.AQUA + "Double Tokens:" + Main.GetPlayerDoubleTokens(Bukkit.getPlayer(args[1])));

                }
                else if (args[0].equals("aset") && p.hasPermission("ptokens.aset")){

                    if (args.length < 4) {
                        p.sendMessage(ChatColor.RED + "Invalid Format");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        p.sendMessage(ChatColor.RED + "Invalid Player");
                        return true;
                    }

                    if (!args[2].equals("DoubleTokens") && !args[2].equals("DoubleSell") && !args[2].equals("PouchFinder")){
                        p.sendMessage("Invalid ability");
                        return true;
                    }

                    if (args[2].equals("DoubleTokens")){
                        Main.SetPlayerDoubleTokens(Bukkit.getPlayer(args[1]),Integer.valueOf(args[3]));
                    }
                    if (args[2].equals("DoubleSell")){
                        Main.SetPlayerDoubleSell(Bukkit.getPlayer(args[1]),Integer.valueOf(args[3]));
                    }
                    if (args[2].equals("PouchFinder")){
                        Main.SetPlayerPouchFinder(Bukkit.getPlayer(args[1]),Integer.valueOf(args[3]));
                    }


                }
                else if (args[0].equals("ptreset") && p.hasPermission("ptokens.ptreset")){
                    if (args.length  != 2){
                        p.sendMessage(ChatColor.RED + "Invalid Format");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        p.sendMessage(ChatColor.RED + "Invalid Player");
                        return true;
                    }

                    ItemStack item = new ItemStack(Material.SUNFLOWER);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.DARK_AQUA+"PTOKEN RESET");
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.AQUA + "Right Click to reset ptokens");
                    item.setItemMeta(meta);
                    Bukkit.getPlayer(args[1]).getInventory().addItem(item);
                    Bukkit.getPlayer(args[1]).sendMessage(ChatColor.DARK_AQUA+"You Have been Give a ptoken reset Token!");
                    return true;

                }
            }

            if (args.length == 0) {
                new MainMenu(Main).Open(p);
            }
            return true;
        }
        if (args.length != 0) {

            if (args[0].equals("give")) {
                if (args.length < 3) {
                    System.out.println(ChatColor.RED + "Invalid Format");
                    return true;
                }

                if (Bukkit.getPlayer(args[1]) == null){
                    System.out.println(ChatColor.RED + "Invalid Player");
                    return true;
                }

                Main.SetPlayerTokens(Bukkit.getPlayer(args[1]), Main.GetPlayerTokens(Bukkit.getPlayer(args[1])) + Integer.valueOf(args[2]) );

                Bukkit.getPlayer(args[1]).sendMessage(ChatColor.DARK_AQUA + "You have received " + ChatColor.AQUA + args[2] + ChatColor.DARK_AQUA +" Prestige Tokens!" );

            }else if (args[0].equals("set")){

                if (args.length < 3) {
                    System.out.println(ChatColor.RED + "Invalid Format");
                    return true;
                }

                if (Bukkit.getPlayer(args[1]) == null){
                    System.out.println(ChatColor.RED + "Invalid Player");
                    return true;
                }

                Main.SetPlayerTokens(Bukkit.getPlayer(args[1]), Integer.valueOf(args[2]) );


            }
        }

        return true;
    }






}
