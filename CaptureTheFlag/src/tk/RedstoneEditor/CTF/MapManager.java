package tk.RedstoneEditor.CTF;

import java.io.File;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.metadata.FixedMetadataValue;

public class MapManager {
	private CaptureTheFlag plugin;
	public MapManager(CaptureTheFlag instance){
		plugin = instance;
	}

	public World loadMap(String MapName) {
		unloadMap(MapName);
		String worldName = MapName;
		File mapfile = new File("plugins/../" + worldName);
		if (!mapfile.exists()) {
			this.plugin.log.info(mapfile.getAbsolutePath());
			this.plugin.log.warning("MAP " + MapName + " not found!");
			return null;
		}
		WorldCreator wc = new WorldCreator(worldName);

		World w = this.plugin.getServer().createWorld(wc);
		if (w == null) {
			this.plugin.log.warning("Can't load the world");
			return null;
		}
		w.setAutoSave(false);
		w.setMetadata(this.plugin.getName(), new FixedMetadataValue(
				this.plugin, Boolean.valueOf(true)));
		w.setKeepSpawnInMemory(false);
		w.setPVP(true);
		w.setSpawnFlags(false, true);

		return w;
	}

	public void unloadMap(String MapName) {
		for (World w : this.plugin.getServer().getWorlds())
			if (w.getName() == MapName) {
				this.plugin.getServer().unloadWorld(w, false);
			}
	}
}
