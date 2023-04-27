package scheduler;
/* 
 * 
 */

public class Controller 
{
	private Profile theUser = null;
	private Profile[] accounts;
	
	public Controller()
	{
		
	}

	public Profile getTheUser() 
	{
		return theUser;
	}
	
	public void signIn(String username, String password)
	{
		boolean match = false;
		for(int x = 0; x < accounts.length; x++)
		{
			if(accounts[x].getName() == username && accounts[x].checkPass(password))
			{
				match = true;
				System.out.println("Username or password is incorrect. Please try again. ");
			}
		}
	}
	
	public void displayCalender()
	{
		theUser.getMyCalender().display();
	}
	
	public void addEvent(String name, String start, String end)
	{
		theUser.getMyCalender().addEvent(name, start, end);
	}
	
	public void displayLists()
	{
		for(int x = 0; x < theUser.getLists().length; x++)
		{
			theUser.getLists().display();
		}
	}
	
	public void createList(String listName)
	{

		List temp = new List(listName);
		//not sure on the syntax of this line
		theUser.getLists()[theUser.getLists().length] = temp;
	}
	
	public void addTask(String listName, String taskName)
	{
		theUser.addTask(listName, taskName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}