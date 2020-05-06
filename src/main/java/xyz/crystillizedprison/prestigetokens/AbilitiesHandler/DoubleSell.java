package xyz.crystillizedprison.prestigetokens.AbilitiesHandler;

import me.clip.autosell.events.AutoSellEvent;
import me.clip.autosell.events.SellAllEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.Random;

public class DoubleSell implements Listener {

    public DoubleSell(PrestigeTokens main) {
        Main = main;
    }

    public static Boolean getChance(double chance) {
        Random rand = new Random();
        int random = rand.nextInt(100);

        return random <= chance;
    }

    PrestigeTokens Main;

    @EventHandler(ignoreCancelled = true)
    public void onAutoSell(SellAllEvent event) {
        Player p = event.getPlayer();
        int Level= Main.GetPlayerDoubleSell(p);

        if (Level != 0){
            if (getChance(5 + ((Level -1) * 2))){
                PrestigeTokens.getEcon().depositPlayer(p,event.getTotalCost());
                p.sendMessage(ChatColor.DARK_AQUA + "You recieved "+ ChatColor.AQUA + Main.getEcon().format(event.getTotalCost()) + ChatColor.AQUA+  " From Double Sell!");
            }
        }
    }
}
