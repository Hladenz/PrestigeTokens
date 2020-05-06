package xyz.crystillizedprison.prestigetokens.Guis;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.ArrayList;

public class MainMenu {

    public MainMenu(PrestigeTokens main) {
        Main = main;
    }

    PrestigeTokens Main;


    public ItemStack getHead(Player player) {
        int lifePlayer = (int) player.getHealth();
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setDisplayName(ChatColor.AQUA + player.getName());
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.AQUA + "Tokens: " + ChatColor.DARK_AQUA + Main.GetPlayerTokens(player));
        skull.setLore(lore);
        skull.setOwner(player.getName());
        item.setItemMeta(skull);
        return item;
    }

    public void Open(Player p){
        Inventory inv = Bukkit.createInventory(null, 27,ChatColor.DARK_AQUA + "Prestige Tokens");

        ItemStack[] Slots = new ItemStack[27];


        ItemStack Blue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta Blue_Meta = Blue.getItemMeta();
        Blue_Meta.setDisplayName("");
        Blue.setItemMeta(Blue_Meta);

        ItemStack LBlue = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
        ItemMeta LBlue_Meta = Blue.getItemMeta();
        LBlue_Meta.setDisplayName("");
        Blue.setItemMeta(LBlue_Meta);

        ItemStack ItemShop = new ItemStack(Material.ENDER_CHEST,1);
        ItemMeta ItemShop_Meta =  ItemShop.getItemMeta();
        ItemShop_Meta.setDisplayName(ChatColor.AQUA + "Item Shop");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_AQUA  + "Buy Items with Ptokens");
        ItemShop_Meta.setLore(lore);
        ItemShop.setItemMeta(ItemShop_Meta);

        ItemStack Abilities = new ItemStack(Material.END_CRYSTAL,1);
        ItemMeta Abilities_Meta = Abilities.getItemMeta();
        Abilities_Meta.setDisplayName(ChatColor.AQUA + "Abilities");
        Abilities.setItemMeta(Abilities_Meta);

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
        Slots[10] = LBlue;
        Slots[11] = ItemShop;
        Slots[12] = LBlue;
        Slots[13] = getHead(p);
        Slots[14] = LBlue;
        Slots[15] = Abilities;
        Slots[16] = LBlue;
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
