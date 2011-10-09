package monstriguinhos.core.battle;

import java.util.LinkedList;

import monstriguinhos.core.Monster;

public class Team 
{
	private LinkedList<Monster> _members;
	
	public Team(Monster leader)
	{
		this._members = new LinkedList<Monster>();
		this._members.add(leader);
	}
	
	public void addMember(Monster monster)
	{
		this._members.add(monster);
	}
	
	public boolean hasMember(Monster monster)
	{
		for(Monster member : this._members)
			if(member.getIdentification() == monster.getIdentification())
				return true;
		
		return false;
	}
	
	public Monster getMember(int index)
	{
		if(index < 0)
			index = this._members.size() - 1;
		else if(index >= this._members.size())
			index = 0;
		
		return this._members.get(index);
	}
	
	public int getMemberIndex(Monster monster)
	{
		for(int i = 0; i < this._members.size(); ++i)
			if(this._members.get(i).getIdentification() == monster.getIdentification())
				return i;
		
		return -1;
	}
	
	public LinkedList<Monster> getMembers()
	{
		return this._members;
	}
	
	public Monster getLeader()
	{
		return this._members.get(0);
	}
}
