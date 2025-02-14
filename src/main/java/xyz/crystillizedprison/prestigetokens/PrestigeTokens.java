package xyz.crystillizedprison.prestigetokens;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.crystillizedprison.prestigetokens.AbilitiesHandler.DoubleSell;
import xyz.crystillizedprison.prestigetokens.AbilitiesHandler.DoubleTokens_PouchFinder;
import xyz.crystillizedprison.prestigetokens.Commands.batchopen;
import xyz.crystillizedprison.prestigetokens.Commands.pftoggle;
import xyz.crystillizedprison.prestigetokens.Commands.ptokens;
import xyz.crystillizedprison.prestigetokens.ConfigFiles.TokenConfig;
import xyz.crystillizedprison.prestigetokens.events.InventoryManger;
import xyz.crystillizedprison.prestigetokens.events.OnRightClick;

import java.util.ArrayList;
import java.util.List;

public final class PrestigeTokens extends JavaPlugin {

    private TokenConfig tokenconfig = new TokenConfig();

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

        getCommand("ptokens").setExecutor(new ptokens(this));
        getCommand("Blockreward").setExecutor(new DoubleTokens_PouchFinder(this));
        getCommand("batchopen").setExecutor(new batchopen(this));
        getCommand("pftoggle").setExecutor(new pftoggle(this));


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
