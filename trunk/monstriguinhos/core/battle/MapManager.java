package monstriguinhos.core.battle;

import java.util.HashMap;

import monstriguinhos.core.MapCoordinate;
import monstriguinhos.core.Monster;

public class MapManager 
{
	private static MapManager __instance = null;
	
	public static MapManager Instance()
	{
		if(MapManager.__instance == null)
			MapManager.__instance = new MapManager();
		
		return MapManager.__instance;
	}
	
	private HashMap<Long, MapCoordinate> _monstersCoordinates;
	
	private MapManager()
	{
		this._monstersCoordinates = new HashMap<Long, MapCoordinate>();
	}
	
	public void initialize()
	{
		this._monstersCoordinates.clear();
	}
	
	public void addMonster(Monster monster, MapCoordinate coordinate)
	{
		this._monstersCoordinates.put(monster.getIdentification(), coordinate);
	}
	
	public void changeMonsterCoordinate(Monster monster, MapCoordinate coordinate)
	{
		this._monstersCoordinates.put(monster.getIdentification(), coordinate);
	}
	
	public MapCoordinate getMonsterCoordinate(Monster monster)
	{
		return this._monstersCoordinates.get(monster.getIdentification());
	}
	
	public MapCoordinate[] getPath(MapCoordinate begin, MapCoordinate end)
	{
		//TODO getPath **** A-Star ****
		return null;
	}
}
