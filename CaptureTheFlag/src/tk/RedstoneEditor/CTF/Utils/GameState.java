package tk.RedstoneEditor.CTF.Utils;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import tk.RedstoneEditor.CTF.CaptureTheFlag;

public class GameState implements Listener {
	public static final String LOBBY = getPrefix() + ChatColor.GREEN + " LOBBY";
	public static final String INGAME = getPrefix() + ChatColor.RED + " InGame";
	public static final String POSTGAME = getPrefix() + ChatColor.AQUA + " PostGame";
	public static final String RESETTING = getPrefix() + ChatColor.DARK_RED + " Resetting";

	private String gameState;

	public void setGameState(String gameState) {
		this.gameState = gameState;
	}

	private static CaptureTheFlag plugin;

	public GameState(CaptureTheFlag instance) {
		plugin = instance;
	}

	private static String getPrefix() {
		return ChatColor.GOLD + "[" + ChatColor.GREEN
				+ plugin.getArena().getName() + ChatColor.GOLD + "]";
	}

	@EventHandler
	public void onServerListPing(ServerListPingEvent event) {
		event.setMotd(gameState);
	}
	
}
