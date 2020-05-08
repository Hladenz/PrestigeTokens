package xyz.crystillizedprison.prestigetokens;

import junit.extensions.TestSetup;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import xyz.crystillizedprison.prestigetokens.ConfigFiles.Booster;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class TokenBooster {

    public TokenBooster(PrestigeTokens main) {
        this.main = main;
    }

    PrestigeTokens main;

    private Booster config = new Booster();



    public void Setup(){
        config.setup();
        config.get().addDefault("booster",null);

        loop();

    }

    private void loop(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            public void run() {
                for (String uuid:config.get().getConfigurationSection("Booster").getKeys(false)){
                    if (config.get().getInt("Booster."+uuid+".required") > Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getPlayer().getStatistic(Statistic.PLAY_ONE_TICK)  ){
                        config.get().set("Booster."+uuid,null);
                    }
                }
            }
        }, 20, 5);
    }

    public void GiveBooster(Player p,int amount,int time){
        if (config.get().contains("Booster."+p.getUniqueId().toString())){
            if (config.get().getInt("Booster."+p.getUniqueId().toString()+".amount") != amount){
                int required = p.getStatistic(Statistic.PLAY_ONE_TICK) + (time*20);
                ConfigurationSection multi = config.get().createSection("Booster."+p.getUniqueId().toString());
                multi.set("amount",amount);
                multi.set("required",required);
                config.save();
            }else{
                config.get().set("Booster."+p.getUniqueId().toString()+".required",config.get().getInt("Booster."+p.getUniqueId().toString()+".required")+(time*20));
                config.save();
            }
        }else{
            int required = p.getStatistic(Statistic.PLAY_ONE_TICK) + (time*20);
            ConfigurationSection multi = config.get().createSection("Booster."+p.getUniqueId().toString());
            multi.set("amount",amount);
            multi.set("required",required);
            config.save();
        }

    }

    public int GetBooster(int amount, Player p){
        if (config.get().contains(p.getUniqueId().toString())){
            return amount*config.get().getInt("Booster."+p.getUniqueId().toString()+".amount");
        }else{
            return amount;
        }
    }
}
