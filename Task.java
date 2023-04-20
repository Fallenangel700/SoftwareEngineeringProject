package scheduler;
/* 
 * 
 */

public class Task 
{
	private String taskName; //name of the task.
	private String details; //optional blurb to store some details about the task.
	
	public Task(String newTaskName)
	{
		this.taskName=newTaskName;
	}
	
	public Task(String newTaskName, String newDetails)
	{
		//Task(newTaskName); Is there a reason to create a task in the task constructor?
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
		if(this.details ==null)
		{
			return "No details entered for Task";
		}
		return this.details;
	}
}
