package monstriguinhos.core.battle;

public class BattleManager 
{
	private static BattleManager __instance = null;
	
	public static BattleManager Instance()
	{
		if(BattleManager.__instance == null)
			BattleManager.__instance = new BattleManager();
		
		return BattleManager.__instance;
	}
	
	private BattleManager()
	{
	}
	
	public void initialize()
	{
		TeamManager.Instance().initialize();
		EffectManager.Instance().initialize();
		MapManager.Instance().initialize();
		TurnManager.Instance().initialise(null);//TODO initialize TurnManager
	}
}
