package fun.mcbee.beechat.listeners;

import fun.mcbee.beechat.BeeChat;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveMessages implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
    String joinmsg  = ChatColorUtil.toHex(ChatColorUtil.color(PlaceholderAPI.setPlaceholders(e.getPlayer(), BeeChat.getInstance().getConfig().getString("joinmsg", "{display_name} &#7D878Chas joined the server.").replace("{name}", e.getPlayer().getName()).replace("{display_name}" ,e.getPlayer().getDisplayName())))).replace("{message}", e.getJoinMessage().replace("%", "‰"));
    e.setJoinMessage(joinmsg);
    };

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent e) {
        String quitmsg  = ChatColorUtil.toHex(ChatColorUtil.color(PlaceholderAPI.setPlaceholders(e.getPlayer(), BeeChat.getInstance().getConfig().getString("quitmsg", "{display_name} &#7D878Cleft the server.").replace("{name}", e.getPlayer().getName()).replace("{display_name}" ,e.getPlayer().getDisplayName())))).replace("{message}", e.getQuitMessage().replace("%", "‰"));
        e.setQuitMessage(quitmsg);
    };
}
