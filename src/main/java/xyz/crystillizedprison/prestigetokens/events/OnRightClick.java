package xyz.crystillizedprison.prestigetokens.events;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

public class OnRightClick implements Listener {
    public OnRightClick(PrestigeTokens main) {
        Main = main;
    }

    PrestigeTokens Main;

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {


        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DOUBLE_PLANT)){
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.DARK_AQUA+"PTOKEN RESET")){
                Player p = event.getPlayer();
                int total = Main.GetPlayerDoubleSell(p) + Main.GetPlayerDoubleTokens(p) + Main.GetPlayerPouchFinder(p);
                Main.SetPlayerPouchFinder(p,0);
                Main.SetPlayerDoubleSell(p,0);
                Main.SetPlayerDoubleTokens(p,0);
                Main.SetPlayerTokens(p,Main.GetPlayerTokens(p)+total);
                p.sendMessage(ChatColor.DARK_AQUA+"Your Ptokens have Been reset");
                event.getPlayer().getInventory().getItemInMainHand().setType(Material.AIR);
            }
        }

    }
}
