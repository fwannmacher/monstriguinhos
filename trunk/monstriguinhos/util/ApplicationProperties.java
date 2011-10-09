package monstriguinhos.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationProperties 
{
	private static ApplicationProperties __instace = null;
	
	public static ApplicationProperties Instance()
	{
		if(ApplicationProperties.__instace == null)
			ApplicationProperties.__instace = new ApplicationProperties();
		
		return ApplicationProperties.__instace;
	}
	
	private Class<?> _dataHandlerClass;
	private Class<?> _dataTypeHandlerClass;
	private Class<?> _effectDataHandlerClass;
	private Class<?> _monsterDataHandlerClass;
	private Class<?> _skillDataHandlerClass;
	
	private ApplicationProperties()
	{
	}
	
	public void loadProperties(String propertiesPath) throws Exception
	{
		Properties properties = new Properties();
		File propertiesFile = new File(propertiesPath);
		FileInputStream fileInputStream = new FileInputStream(propertiesFile);
		
		properties.load(fileInputStream);
		fileInputStream.close();
		
		this._dataHandlerClass = Class.forName(properties.getProperty("DataHandler"));
		this._dataTypeHandlerClass = Class.forName(properties.getProperty("DataTypeHandler"));
		this._effectDataHandlerClass = Class.forName(properties.getProperty("EffectDataHandler"));
		this._monsterDataHandlerClass = Class.forName(properties.getProperty("MonsterDataHandler"));
		this._skillDataHandlerClass = Class.forName(properties.getProperty("SkillDataHandler"));
	}
	
	public Class<?> getDataHandlerClass()
	{
		return this._dataHandlerClass;
	}
	
	public Class<?> getDataTypeHandlerClass()
	{
		return this._dataTypeHandlerClass;
	}
	
	public Class<?> getMonsterDataHandlerClass()
	{
		return this._monsterDataHandlerClass;
	}
	
	public Class<?> getSkillDataHandlerClass()
	{
		return this._skillDataHandlerClass;
	}
	
	public Class<?> getEffectDataHandlerClass()
	{
		return this._effectDataHandlerClass;
	}
}
