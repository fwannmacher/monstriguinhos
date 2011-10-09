package monstriguinhos.core;

public abstract class PersistedObject 
{
	protected long _identification;
	
	public PersistedObject(long identification) throws Exception
	{
		this._identification = identification;
		
		if(identification > 0)
			this.load();
	}
	
	public long getIdentification()
	{
		return this._identification;
	}
	
	public void save()
	{
		if(this._identification > 0)
			this.update();
		else
			this.insert();
	}
	
	public abstract void load() throws Exception;
	public abstract void delete();
	public abstract void update();
	public abstract void insert();
}
