package monstriguinhos.core;

import monstriguinhos.util.DataHandler;
import monstriguinhos.util.DataHandlerFactory;
import monstriguinhos.util.DataTypeHandlerFactory;
import monstriguinhos.util.EffectDataHandlerFactory;
import monstriguinhos.util.IDataTypeHandler;
import monstriguinhos.util.IEffectDataHandler;

public abstract class Effect extends PersistedObject
{
	public static Effect Clone(Effect prototype)
	{
		return prototype.clone();
	}
	
	protected int _amount;
	protected boolean _instant;
	protected boolean _endOfTurn;
	protected boolean _targetTurn;
	protected int _duration;
	protected IEffectArea _area;
	protected Monster _owner;
	protected Monster _target;
	
	public Effect(long identification) throws Exception
	{
		super(identification);
	}
	
	public void doEffect()
	{
		this._doEffect(this._target);
		
		--this._duration;
	}
	
	public void doEffectArea(Monster target)
	{
		this._doEffect(target);
	}
	
	public abstract Effect clone();
	
	@Override
	public void load() throws Exception
	{
		IDataTypeHandler dataTypeHandler = DataTypeHandlerFactory.Instance().createDataTypeHandler();
		IEffectDataHandler effectDataHandler = EffectDataHandlerFactory.Instance().createDataTypeHandler();
		DataHandler dataHandler = DataHandlerFactory.Instance().createDataHandler(dataTypeHandler.getDataTypeName(EPersistedObjectType.Effect), this._identification);
		
		this._amount = ((Integer)dataHandler.getData(effectDataHandler.getDataName(EEffectData.Amount))).intValue();
		this._area = ((IEffectArea)dataHandler.getData(effectDataHandler.getDataName(EEffectData.Area)));
		this._duration = ((Integer)dataHandler.getData(effectDataHandler.getDataName(EEffectData.Duration))).intValue();
		this._endOfTurn = ((Boolean)dataHandler.getData(effectDataHandler.getDataName(EEffectData.EndOfTurn))).booleanValue();
		this._targetTurn = ((Boolean)dataHandler.getData(effectDataHandler.getDataName(EEffectData.TargetTurn))).booleanValue();
		this._instant = ((Boolean)dataHandler.getData(effectDataHandler.getDataName(EEffectData.Instant))).booleanValue();
	}

	@Override
	public void delete()
	{
		
	}

	@Override
	public void update()
	{
		
	}

	@Override
	public void insert()
	{
		
	}
	
	protected abstract void _doEffect(Monster target);
	
	protected Effect _clone(Class<?> EffectSubclass) throws Exception
	{
		Effect effect = (Effect)EffectSubclass.newInstance();
		effect._amount = this._amount;
		effect._area = this._area;
		effect._duration = this._duration;
		effect._endOfTurn = this._endOfTurn;
		effect._targetTurn = this._targetTurn;
		effect._identification = this._identification;
		effect._instant = this._instant;
		
		return effect;
	}
	
	public int getAmount()
	{
		return this._amount;
	}
	
	public IEffectArea getArea()
	{
		return this._area;
	}
	
	public int getDuration()
	{
		return this._duration;
	}
	
	public Monster getOwner()
	{
		return this._owner;
	}
	
	public Monster getTarget()
	{
		return this._target;
	}
	
	public boolean isDone()
	{
		return this._duration <= 0; 
	}
	
	public boolean isInstant()
	{
		return this._instant;
	}
	
	public boolean isEndOfTurn()
	{
		return this._endOfTurn;
	}
	
	public boolean isTargetTurn()
	{
		return this._targetTurn;
	}
	
	public void setOwner(Monster owner)
	{
		this._owner = owner;
	}
	
	public void setTarget(Monster target)
	{
		this._target = target;
	}
}
