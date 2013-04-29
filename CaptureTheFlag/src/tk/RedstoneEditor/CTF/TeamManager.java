package tk.RedstoneEditor.CTF;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class TeamManager {
	public HashMap<String, String> TeamA = new HashMap<String, String>();
	public HashMap<String, String> TeamB = new HashMap<String, String>();

	public HashMap<String, String> offlineP = new HashMap<String, String>();
	private CaptureTheFlag plugin;

	public TeamManager(CaptureTheFlag instance) {
		this.plugin = instance;
	}

	public String getTeam(Player p) {
		if (this.TeamA.containsKey(p.getName()))
			return "A";
		if (this.TeamB.containsKey(p.getName()))
			return "B";
		return "";
	}

	public String getTeam(String p) {
		if (this.TeamA.containsKey(p))
			return "A";
		if (this.TeamB.containsKey(p))
			return "B";
		return "";
	}

	public void setTeam(Player p, String team) {
		if (team == "A") {
			this.TeamA.put(p.getName(), "heavy");
		} else if (team == "B") {
			this.TeamB.put(p.getName(), "heavy");
		} else {
			this.TeamA.put(p.getName(), "heavy");
		}
	}

	public String getPClass(Player p) {
		if (this.TeamA.containsKey(p.getName()))
			return (String) this.TeamA.get(p.getName());
		if (this.TeamB.containsKey(p.getName()))
			return (String) this.TeamB.get(p.getName());
		return "";
	}

	public void setClass(Player p, String kit) {
		if (this.TeamA.containsKey(p.getName())) {
			this.TeamA.put(p.getName(), kit);
		} else if (this.TeamB.containsKey(p.getName())) {
			this.TeamB.put(p.getName(), kit);
		}
	}

	public void JoinTeam(Player p) {
		if ((this.TeamA.containsKey(p.getName()))
				|| (this.TeamB.containsKey(p.getName()))) {
			return;
		}
		this.offlineP.containsKey(p.getName());

		if (this.TeamA.size() < this.TeamB.size()) {
			setTeam(p, "A");
		} else {
			setTeam(p, "B");
		}

		p.getInventory().clear();
		if (this.plugin.running) {
			if (getTeam(p) == "A")
				p.teleport(this.plugin.SpawnA);
			else if (getTeam(p) == "B")
				p.teleport(this.plugin.SpawnB);
		} else if (this.plugin.idle)
			p.teleport(this.plugin.Spawn);
		else
			p.setHealth(0);
	}

	public void LeaveTeam(Player p) {
		String team = "";
		if (this.TeamA.containsKey(p.getName())) {
			team = "A";
			this.TeamA.remove(p.getName());
		} else if (this.TeamB.containsKey(p.getName())) {
			team = "B";
			this.TeamB.remove(p.getName());
		}
		if (this.plugin.waitingPlayers.containsKey(p.getName())) {
			this.plugin.waitingPlayers.remove(p.getName());
		}
		this.offlineP.put(p.getName(), team);
		p.getInventory().clear();
		p.setLevel(0);
		p.setExp(0.0F);
		p.teleport(((World) this.plugin.getServer().getWorlds().get(0))
				.getSpawnLocation());
	}

	public void PlayerJoin(Player p) {
		if (this.offlineP.containsKey(p)) {
			p.sendMessage(ChatColor.YELLOW + "Welcome back");
			JoinTeam(p);
		}
	}

	public boolean isinGame(Player p) {
		if ((getTeam(p) == "A") || (getTeam(p) == "B")) {
			return true;
		}
		return false;
	}

	public boolean isinGameWorld(Player p) {
		if ((this.plugin.Spawn != null)
				&& (p.getWorld().getName() == this.plugin.SpawnA.getWorld()
						.getName())) {
			return true;
		}
		return false;
	}
}
