package monstriguinhos.util;

public abstract class DataHandler 
{
	protected String _handledDataName;
	protected long _handledDataIdentification;
	
	public DataHandler(String handledDataName, long handledDataIdentification)
	{
		this._handledDataName = handledDataName;
		this._handledDataIdentification = handledDataIdentification;
	}
	
	public abstract Object getData(String name);
}
