package scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;


public class Day {
	
	private HashMap <String,Event> events;
	private ArrayList <String> keys;

	/*
	 * The events hashmap is going to hold the key and events. The key is the start and end time formatted DDMMHHMM-DDMMHHMM
	 * There is a second Hashmap with the name being the key and the start and end time as the value, this helps me with the names and times
	 * the ArrayList is for sorting and validation purposes. I can put the proposed event time into the arraylist, convert it to an array and sort to check for clashes.
	 */
	
	/*
	 * Constructor. Creates a Day object with an empty HashMap of events, and an ArrayList of all of the keys stored in it.
	 */
	public Day()
	{
		this.events = new HashMap<String,Event>();
		this.keys=new ArrayList<String>();
		
	}
	
	
	/*
	 * Calls the validTime method to determine if the event collides with any other event, or is invalid times.
	 * @return true if event can be added
	 */
	public boolean addEvent(String startTime, String endTime, String name)
	{
		String key= startTime.replace(" ", "") + "-" + endTime.replace(" ", "");
		if(validateTime(key)==false)
		{
			return false;
		}
		this.keys.add(key);
		this.events.put(key, new Event(startTime,endTime,name));
		return true;
		
	}
	/*
	 * Precondition: key is validated in Calendar.
	 * @return true if key is successfully removed
	 * @param key The key of the Event to be removed.
	 *
	 */
	public boolean removeEvent(String key)
	{
		if(this.keys.remove(key)==true)
		{
			this.events.remove(key);
			return true;
		}
		return false;
	}
	
	public boolean editEvent(String key,String newName,String newStartTime,String newEndTime)
	{
		Event eventHolder;
		eventHolder=this.events.get(key);
		if(eventHolder==null)
		{
			return false;
		}
		this.events.remove(key);
		if(this.addEvent(newStartTime, newEndTime, newName)==true)
		{
			return true;
		}
		return false;
	}

	public void addReminder(String start, String end, String time){
		String key= start.replace(" ", "") + "-" + end.replace(" ", "");
		Event curr = events.get(key);
		curr.addReminderTime(time);
	}
	public void editReminder(String start, String end, String time){
		String key= start.replace(" ", "") + "-" + end.replace(" ", "");
		Event curr = events.get(key);
		curr.editReminderTime(time);
	}
	public void removeReminder(String start, String end){
		String key= start.replace(" ", "") + "-" + end.replace(" ", "");
		Event curr = events.get(key);
		curr.removeReminder();
	}
	public HashMap<String,Event> getEvents(){
		return events;
	}
	
	public String display() 
	{
		// TODO Auto-generated method stub
		return "";
	}
	
	private boolean validateTime(String key)
	{
		
		//if the identical key is there, return false
		if(this.events.containsKey(key))
		{
			return false;
		}
		
		//Strings are formatted DDMMHHMM-DDMMHHMM
		String startTime=key.substring(0,8);
		String endTime=key.substring(9);
		//checking that the events start time is not after its end time, and that the months and days are real
		
		
		int indexOfKey=0;
		keys.add(key);
		String [] arr= (String[]) keys.toArray();
		Arrays.sort(arr);
		//putting the keys into a sorted array will show me the event before and after our desired scheduled time
		for(int i=0; i<arr.length;i++)
		{
			if(arr[i].equals(key))
			{
				indexOfKey=i;
				break;
			}
		}
		
		if(indexOfKey==0)
		{
			if(validateMonthAndDay(startTime,endTime)==false)
			{
				keys.remove(key);
				return false;
			}
			return true;
		
		}
		//need to check that the end time of the previous event does not exceed the start time of the new event
		if(indexOfKey>0)
		{
			String endTimeOfPrev=arr[indexOfKey-1].substring(13);
			if(validateMonthAndDay(endTimeOfPrev,startTime)==false)
			{
				keys.remove(key);
				return false;
			}
		}
	
		//checking that the end time of the new event is not after the start time of the next event
		if(arr.length>=indexOfKey + 1)
		{
			String startOfNext=arr[indexOfKey + 1].substring(3,8);
			if(validateMonthAndDay(endTime, startOfNext)==false)
			{
				keys.remove(key);
				return false;
			}
		}
		//if all of these pass, we return true
		return true;
	}
			
		
		private boolean validate24HTime(int hour, int minute)
		{
			if(hour < 0 || hour > 23 || minute < 0 || minute > 59)
			{
				return false;
			}
			return true;
		}
		
		private boolean validateMonthAndDay(String start, String end)
		{
			int month=Integer.parseInt(start.substring(0,2)); 
			int day=Integer.parseInt(start.substring(2,4));
			int hour=Integer.parseInt(start.substring(4,6));
			int minute=Integer.parseInt(start.substring(6,8));
			
			int endMonth=Integer.parseInt(end.substring(0,2));
			int endDay=Integer.parseInt(end.substring(2,4));
			int endHour=Integer.parseInt(end.substring(4,6));
			int endMinute=Integer.parseInt(end.substring(6,8));
			
			if(validate24HTime(hour,minute)==false || validate24HTime(endHour,endMinute)==false)
			{
				return false;
			}
			
			if(month<1 || month>12 || day < 1 || day > 31 || endMonth!=month || endDay!=day)
			{
				return false;
			} 
			
			if(endHour<hour || (endHour==hour && endMinute<minute))
			{
				return false;
			}
			
			switch(month)
			{
				case 2:
					if(day>28)
					{
						return false;
					}
				case 4,6,9,11:
					if(day>30)
					{
						return false;
					}
			}
			
			
			
			return true;
				
		}
	
	
		
	
	
}

