package monstriguinhos.util;

import java.lang.reflect.Constructor;

public class MonsterDataHandlerFactory 
{
	private static MonsterDataHandlerFactory __instace = null;
	
	public static MonsterDataHandlerFactory Instance()
	{
		if(MonsterDataHandlerFactory.__instace == null)
			MonsterDataHandlerFactory.__instace = new MonsterDataHandlerFactory();
		
		return MonsterDataHandlerFactory.__instace;
	}
	
	private MonsterDataHandlerFactory()
	{
	}
	
	public IMonsterDataHandler createDataTypeHandler() throws Exception
	{
		Class<?> MonsterDataTypeHandlerSubClass = ApplicationProperties.Instance().getMonsterDataHandlerClass();
		Constructor<?> constructor = MonsterDataTypeHandlerSubClass.getConstructor();
		
		return (IMonsterDataHandler)constructor.newInstance();
	}
}
