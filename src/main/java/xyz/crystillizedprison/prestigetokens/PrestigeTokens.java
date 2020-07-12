package xyz.crystillizedprison.prestigetokens;

import com.vk2gpz.tokenenchant.TokenEnchant;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.crystallizedprison.petssystem.PetsSystem;
import xyz.crystillizedprison.prestigetokens.AbilitiesHandler.DoubleSell;
import xyz.crystillizedprison.prestigetokens.AbilitiesHandler.DoubleSell_Autosell;
import xyz.crystillizedprison.prestigetokens.AbilitiesHandler.DoubleTokens_PouchFinder;
import xyz.crystillizedprison.prestigetokens.Commands.batchopen;
import xyz.crystillizedprison.prestigetokens.Commands.pftoggle;
import xyz.crystillizedprison.prestigetokens.Commands.ptokens;
import xyz.crystillizedprison.prestigetokens.Commands.tokenbooster;
import xyz.crystillizedprison.prestigetokens.ConfigFiles.TokenConfig;
import xyz.crystillizedprison.prestigetokens.events.InventoryManger;
import xyz.crystillizedprison.prestigetokens.events.OnRightClick;

import java.util.ArrayList;
import java.util.List;

public final class PrestigeTokens extends JavaPlugin {

    private TokenConfig tokenconfig = new TokenConfig();

    private TokenEnchant te;

    public TokenEnchant getTe() {
        return te;
    }

    private TokenBooster tokenBooster = new TokenBooster(this);

    private static Economy econ = null;

    public static Economy getEcon() {
        return econ;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    List<Player> pftoggle = new ArrayList<>();

    public List<Player> getPftoggle() {
        return pftoggle;
    }

    public TokenEnchant getTokenEnchant() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TokenEnchant");
        if ((plugin == null)) {
            return null;
        }
        return (com.vk2gpz.tokenenchant.TokenEnchant)plugin;
    }

    public PetsSystem getPets() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PetsSystem");
        if ((plugin == null)) {
            return null;
        }
        return (xyz.crystallizedprison.petssystem.PetsSystem)plugin;
    }

    public TokenBooster getTokenBooster() {
        return tokenBooster;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        if (!setupEconomy() ) {
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


        TokenConfig.setup();
        TokenConfig.get().addDefault("Tokens",null);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new InventoryManger(this),this);
        getServer().getPluginManager().registerEvents(new DoubleSell(this),this);
        getServer().getPluginManager().registerEvents(new OnRightClick(this),this);
        getServer().getPluginManager().registerEvents(new DoubleSell_Autosell(this),this);

        getCommand("ptokens").setExecutor(new ptokens(this));
        getCommand("Blockreward").setExecutor(new DoubleTokens_PouchFinder(this));
        getCommand("batchopen").setExecutor(new batchopen(this));
        getCommand("pftoggle").setExecutor(new pftoggle(this));
        getCommand("tokenbooster").setExecutor(new tokenbooster(this));

        tokenBooster.Setup();

        te = getTokenEnchant();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public int GetPlayerTokens(Player p){
        if (TokenConfig.get().contains("Tokens."+p.getUniqueId())){
            return TokenConfig.get().getInt("Tokens."+p.getUniqueId() +".Tokens");
        }
        return 0;
    }

    public void SetPlayerTokens(Player p, int amount){
        TokenConfig.get().set("Tokens."+p.getUniqueId()+ ".Tokens",amount);
        TokenConfig.save();
    }

    public int GetPlayerDoubleSell(Player p){
        if (TokenConfig.get().contains("Tokens."+p.getUniqueId())){
            return TokenConfig.get().getInt("Tokens."+p.getUniqueId() +".DoubleSell");
        }
        return 0;
    }

    public void SetPlayerDoubleSell(Player p, int amount){
        TokenConfig.get().set("Tokens."+p.getUniqueId()+ ".DoubleSell",amount);
        TokenConfig.save();
    }

    public int GetPlayerDoubleTokens(Player p){
        if (TokenConfig.get().contains("Tokens."+p.getUniqueId())){
            return TokenConfig.get().getInt("Tokens."+p.getUniqueId() +".DoubleTokens");
        }
        return 0;
    }

    public void SetPlayerDoubleTokens(Player p, int amount){
        TokenConfig.get().set("Tokens."+p.getUniqueId()+ ".DoubleTokens",amount);
        TokenConfig.save();
    }

    public int GetPlayerPouchFinder(Player p){
        if (TokenConfig.get().contains("Tokens."+p.getUniqueId())){
            return TokenConfig.get().getInt("Tokens."+p.getUniqueId() +".PouchFinder");
        }
        return 0;
    }

    public void SetPlayerPouchFinder(Player p, int amount){
        TokenConfig.get().set("Tokens."+p.getUniqueId()+ ".PouchFinder",amount);
        TokenConfig.save();
    }
    
}
