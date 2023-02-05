package fun.mcbee.beechat.comands;

import fun.mcbee.beechat.BeeChat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class BeeChatCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        if (args[0].equalsIgnoreCase("clear")) {
            if (sender.hasPermission("beechat.clearchat")) {
                for (int i = 0; i < 100; i++) {
                    Bukkit.broadcastMessage(" ");
                }
                sender.sendMessage(ChatColor.of("#E8A025") + "Chat was cleared by " + sender.getName());
            }else {
                sender.sendMessage(ChatColor.of("#E83E3E") + "You don't have permission to use this command!");
            }return true;

        } else if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("beechat.reload")) {
                sender.sendMessage(ChatColor.of("#E8A025") + "Reloading...");
                BeeChat.getInstance().reloadConfig();
                sender.sendMessage(ChatColor.of("#25E83E") + "BeeChat was Reloaded!");
            }else {
                sender.sendMessage(ChatColor.of("#E83E3E") + "You don't have permission to use this command!");
            }return true;
        }
            else if (args[0].equalsIgnoreCase("help")) {
            if (sender.hasPermission("beechat.help")) {
                sender.sendMessage(ChatColor.of("#25E83E") + "Welcome to BeeChat Help!");
                sender.sendMessage(ChatColor.of("#E8A025") + "Commands:");
                sender.sendMessage(ChatColor.of("#E8A025") + "/bc clear - Clears the chat");
                sender.sendMessage(ChatColor.of("#E8A025") + "/bc reload - Reloads the plugin");
                sender.sendMessage(ChatColor.of("#E8A025") + "/bc help - Shows this message");
                sender.sendMessage(ChatColor.of("#25E83E") + "Thanks for using BeeChat!");
            } else {
                sender.sendMessage(ChatColor.of("#E83E3E") + "You don't have permission to use this command!");
            }
            return true;
        }
        return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("clear");
            completions.add("reload");
            completions.add("help");
        }

        return completions;
    }
}
