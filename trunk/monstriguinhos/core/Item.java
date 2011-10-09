package monstriguinhos.core;

public abstract class Item extends PersistedObject
{
	protected int _cost;
	protected Effect _effect;
	protected long _identification;
	protected ItemType _type;
	
	public Item(long identification) throws Exception
	{
		super(identification);
	}
	
	@Override
	public void load()
	{
		//TODO load
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
	
	public int getCost()
	{
		return this._cost;
	}
	
	public Effect getEffect()
	{
		return this._effect;
	}
	
	public ItemType getType()
	{
		return this._type;
	}
}
