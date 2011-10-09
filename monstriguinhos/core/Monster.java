package monstriguinhos.core;

import java.util.Map;

import monstriguinhos.util.DataHandler;
import monstriguinhos.util.DataHandlerFactory;
import monstriguinhos.util.DataTypeHandlerFactory;
import monstriguinhos.util.IDataTypeHandler;
import monstriguinhos.util.IMonsterDataHandler;
import monstriguinhos.util.MonsterDataHandlerFactory;

public class Monster extends PersistedObject
{
	private byte _happiness;
	private byte _health;
	private byte _hitPoints;
	private Map<String, Skill> _skills;
	
	public Monster(long identification) throws Exception
	{
		super(identification);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load() throws Exception
	{
		IDataTypeHandler dataTypeHandler = DataTypeHandlerFactory.Instance().createDataTypeHandler();
		IMonsterDataHandler monsterDataHandler = MonsterDataHandlerFactory.Instance().createDataTypeHandler();
		DataHandler dataHandler = DataHandlerFactory.Instance().createDataHandler(dataTypeHandler.getDataTypeName(EPersistedObjectType.Monster), this._identification);
		
		this._happiness = ((Byte)dataHandler.getData(monsterDataHandler.getDataName(EMonsterData.Happiness))).byteValue();
		this._health = ((Byte)dataHandler.getData(monsterDataHandler.getDataName(EMonsterData.Health))).byteValue();
		this._hitPoints = ((Byte)dataHandler.getData(monsterDataHandler.getDataName(EMonsterData.HitPoints))).byteValue();
		
		dataHandler = DataHandlerFactory.Instance().createDataHandler(dataTypeHandler.getDataTypeName(EPersistedObjectType.MonsterSkill), this._identification);
		
		this._skills = (Map<String, Skill>)dataHandler.getData(monsterDataHandler.getDataName(EMonsterData.Skill));
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
	
	public byte getHappiness()
	{
		return this._happiness;
	}
	
	public byte getHealth()
	{
		return this._health;
	}
	
	public byte getHitPoints()
	{
		return this._hitPoints;
	}
	
	public Skill getSkill(String name)
	{
		return this._skills.get(name);
	}
	
	public Map<String, Skill> getSkills()
	{
		return this._skills;
	}
}
