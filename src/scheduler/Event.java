package scheduler;
/* 
 * Core of the scheduler program. Building block for the Reminder and Calendar class. 
 * @author Grant Anderson 
 */

public class Event 
{
	private String startTime; //starting time for the event, will be represented using 2400 time. 1:36 PM is 1336
	private String endTime; //ending time for the event. Will have to make a verifying method.
	private String eventName; //name of the event.
	private Reminder eventReminder; //optional Reminder for the Event
	
	/*
	 * @Constructor
	 */
	public Event(String startTime, String endTime, String eventName)
	{
		this.startTime=startTime;
		this.endTime=endTime;
		this.eventName=eventName;	
		this.eventReminder = new Reminder();
	}
	
	
	
	public void changeName(String name)
	{
		this.eventName=name;
	}
	
	
	/*
	 * Precondition: newTime is assumed to be checked if valid in the Day class
	 */
	public void changeStartTime(String newTime)
	{
		this.startTime=newTime; 
	}
	
	/*
	 * Precondition: newTime is assumed to be checked if valid in the Day class
	 */
	public void changeEndTime(String newTime)
	{
		this.endTime=newTime;
	}
	
	
	public void addReminderTime(String reminderTime)
	{
		if(this.eventReminder!=null)
		{
			System.out.println("ERROR: Pre-existing reminder for this event.");
		}
		eventReminder.setReminderTime(Integer.parseInt(reminderTime));
		
	}

	public void editReminderTime(String reminderTime)
	{
		if(this.eventReminder==null)
		{
			System.out.println("Error: Non-existant remider's cannot be edited.");
			return;
		}
		this.eventReminder.setReminderTime(Integer.parseInt(reminderTime));
	}
	
	public String getStartTime()
	{
		return this.startTime;
	}
	
	public String getEndTime()
	{
		return this.endTime;
	}

	public int getReminderTime()
	{
		return this.eventReminder.getReminderTime();
	}
	
	public String getEventName()
	{
		return this.eventName;
	}
	
	
}
