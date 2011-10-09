package monstriguinhos.core.battle;

public enum ETurnStep 
{
	Begin(0),
	FirstAction(1),
	LastAction(2),
	End(3);
	
	private int _value;
	
	private ETurnStep(int value) 
	{
		this._value = value;
	}
	
	public int getValue()
	{
		return this._value;
	}
	
	public ETurnStep getNextStep()
	{
		switch(this._value)
		{
		case 0:
			return ETurnStep.FirstAction;
		case 1:
			return ETurnStep.LastAction;
		default:
			return ETurnStep.End;			
		}
	}
}
