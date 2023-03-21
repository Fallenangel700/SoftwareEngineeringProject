package scheduler;
/* 
 * Core of the scheduler program. Building block for the Reminder and Calendar class.
 * @author Grant Anderson 
 */

public class Event 
{
	private int startTime; //starting time for the event, will be represented using 2400 time. 1:36 PM is 1336
	private int endTime; //ending time for the event. Will have to make a verifying method.
	private String eventName; //name of the event.
	private Reminder eventReminder; //optional Reminder for the Event
	
	public Event(int startTime, int endTime, String eventName)
	{
		this.startTime=startTime;
		this.endTime=endTime;
		this.eventName=eventName;	
	}
	
	public void changeName(String name)
	{
		this.eventName=name;
	}
	
	public void changeStartTime(int newTime)
	{
		if(validateTime(newTime)==true) //calls the validateTime function to verify time is between 0-2400
		{
			this.startTime=newTime; 
		}
		//if the time is not valid, the time does not change
	}
	
	public void changeEndTime(int newTime)
	{
		if(validateTime(newTime)==true) //calls the validateTime function to verify time is between 0-2400
		{
			this.endTime=newTime;
		}
		//if the time is not valid, the time does not change
	}
	
	public void setReminderTime(int reminderTime)
	{
		if(this.eventReminder==null)
		{
			this.eventReminder= new Reminder();
			this.eventReminder.setReminderTime(reminderTime);
		}
		else if(validateReminderTime(reminderTime)==true)
		{
			this.eventReminder.setReminderTime(reminderTime);
		}
	}
	
	public int getStartTime()
	{
		return this.startTime;
	}
	
	public int getEndTime()
	{
		return this.endTime;
	}
	
	public String getEventName()
	{
		return this.eventName;
	}
	
	private boolean validateReminderTime(int time)
	{
		if(validateTime(time)==false || time>=this.startTime) //if the time is at the time of the event or after, return false
		{
			return false;
		}
		return true;
		
	}
	
	private boolean validateTime(int time)
	{
		if(time>=0 && time<=2400)
		{
			return true;
		}
		else return false;
	}
}
