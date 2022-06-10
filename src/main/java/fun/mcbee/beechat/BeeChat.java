package fun.mcbee.beechat;

import fun.mcbee.beechat.comands.ClearChat;
import fun.mcbee.beechat.comands.ReloadCommand;
import fun.mcbee.beechat.listeners.ChatSystem;
import fun.mcbee.beechat.listeners.JoinLeaveMessages;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class BeeChat extends JavaPlugin {

    public static BeeChat instance;
    private final YamlConfiguration conf = new YamlConfiguration();
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]=================[" + ChatColor.of("#E8A025") + ChatColor.BOLD + "BeeChat" + ChatColor.GRAY + "]=================[]");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of("#406266") + "       Made by:" + ChatColor.of("#E8A025") + " PxLib");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of("#406266") + "       My GitHub:" + ChatColor.of("#E8A025") + "https://github.com/PxLib");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]===========================================[]");


        File co = new File(getDataFolder(), "config.yml");
        if(!co.exists()) saveResource("config.yml", false);

        Bukkit.getPluginManager().registerEvents(new ChatSystem(), this);
        Bukkit.getPluginManager().registerEvents(new JoinLeaveMessages(), this);
        getCommand("breload").setExecutor(new ReloadCommand());
        getCommand("cchat").setExecutor(new ClearChat());


        try{
            this.conf.load(co);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        
    }

    public static BeeChat getInstance() {
        return instance;
    }
}
