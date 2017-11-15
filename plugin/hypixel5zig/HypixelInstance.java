package plugin.hypixel5zig;

import eu.the5zig.mod.server.ServerInstance;
import eu.the5zig.mod.The5zigAPI;
import plugin.hypixel5zig.Listener.*;

public class HypixelInstance extends ServerInstance {
	public static boolean IsHypixel(String host) {
        return host.toLowerCase().equals("hypixel.net") || host.toLowerCase().equals("hypixel.net.") || host.toLowerCase().endsWith(".hypixel.net") || host.toLowerCase().endsWith(".hypixel.net.");
    }
	@Override
	public void registerListeners() {
		getGameListener().registerListener(new HypixelListener());
		getGameListener().registerListener(new SkyWarsListener());
	}

	@Override
	public String getName() {
		return "Hypixel Network";
	}

	@Override
	public String getConfigName() {
		return "hypixel.net";
	}

	@Override
	public boolean handleServer(String host, int port) {
		return IsHypixel(host);
	}

}
