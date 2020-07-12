package xyz.crystillizedprison.prestigetokens.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

public class tokenbooster implements CommandExecutor {

    public tokenbooster(PrestigeTokens main) {
        this.main = main;
    }

    PrestigeTokens main;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if (args.length == 0) {

            }else{
                if (args[0].toLowerCase().equals("give")){
                    if (!p.hasPermission("ptoken.booster.give")){
                        p.sendMessage(ChatColor.DARK_AQUA+"You Dont have perms!");
                        return true;
                    }
                    if (args.length < 4){
                        p.sendMessage(ChatColor.DARK_AQUA+"Invalid Format! /tokenbooster give <player> <amount> <time>");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        p.sendMessage(ChatColor.DARK_AQUA+"Invalid Player!");
                        return true;
                    }
                    main.getTokenBooster().GiveBooster(Bukkit.getPlayer(args[1]),Integer.valueOf(args[2]),Integer.valueOf(args[3]));
                    p.sendMessage(ChatColor.DARK_AQUA+ "Multi Has been Given");
                    Bukkit.getPlayer(args[1]).sendMessage(ChatColor.AQUA+"You Have been given a " + args[2]+ "x Token Booster for " + Math.floor((Integer.valueOf(args[3]))/60) + "mins");

                }
            }
        }else{
            if (args.length == 0) {

            }else{
                if (args[0].toLowerCase().equals("give")){

                    if (args.length < 4){
                        System.out.println(ChatColor.DARK_AQUA+"Invalid Format! /tokenbooster give <player> <amount> <time>");
                        return true;
                    }

                    if (Bukkit.getPlayer(args[1]) == null){
                        System.out.println(ChatColor.DARK_AQUA+"Invalid Player!");
                        return true;
                    }
                    main.getTokenBooster().GiveBooster(Bukkit.getPlayer(args[1]),Integer.valueOf(args[2]),Integer.valueOf(args[3]));
                    System.out.println(ChatColor.DARK_AQUA+ "Multi Has been Given");
                    Bukkit.getPlayer(args[1]).sendMessage(ChatColor.AQUA+"You Have been given a " + args[2]+ "x Token Booster for " + Math.floor((Integer.valueOf(args[3]))/60) + "mins");

                }
            }
        }
        return false;
    }
}
