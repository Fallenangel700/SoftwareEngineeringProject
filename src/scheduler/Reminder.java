package scheduler;

public class Reminder
{
	private int reminderTime;
	
	public Reminder()
	{
		this.reminderTime=-1;
	}
	
	public void setReminderTime(int reminderTime)
	{
		this.reminderTime=reminderTime;
	}

	public int getReminderTime()
	{
		return this.reminderTime;
	}
}
