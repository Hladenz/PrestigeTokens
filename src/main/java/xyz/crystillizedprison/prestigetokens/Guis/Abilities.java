package xyz.crystillizedprison.prestigetokens.Guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.crystillizedprison.prestigetokens.PrestigeTokens;

import java.util.ArrayList;

public class Abilities {

    public Abilities(PrestigeTokens main) {
        this.main = main;
    }

    PrestigeTokens main;

    public void Open(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + "Abilities");

        ItemStack[] Slots = new ItemStack[27];


        ItemStack Blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1, (short) 11);
        ItemMeta Blue_Meta = Blue.getItemMeta();
        Blue_Meta.setDisplayName("");
        Blue.setItemMeta(Blue_Meta);

        ItemStack LBlue = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, (short) 3);
        ItemMeta LBlue_Meta = Blue.getItemMeta();
        LBlue_Meta.setDisplayName("");
        Blue.setItemMeta(LBlue_Meta);

        ItemStack Double_Token = new ItemStack(Material.END_CRYSTAL,1);
        ItemMeta Double_Token_Meta = Double_Token.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_AQUA + "Give You a Chance to Double Your Tokens");
        if (main.GetPlayerDoubleTokens(p) !=0){
            lore.add(ChatColor.DARK_AQUA + "Level:" + main.GetPlayerDoubleTokens(p));
        }
        Double_Token_Meta.setLore(lore);
        Double_Token_Meta.setDisplayName(ChatColor.AQUA + "Double Tokens");
        Double_Token.setItemMeta(Double_Token_Meta);


        ItemStack Double_Sell = new ItemStack(Material.END_CRYSTAL,1);
        ItemMeta Double_Sell_Meta = Double_Sell.getItemMeta();
        lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_AQUA + "Give You a Chance to Double Your Sell");
        if (main.GetPlayerDoubleSell(p) !=0){
            lore.add(ChatColor.DARK_AQUA + "Level:" + main.GetPlayerDoubleSell(p));
        }
        Double_Sell_Meta.setLore(lore);
        Double_Sell_Meta.setDisplayName(ChatColor.AQUA + "Double Sell");
        Double_Sell.setItemMeta(Double_Sell_Meta);

        ItemStack Pouch_Finder = new ItemStack(Material.END_CRYSTAL,1);
        ItemMeta Pouch_Findder_Meta = Double_Sell.getItemMeta();
        lore = new ArrayList<String>();
        lore.add(ChatColor.DARK_AQUA + "Give You a Chance to Find Pouch's while Mining");
        if (main.GetPlayerPouchFinder(p) !=0){
            lore.add(ChatColor.DARK_AQUA + "Level:" + main.GetPlayerPouchFinder(p));
        }
        Pouch_Findder_Meta.setLore(lore);
        Pouch_Findder_Meta.setDisplayName(ChatColor.AQUA + "Pouch Finder");
        Pouch_Finder.setItemMeta(Pouch_Findder_Meta);
        
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
        Slots[11] = Pouch_Finder;
        Slots[12] = LBlue;
        Slots[13] = Double_Sell;
        Slots[14] = LBlue;
        Slots[15] = Double_Token;
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
