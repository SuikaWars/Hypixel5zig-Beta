package ga.hypixel5zig.games;

import eu.the5zig.mod.server.GameMode;

public abstract class Hypixel extends GameMode {
	private String Kit;
	private String ShotHP;
	private long ShotHPTime;
	private int KillStreak;
	private int WinStreak;
	private int Assists;
	private int EarnedCoins;
	private String Team;
	private long CageOpenTime;
	public void setKit(String Kit1)
	{
		Kit = Kit1;
	}
	public String getKit()
	{
		return Kit;
	}
	public void setCageOpenTime(long CageOpenTime1)
	{
		CageOpenTime = CageOpenTime1;
	}
	public long getCageOpenTime()
	{
		return CageOpenTime;
	}
	public void setKillstreak(int Killstreak)
	{
		KillStreak = Killstreak;
	}
	public int getKillstreak()
	{
		return KillStreak;
	}
	public void setWinStreak(int Winstreak)
	{
		WinStreak = Winstreak;
	}
	public int getWinStreak()
	{
		return WinStreak;
	}
	public void setAssists(int Assists1)
	{
		Assists = Assists1;
	}
	public int getAssists()
	{
		return Assists;
	}
	public void setEarnedCoins(int coins)
	{
		EarnedCoins = coins;
	}
	public int getEarnedCoins()
	{
		return EarnedCoins;
	}
	public void setTeam(String team)
	{
		Team = team;
	}
	public String getTeam()
	{
		return Team;
	}
	public void setShotHP(String shotHP)
	{
		ShotHP = shotHP;
	}
	public String getShotHP()
	{
		return ShotHP;
	}
	public void setShotHPTime(long shotHPtime)
	{
		ShotHPTime = shotHPtime;
	}
	public long getShotHPTime()
	{
		return ShotHPTime;
	}
}
