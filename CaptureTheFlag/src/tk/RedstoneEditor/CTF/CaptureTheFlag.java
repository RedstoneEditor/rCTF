package tk.RedstoneEditor.CTF;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import tk.RedstoneEditor.CTF.Utils.GameState;

public class CaptureTheFlag extends JavaPlugin {
	public Location SpawnA = null;
	public Location SpawnB = null;
	public Location Spawn = null;
	private GameState gameState;
	public HashMap<String, Arena> arenas = new HashMap<String, Arena>();
	Logger log = Logger.getLogger("Minecraft");
	public boolean running;
	public boolean idle;
	public HashMap<String, String> waitingPlayers;

	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {
		gameState = new GameState(this);
		gameState.setGameState(GameState.LOBBY);
	}

	public Arena getArena() {
		return null;
	}
}
