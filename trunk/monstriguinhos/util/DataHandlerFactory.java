package monstriguinhos.util;

import java.lang.reflect.Constructor;

public class DataHandlerFactory 
{
	private static DataHandlerFactory __instace = null;
	
	public static DataHandlerFactory Instance()
	{
		if(DataHandlerFactory.__instace == null)
			DataHandlerFactory.__instace = new DataHandlerFactory();
		
		return DataHandlerFactory.__instace;
	}
	
	private DataHandlerFactory()
	{
	}
	
	public DataHandler createDataHandler(String handledDataName, long handledDataIdentification) throws Exception
	{
		Class<?> DataHandlerSubClass = ApplicationProperties.Instance().getDataHandlerClass();
		Constructor<?> constructor = DataHandlerSubClass.getConstructor(String.class, long.class);
		
		return (DataHandler)constructor.newInstance(handledDataName, new Long(handledDataIdentification));
	}
}
