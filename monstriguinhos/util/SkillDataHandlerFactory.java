package monstriguinhos.util;

import java.lang.reflect.Constructor;

public class SkillDataHandlerFactory 
{
	private static SkillDataHandlerFactory __instace = null;
	
	public static SkillDataHandlerFactory Instance()
	{
		if(SkillDataHandlerFactory.__instace == null)
			SkillDataHandlerFactory.__instace = new SkillDataHandlerFactory();
		
		return SkillDataHandlerFactory.__instace;
	}
	
	private SkillDataHandlerFactory()
	{
	}
	
	public ISkillDataHandler createDataTypeHandler() throws Exception
	{
		Class<?> SkillDataTypeHandlerSubClass = ApplicationProperties.Instance().getSkillDataHandlerClass();
		Constructor<?> constructor = SkillDataTypeHandlerSubClass.getConstructor();
		
		return (ISkillDataHandler)constructor.newInstance();
	}
}
