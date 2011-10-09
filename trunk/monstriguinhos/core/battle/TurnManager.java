package monstriguinhos.core.battle;

import monstriguinhos.core.Monster;

public class TurnManager 
{
	private static TurnManager __instance = null;
	
	public static TurnManager Instance()
	{
		if(TurnManager.__instance == null)
			TurnManager.__instance = new TurnManager();
		
		return TurnManager.__instance;
	}
	
	private Monster _currentTurnOwner;
	private int _currentTurnTeamIndex;
	private int _currentTurnOwnerIndex;
	private ETurnStep _currentTurnStep;
	
	private TurnManager()
	{
	}
	
	public void initialise(Monster firstTurnOwner)
	{
		this._currentTurnOwner = firstTurnOwner;
		this._currentTurnTeamIndex = TeamManager.Instance().getTeamIndex(firstTurnOwner);
		this._currentTurnOwnerIndex = 0;
		this._currentTurnStep = ETurnStep.Begin;
	}
	
	public void changeTurn()
	{
		if(++this._currentTurnTeamIndex >= TeamManager.Instance().getTeams().size())
		{
			this._currentTurnTeamIndex = 0;
			
			if(++this._currentTurnOwnerIndex >= TeamManager.Instance().getTeam(0).getMembers().size())
				this._currentTurnOwnerIndex = 0;
		}
		
		this._currentTurnOwner = TeamManager.Instance().getTeam(this._currentTurnTeamIndex).getMember(this._currentTurnOwnerIndex);
		this._currentTurnStep = ETurnStep.Begin;
	}
	
	public void changeTurnStep()
	{
		this._currentTurnStep = this._currentTurnStep.getNextStep(); 
	}
	
	public Monster getCurrentTurnOwner()
	{
		return this._currentTurnOwner;
	}
	
	public ETurnStep getCurrentTurnStep()
	{
		return this._currentTurnStep;
	}
	
	public boolean isOwnTurn(Monster monster)
	{
		return this._currentTurnOwner.getIdentification() == monster.getIdentification();
	}
}
