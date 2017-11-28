package plugin.hypixel5zig.listener;

import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.util.minecraft.ChatColor;
import eu.the5zig.mod.server.GameListenerRegistry;

public class HypixelListener extends AbstractGameListener<GameMode> {
	private boolean wtfmap;
	private boolean whereami;
	private boolean arcade;
	private long ShotHPTime;
	public static String Server;
	public static String Map;
	public static String Game;
	public static String ShotHP;

	@Override
	public Class<GameMode> getGameMode() {
		return null;
	}

	@Override
	public boolean matchLobby(String lobby) {
		return false;
	}

	@Override
	public void onMatch(GameMode gameMode, String key, IPatternResult match)
	{
		if (key.equals("whereami") && this.whereami == true) {
			this.Server = match.get(0);
			if((match.get(0).startsWith("mega") || match.get(0).startsWith("mini")) && !(match.get(0).contains("lobby"))){
				getGameListener().sendAndIgnore("/wtfmap", "wtfmap");
				this.wtfmap = true;
				String[] Scoreboard = ChatColor.stripColor(The5zigAPI.getAPI().getSideScoreboard().getTitle()).split(" ");
				String game = "";
				for(String key1 : Scoreboard){
					if(game.equals("")){
						game = game + key1.substring(0, 1).toUpperCase() + key1.substring(1).toLowerCase();
					}else{
						game = game + " " + key1.substring(0, 1).toUpperCase() + key1.substring(1).toLowerCase();
					}
				}
				game = game.replace("Skywars","SkyWars").replace("The Tnt Games","The TNT Games").replace("Skyclash","SkyClash").replace("Blitz Sg","Blitz SG").replace("Hypixel","UHC Champions").replace("Cops And Crims","Cops and Crims").replace("Speed Uhc","Speed UHC").replace("Bed wars","Bed Wars").replace("Vampirez","VampireZ");
				if(game.equals("The TNT Games")){
					for(String key2 : The5zigAPI.getAPI().getSideScoreboard().getLines().keySet()){
						key2 = ChatColor.stripColor(key2);
						if(key2.startsWith("Game: ")){
							game = key2.replace("Game: ","").replace("Bow Sple","Bow Spleef").replace("TNT Wiza","TNT Wizards");
						}
					}
				}
				if(game.equals("Arcade Games")){
					getGameListener().sendAndIgnore("/wtfmap", "wtfmap");
					this.arcade = true;
				}else{
					this.Game = game;
				}
			}else{
				this.Game = null;
			}
			getGameListener().switchLobby(match.get(0));
			this.whereami = false;
		}
		if (key.equals("wtfmap") && this.wtfmap == true && this.arcade == true) {
			this.Game = match.get(0);
			this.wtfmap = false;
			this.arcade = false;
		}else if(key.equals("wtfmap") && this.wtfmap == true){
			this.Map = match.get(0);
			this.wtfmap = false;
		}
		if (key.equals("ShotHP")) {
			this.ShotHP = match.get(0) + "," + match.get(1);
			this.ShotHPTime = System.currentTimeMillis();

		}
	}
	@Override
	public void onServerConnect(GameMode gameMode)
	{
		this.Map = null;
		this.Game = null;
		this.whereami = true;
		getGameListener().sendAndIgnore("/whereami", "whereami");
	}
	@Override
	public void onServerDisconnect(GameMode gameMode)
	{
		this.Server = null;	
		this.Map = null;
		this.Game = null;
	}
	public void onTick(GameMode gameMode)
	{
		if ((this.ShotHPTime != -1L) && (2000L + this.ShotHPTime - System.currentTimeMillis() < 0L))
		{
			this.ShotHP = null;
			this.ShotHPTime = -1L;
		}
	}
}