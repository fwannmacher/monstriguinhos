package monstriguinhos.core;

import monstriguinhos.util.DataHandler;
import monstriguinhos.util.DataHandlerFactory;
import monstriguinhos.util.DataTypeHandlerFactory;
import monstriguinhos.util.IDataTypeHandler;
import monstriguinhos.util.ISkillDataHandler;
import monstriguinhos.util.SkillDataHandlerFactory;

public class Skill extends PersistedObject
{
	protected Effect _effect;
	protected String _name;
	
	public Skill(long identification) throws Exception
	{
		super(identification);
	}
	
	@Override
	public void load() throws Exception
	{
		IDataTypeHandler dataTypeHandler = DataTypeHandlerFactory.Instance().createDataTypeHandler();
		ISkillDataHandler skillDataHandler = SkillDataHandlerFactory.Instance().createDataTypeHandler();
		DataHandler dataHandler = DataHandlerFactory.Instance().createDataHandler(dataTypeHandler.getDataTypeName(EPersistedObjectType.Skill), this._identification);
		
		this._name = ((String)dataHandler.getData(skillDataHandler.getDataName(ESkillData.Name)));
		
		dataHandler = DataHandlerFactory.Instance().createDataHandler(dataTypeHandler.getDataTypeName(EPersistedObjectType.SkillEffect), this._identification);
		
		this._effect = (Effect)dataHandler.getData(skillDataHandler.getDataName(ESkillData.Effect));
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
	
	public Effect getEffect()
	{
		return this._effect;
	}
	
	public String getName()
	{
		return this._name;
	}
}
