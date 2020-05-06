package xyz.crystillizedprison.prestigetokens.Guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class shopgui {
    /*
    TODO
    1. Dragon Bomb
    2. Mythical Crates
    3.
     */

    public static void Open(Player p ){
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + "PToken Shop");

        ItemStack[] Slots = new ItemStack[27];


        ItemStack Blue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta Blue_Meta = Blue.getItemMeta();
        Blue_Meta.setDisplayName("");
        Blue.setItemMeta(Blue_Meta);

        ItemStack LBlue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
        ItemMeta LBlue_Meta = Blue.getItemMeta();
        LBlue_Meta.setDisplayName("");
        Blue.setItemMeta(LBlue_Meta);

        ItemStack ComingSoon = new ItemStack(Material.BEDROCK,1);
        ItemMeta ComingSoon_meta = ComingSoon.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_RED + "COMING SOON");

        ComingSoon_meta.setLore(lore);
        ComingSoon_meta.setDisplayName(ChatColor.AQUA + "ComingSoon");
        ComingSoon.setItemMeta(ComingSoon_meta);

        ItemStack MythicalCrate = new ItemStack(Material.ENDER_CHEST,1);
        ItemMeta MythicalCrate_meta = MythicalCrate.getItemMeta();
        lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_AQUA + "Click To Me Buy a Mythical Crate!");
        lore.add(ChatColor.DARK_AQUA + "COST:"+ChatColor.AQUA + "4");

        MythicalCrate_meta.setLore(lore);
        MythicalCrate_meta.setDisplayName(ChatColor.AQUA + "Mythical Crate");
        MythicalCrate.setItemMeta(MythicalCrate_meta);

        ItemStack DragonBomb = new ItemStack(Material.DRAGONS_BREATH,1);
        ItemMeta DragonBomb_meta = DragonBomb.getItemMeta();
        lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_AQUA + "Click To Me Buy a Dragon Bomb!");
        lore.add(ChatColor.DARK_AQUA + "COST:"+ChatColor.AQUA + "2");

        DragonBomb_meta.setLore(lore);
        DragonBomb_meta.setDisplayName(ChatColor.AQUA + "Dragon Bomb");
        DragonBomb.setItemMeta(DragonBomb_meta);


        Slots[0] = Blue;
        Slots[1] = Blue;
        Slots[2] = LBlue;
        Slots[3] = Blue;
        Slots[4] = LBlue;
        Slots[5] = Blue;
        Slots[6] = LBlue;
        Slots[7] = Blue;
        Slots[8] = Blue;

        Slots[9] = Blue;
        Slots[10] = MythicalCrate;
        Slots[11] = DragonBomb;
        Slots[12] = ComingSoon;
        Slots[13] = ComingSoon;
        Slots[14] = ComingSoon;
        Slots[15] = ComingSoon;
        Slots[16] = ComingSoon;
        Slots[17] = Blue;

        Slots[18] = Blue;
        Slots[19] = Blue;
        Slots[20] = LBlue;
        Slots[21] = Blue;
        Slots[22] = LBlue;
        Slots[23] = Blue;
        Slots[24] = LBlue;
        Slots[25] = Blue;
        Slots[26] = Blue;

        inv.setContents(Slots);

        p.openInventory(inv);
    }

}
