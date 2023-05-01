package scheduler;
/* 
 * 
 */

public class Controller 
{
	private Profile theUser = null;
	private Profile[] accounts;
	private int numAccounts;
	
	public Controller()
	{
		accounts = new Profile[0];
		numAccounts = 0;
	}

	public void setTheUser(Profile user)
	{
		theUser = user;
	}

	public Profile getTheUser() 
	{
		return theUser;
	}
	
	public boolean signIn(String username, String password)
	{
		boolean match = false;
		for(int x = 0; x < accounts.length; x++)
		{
			if(accounts[x].getName() == username && accounts[x].checkPass(password))
			{
				match = true;
				setTheUser(accounts[x]);
			}
		}
		if(match == false)
		{
			System.out.println("Username or Password is incorrect.");
		}
		return match;
	}

	public void addNewProfile(String username, String password)
	{
		Profile newProfile = new Profile(username, password);
		Profile newAccounts[] = new Profile[numAccounts+1];
		for(int i = 0; i < numAccounts; i++)
			newAccounts[i] = accounts[i];
		newAccounts[numAccounts+1] = newProfile;
		numAccounts++;
		accounts = newAccounts;
		theUser = newProfile;
	}
	
	public void displayCalender()
	{
		theUser.getMyCalender().display();
	}
	
	public void addEvent(String name, String start, String end)
	{
		theUser.getMyCalender().addEvent(name, start, end);
	}
	
	public void editEvent(String oldName, String newName, String start, String end)
	{
		theUser.getMyCalender().editEvent(oldName, newName, start, end);
	}
	
	public void removeEvent(String name)
	{
		theUser.getMyCalender().removeEvent(name);
	}
	
	public void displayLists()
	{
		//for(int x = 0; x < theUser.getLists().length; x++)
		//{
			theUser.getLists().toString();
		//}
	}
	
	public void createList(String listName)
	{
		List temp = new List();
		theUser.getLists().push(temp);
	}
	
	public void deleteList(String listName) {
		int match = -1; 
		for(int x = 0; x < theUser.getLists().size(); x++)
		{
			if(theUser.getLists().get(x).getListName().equalsIgnoreCase(listName))
			{
				match = x;
				break;
			}
		}
		if(match != -1)
		{
			theUser.getLists().remove(match);
		}
		else
			System.out.println("List not found.");
	}
	
	public void addTask(String listName, String taskName)
	{
		int match = -1; 
		for(int x = 0; x < theUser.getLists().size(); x++)
		{
			if(theUser.getLists().get(x).getListName().equalsIgnoreCase(listName))
			{
				match = x;
				break;
			}
		}
		if(match != -1)
		{
			Task temp = new Task(taskName);
			theUser.getLists().get(match).addTask(temp);
		}
		else
			System.out.println("List not found.");
	}
	public void removeTask(String listName, String taskName)
	{
		int match = -1; 
		for(int x = 0; x < theUser.getLists().size(); x++)
		{
			if(theUser.getLists().get(x).getListName().equalsIgnoreCase(listName))
			{
				match = x;
				break;
			}
		}
		if(match != -1)
		{
			Task temp = new Task(taskName);
			theUser.getLists().get(match).removeTask(temp);
		}
		else
			System.out.println("List not found.");
	}
	public void editTask(String listName)
	{
		int match = -1; 
		for(int x = 0; x < theUser.getLists().size(); x++)
		{
			if(theUser.getLists().get(x).getListName().equalsIgnoreCase(listName))
			{
				match = x;
				break;
			}
		}
		if(match != -1)
		{
			theUser.getLists().get(match).editTask();
		}
		else
			System.out.println("List not found.");
	}
	public void setReminder(String eventName)
	{
		theUser.getMyCalender().setReminder();
	}
	
	public void printToFile()
	{
		theUser.getMyCalender().printToFile();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}