package xyz.crystillizedprison.prestigetokens.Commands;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.Random;

public class batchopen implements CommandExecutor {

    public batchopen(PrestigeTokens main) {
        this.main = main;
    }

    PrestigeTokens main;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if (p.getItemInHand() != null) {
                ItemStack item = p.getItemInHand();
                if (item.getItemMeta().getDisplayName().contains("COMMON Pouch")) {
                    Random rand = new Random();
                    double value = 0 + (1000000 * item.getAmount() - 0) * rand.nextDouble();
                    main.getEcon().depositPlayer(p, value);
                    p.getInventory().removeItem(item);
                    p.sendMessage(ChatColor.DARK_AQUA + "You Batch opened "+ ChatColor.AQUA + "x" + item.getAmount()+ ChatColor.DARK_AQUA+" Pouches and got " + ChatColor.AQUA + main.getEcon().format(value));
                }
            }
        }
        return false;
    }
}
