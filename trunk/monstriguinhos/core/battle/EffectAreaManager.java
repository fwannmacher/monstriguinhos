package monstriguinhos.core.battle;

import java.util.LinkedList;

import monstriguinhos.core.Effect;
import monstriguinhos.core.MapCoordinate;
import monstriguinhos.core.Monster;

public class EffectAreaManager 
{
	private static EffectAreaManager __instance = null;
	
	public static EffectAreaManager Instance()
	{
		if(EffectAreaManager.__instance == null)
			EffectAreaManager.__instance = new EffectAreaManager();
		
		return EffectAreaManager.__instance;
	}
	
	private EffectAreaManager()
	{
	}
	
	public void doEffectOverArea(Effect effect)
	{
		for(Monster target : this._getTargetsOverArea(effect))
			effect.doEffectArea(target);
		
		effect.doEffect();
	}
	
	private Monster[] _getTargetsOverArea(Effect effect)
	{
		MapCoordinate[] coordinates = effect.getArea().getAreaCoordinates(MapManager.Instance().getMonsterCoordinate(effect.getTarget()));
		LinkedList<Team> teams = new LinkedList<Team>();
		LinkedList<Monster> targets = new LinkedList<Monster>();
		
		if(TeamManager.Instance().getTeam(effect.getOwner()).getLeader().getIdentification() != TeamManager.Instance().getTeam(effect.getTarget()).getLeader().getIdentification())
			for(Team team : TeamManager.Instance().getTeams())
				if(
					(team.getLeader().getIdentification() != TeamManager.Instance().getTeam(effect.getOwner()).getLeader().getIdentification()) &&
					(team.getLeader().getIdentification() != TeamManager.Instance().getTeam(effect.getTarget()).getLeader().getIdentification())
				  )
			
		teams.add(TeamManager.Instance().getTeam(effect.getTarget()));
		
		for(Team team : teams)
			for(Monster monster : team.getMembers())
				if(monster.getIdentification() != effect.getTarget().getIdentification())
					if(this._isMonsterOverArea(MapManager.Instance().getMonsterCoordinate(monster), coordinates))
						targets.add(monster);
		
		return (Monster[])targets.toArray();
	}
	
	private boolean _isMonsterOverArea(MapCoordinate monsterCoordinate, MapCoordinate[] areaCoordinates)
	{
		for(MapCoordinate coordinate : areaCoordinates)
			if(coordinate.getX() == monsterCoordinate.getX() && coordinate.getY() == monsterCoordinate.getY())
				return true;
			
		return false;
	}
}
