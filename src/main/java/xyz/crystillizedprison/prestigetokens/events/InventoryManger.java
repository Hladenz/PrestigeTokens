package xyz.crystillizedprison.prestigetokens.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.crystillizedprison.prestigetokens.Guis.Abilities;
import xyz.crystillizedprison.prestigetokens.Guis.MainMenu;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

public class InventoryManger implements Listener {

    PrestigeTokens Main;

    public InventoryManger(PrestigeTokens main) {
        Main = main;
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {

        Player p = (Player) event.getWhoClicked();

        if (event.getInventory().getTitle().equals(ChatColor.DARK_AQUA + "Prestige Tokens")){
            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Abilities")){
                new Abilities(Main).Open(p);
            }
        }else if(event.getInventory().getTitle().equals(ChatColor.DARK_AQUA + "Abilities")){
            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Double Sell")){
                if (Main.GetPlayerTokens(p) == 0){
                    p.sendMessage(ChatColor.RED + "You need 1 prestige Token to purchase This!");
                    return;
                }
                Main.SetPlayerDoubleSell(p,Main.GetPlayerDoubleSell(p)+1);
                Main.SetPlayerTokens(p,Main.GetPlayerTokens(p)-1);
                p.sendMessage(ChatColor.AQUA + "You Successfully Purchased One level of Double Sell");
            }else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Double Tokens")){
                if (Main.GetPlayerTokens(p) == 0){
                    p.sendMessage(ChatColor.RED + "You need 1 prestige Token to purchase This!");
                    return;
                }
                Main.SetPlayerDoubleTokens(p,Main.GetPlayerDoubleTokens(p)+1);
                Main.SetPlayerTokens(p,Main.GetPlayerTokens(p)-1);
                p.sendMessage(ChatColor.AQUA + "You Successfully Purchased One level of Double Tokens");
            }else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Pouch Finder")){
                if (Main.GetPlayerTokens(p) == 0){
                    p.sendMessage(ChatColor.RED + "You need 1 prestige Token to purchase This!");
                    return;
                }
                Main.SetPlayerPouchFinder(p,Main.GetPlayerPouchFinder(p)+1);
                Main.SetPlayerTokens(p,Main.GetPlayerTokens(p)-1);
                p.sendMessage(ChatColor.AQUA + "You Successfully Purchased One level of Pouch Finder");
            }
        }

    }
}
