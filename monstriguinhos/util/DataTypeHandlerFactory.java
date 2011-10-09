package monstriguinhos.util;

import java.lang.reflect.Constructor;

public class DataTypeHandlerFactory 
{
	private static DataTypeHandlerFactory __instace = null;
	
	public static DataTypeHandlerFactory Instance()
	{
		if(DataTypeHandlerFactory.__instace == null)
			DataTypeHandlerFactory.__instace = new DataTypeHandlerFactory();
		
		return DataTypeHandlerFactory.__instace;
	}
	
	private DataTypeHandlerFactory()
	{
	}
	
	public IDataTypeHandler createDataTypeHandler() throws Exception
	{
		Class<?> DataTypeHandlerSubClass = ApplicationProperties.Instance().getDataTypeHandlerClass();
		Constructor<?> constructor = DataTypeHandlerSubClass.getConstructor();
		
		return (IDataTypeHandler)constructor.newInstance();
	}
}
