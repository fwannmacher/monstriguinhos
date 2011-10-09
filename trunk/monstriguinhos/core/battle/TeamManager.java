package monstriguinhos.core.battle;

import java.util.LinkedList;

import monstriguinhos.core.Monster;

public class TeamManager 
{
	private static TeamManager __instance = null;
	
	public static TeamManager Instance()
	{
		if(TeamManager.__instance == null)
			TeamManager.__instance = new TeamManager();
		
		return TeamManager.__instance;
	}
	
	private LinkedList<Team> _teams;
	
	private TeamManager()
	{
		this._teams = new LinkedList<Team>();
	}
	
	public void initialize()
	{
		this._teams.clear();
	}
	
	public void addTeam(Team team)
	{
		this._teams.add(team);
	}
	
	public Team getTeam(Monster member)
	{
		for(Team team : this._teams)
			if(team.hasMember(member))
				return team;
		
		return null;
	}
	
	public Team getTeam(int index)
	{
		if(index < 0)
			index = this._teams.size() - 1;
		else if(index >= this._teams.size())
			index = 0;
		
		return this._teams.get(index);
	}
	
	public int getTeamIndex(Monster member)
	{
		for(int i = 0; i < this._teams.size(); ++i)
			if(this._teams.get(i).hasMember(member))
				return i;
		
		return -1;
	}
	
	public LinkedList<Team> getTeams()
	{
		return this._teams;
	}
	
	public boolean isEnemy(Monster owner, Monster monster)
	{
		return this.getTeam(owner).hasMember(monster);
	}
}
