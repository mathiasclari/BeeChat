package fun.mcbee.beechat.comands;

import fun.mcbee.beechat.BeeChat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("beechat.reload")) {
            sender.sendMessage(ChatColor.of("#E8A025") + "Reloading...");
            BeeChat.getInstance().reloadConfig();
            sender.sendMessage(ChatColor.of("#25E83E") +"BeeChat was Reloaded!");
        }
    return true;
    }
}