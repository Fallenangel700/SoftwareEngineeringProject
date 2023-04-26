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
		if(reminderTime>= 0000 || reminderTime<2400)
			this.reminderTime=reminderTime;
		else
			System.out.println("ERROR: Invalid time entered.");
	}

	public int getReminderTime()
	{
		return this.reminderTime;
	}
}
