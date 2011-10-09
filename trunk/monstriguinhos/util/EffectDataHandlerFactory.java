package monstriguinhos.util;

import java.lang.reflect.Constructor;

public class EffectDataHandlerFactory 
{
	private static EffectDataHandlerFactory __instace = null;
	
	public static EffectDataHandlerFactory Instance()
	{
		if(EffectDataHandlerFactory.__instace == null)
			EffectDataHandlerFactory.__instace = new EffectDataHandlerFactory();
		
		return EffectDataHandlerFactory.__instace;
	}
	
	private EffectDataHandlerFactory()
	{
	}
	
	public IEffectDataHandler createDataTypeHandler() throws Exception
	{
		Class<?> EffectDataTypeHandlerSubClass = ApplicationProperties.Instance().getEffectDataHandlerClass();
		Constructor<?> constructor = EffectDataTypeHandlerSubClass.getConstructor();
		
		return (IEffectDataHandler)constructor.newInstance();
	}
}
