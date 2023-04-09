package scheduler;

import java.util.LinkedList;


public class Day {
	
	boolean [] time;
	LinkedList <Event> events;
	
	public Day()
	{
		this.events = new LinkedList <Event>();
		this.time=new boolean [2400]; //this instantiates everything to false, we will mark the times that are taken as true
	}
	
	public void addEvent(Event newEvent)
	{
		if(validateTime(newEvent)==true)
		{
			for(int i=newEvent.getStartTime()-1;i<=newEvent.getEndTime();i++)
			{
				this.time[i]=true;
			}
			this.events.add(newEvent);
		}
	}
	
	public void removeEvent(Event oldEvent)
	{
		for(int i=oldEvent.getStartTime()-1;i<=oldEvent.getEndTime();i++) 
		{
			this.time[i]=false;
		}
		this.events.remove(oldEvent);
	}
	
	private boolean validateTime(Event newEvent)
	{
		for(int i=newEvent.getStartTime()-1; i<=newEvent.getEndTime();i++)
		{
			if(this.time[i]==true) //checks every index in between the start and stop time, if conflict, returns false;
				return false;
		}
		return true; //if no conflicts true
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}
}
