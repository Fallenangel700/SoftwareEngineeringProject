package scheduler;
/* 
 * 
 */

public class Task 
{
	private String taskName; //name of the task.
	private String details; //optional blurb to store some details about the task.
	
	public Task(String newTaskName, String newDetails)
	{
		this.taskName=newTaskName;
		this.details=newDetails;
	}
	
	public void changeName(String newTaskName)
	{
		this.taskName = newTaskName;
	}
	
	public void changeDetails(String newDetails)
	{
		this.details=newDetails;
	}
	
	public String getName()
	{
		return this.taskName;
	}
	
	public String getDetails()
	{
		return this.details;
	}
}
