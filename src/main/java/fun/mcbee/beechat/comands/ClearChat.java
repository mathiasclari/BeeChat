package fun.mcbee.beechat.comands;

import fun.mcbee.beechat.BeeChat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.concurrent.ThreadLocalRandom;

public class ClearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("beechat.clearchat")) {
            for (int i = 0; i < 100; i++) {
                Bukkit.broadcastMessage(" ");

            }
            sender.sendMessage(ChatColor.of("#E8A025") +"Chat was cleared by " + sender.getName());
        }
        return true;
    }
}
