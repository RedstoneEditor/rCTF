package tk.RedstoneEditor.CTF;

import org.bukkit.Location;
import org.bukkit.World;

public class Arena {
	@SuppressWarnings("unused")
	private CaptureTheFlag plugin;
	private String name;
	private World world;
	private Location spawnA;
	private Location flagA;
	private Location SpawnB;
	private Location flagB;

	public Location getSpawnA() {
		return spawnA;
	}

	public void setSpawnA(Location spawnA) {
		this.spawnA = spawnA;
	}

	public Location getFlagA() {
		return flagA;
	}

	public void setFlagA(Location flagA) {
		this.flagA = flagA;
	}

	public Location getSpawnB() {
		return SpawnB;
	}

	public void setSpawnB(Location spawnB) {
		SpawnB = spawnB;
	}

	public Location getFlagB() {
		return flagB;
	}

	public void setFlagB(Location flagB) {
		this.flagB = flagB;
	}

	public Arena(CaptureTheFlag instance, World w, String n) {
		plugin = instance;
		world = w;
		name = n;
	}

	public String getName() {
		return name;
	}

	public World getWorld() {
		return world;
	}
}
