package monstriguinhos.core.battle;

import java.util.LinkedList;

import monstriguinhos.core.Effect;
import monstriguinhos.core.Monster;

public class EffectManager 
{
	private static EffectManager __instance = null;
	
	public static EffectManager Instance()
	{
		if(EffectManager.__instance == null)
			EffectManager.__instance = new EffectManager();
		
		return EffectManager.__instance;
	}
	
	private LinkedList<Effect> _effects;
	
	private EffectManager()
	{
		this._effects = new LinkedList<Effect>();
	}
	
	public void initialize()
	{
		this._effects.clear();
	}
	
	public void addEffect(Effect effect)
	{		
		if(effect.isInstant())
			EffectAreaManager.Instance().doEffectOverArea(effect);
		
		if(!effect.isDone())
			this._effects.add(effect);
	}
	
	public void updateEffects()
	{
		Monster turnOwner = TurnManager.Instance().getCurrentTurnOwner();
		
		for(Effect effect : this._effects)
			if(
				(effect.getOwner().getIdentification() == turnOwner.getIdentification() && (!effect.isTargetTurn())) ||
				(effect.getTarget().getIdentification() == turnOwner.getIdentification() && effect.isTargetTurn())
			  )
				this._updateEffect(effect);
			
		this._removeDoneEffects();
	}
	
	private void _updateEffect(Effect effect)
	{
		if(
			(TurnManager.Instance().getCurrentTurnStep() == ETurnStep.Begin && (!effect.isEndOfTurn())) ||
			(TurnManager.Instance().getCurrentTurnStep() == ETurnStep.End && effect.isEndOfTurn())
		  )
			EffectAreaManager.Instance().doEffectOverArea(effect);
	}
	
	private void _removeDoneEffects()
	{
		for(int i = this._effects.size() - 1; i >= 0; --i)
			if(this._effects.get(i).isDone())
				this._effects.remove(i);
	}
}
