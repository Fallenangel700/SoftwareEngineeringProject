package scheduler;
/* 
 * 
 */
import java.util.Scanner;
import java.util.Vector;

public class Controller 
{
	private Profile theUser = null;
	//private Profile[] accounts;
	Vector<Profile> accounts = new Vector<Profile>(1);
	
	
	
	public Controller()
	{
		//accounts = new Profile[0];
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
		for(int x = 0; x < accounts.size(); x++)
		{
			if(accounts.get(x).getName() == username && accounts.get(x).checkPass(password))
			{
				match = true;
				setTheUser(accounts.get(x));
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
		accounts.add(newProfile);
		theUser = newProfile;
	}
	
	public void displayCalender()
	{
		theUser.getMyCalender().display();
	}
	
	public void addEvent(String name, String start, String end)
	{
		theUser.getMyCalender().addEvent( name, start, end);
	}
	
	public void editEvent(String oldName, String newName, String start, String end)
	{
		theUser.getMyCalender().editEvent( oldName, newName, start, end);
	}
	
	public void removeEvent(String name)
	{
		theUser.getMyCalender().removeEvent( name);
	}
	
	public void duplicateEvent()
	{
		
	}
	
	public void displayLists()
	{
		for(int x = 0; x < theUser.lists.size(); x++)
		{
			System.out.println(theUser.lists.get(x).getListName());
			theUser.lists.get(x).display();
		}
	}
	
	public void queryFreeTime(String date)
	{
		this.theUser.getMyCalender().queryFreeTime(date);
	}
	
	public void createList(String listName)
	{
		List temp = new List(listName);
		theUser.lists.push(temp);
	}

	public void editList(String listName)
	{
		Scanner keyboard = new Scanner(System.in);
		String newListName;
		String input;
		boolean finished = false;
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
			System.out.println("Would you like to change your list name? (yes/no)");
			input = keyboard.nextLine();
			input.replace("\n", "");
			while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no") )
			{
				System.out.println("Input invalid. Please enter yes or no");
				System.out.println("Would you like to change your list name? (yes/no)");
				input = keyboard.next();
				input.replace("\n", "");
			}
			if(input.equalsIgnoreCase("yes"))
			{
				System.out.println("Please enter the new list name: ");
				newListName = keyboard.nextLine();
				input.replace("\n", "");
				theUser.getLists().get(match).setListName(newListName);
			}
			while(finished == false)
			{
				System.out.println("Would you like to delete a task? (yes/no)");
				input = keyboard.nextLine();
				input.replace("\n", "");
				while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
				{
					System.out.println("Input invalid. Please enter yes or no");
					System.out.println("Would you like to delete a task? (yes/no)");
					input = keyboard.nextLine();
					input.replace("\n", "");
				}
				if(input.equalsIgnoreCase("yes"))
				{
					int taskNum;
					theUser.getLists().get(match).display();
					System.out.print("Enter task number to delete: ");
					taskNum = keyboard.nextInt();
					while(taskNum > theUser.getLists().get(match).listedTasks.size())
					{
						System.out.print("Input invalid. Please enter a task number to delete: ");
						input = keyboard.nextLine();
						input.replace("\n", "");
					}
					theUser.getLists().get(match).removeTask(theUser.getLists().get(match).listedTasks.get(taskNum-1));

				}
				else
					finished = true;
			}
		}
		else
			System.out.println("List not found.");

		keyboard.close();
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
			theUser.lists.get(match).removeTask(taskName);
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
	public Task getTask(String listName, String name){
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
			return theUser.getLists().get(match).getTask(name);
		}
		else
			return null;
	}

	public void addReminder(String start, String end, String time){
		theUser.getMyCalender().addReminder(start, end, time);
	}

	public void editReminder(String start, String end, String newTime)
	{
		theUser.getMyCalender().editReminder(start, end, newTime);
	}

	public void removeReminder(String start, String end){
		theUser.getMyCalender().removeReminder(start, end);
	}
	
	public void printToFile(String directory)
	{
		PrintToFile printer = new PrintToFile(theUser.getMyCalender());
		try{
			printer.printCal(directory);
		} catch(Exception e){
			System.out.println("invalid directory");
		}
	}

	public void editProfile()
	{
		Scanner keyboard = new Scanner(System.in);
		String newUsername;
		String newPassword;
		boolean finished;
		String input;
		System.out.println("Would you like to change your username? (yes/no)");
		input = keyboard.nextLine();
		while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
		{
			System.out.println("Input invalid. Please enter yes or no");
			System.out.println("Would you like to change your username? (yes/no)");
			input = keyboard.nextLine();
		}
		if(input.equalsIgnoreCase("yes"))
		{
			finished = false;
			while(finished == false)
			{
				System.out.print("Enter your new username: ");
				newUsername = keyboard.nextLine();
				System.out.println("Is the username "+ newUsername + "correct?");
				input = keyboard.nextLine();
				while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
				{
					System.out.println("Input invalid. Please enter yes or no");
					System.out.println("Is the username "+ newUsername + "correct?");
					input = keyboard.nextLine();
				}
				if(input.equalsIgnoreCase("yes"))
				{
					finished = true;
					theUser.setName(newUsername);
				}
			}
		}
		System.out.println("Would you like to change your password? (yes/no)");
		input = keyboard.nextLine();
		while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
		{
			System.out.println("Input invalid. Please enter yes or no");
			System.out.println("Would you like to change your password? (yes/no)");
			input = keyboard.nextLine();
		}
		if(input.equalsIgnoreCase("yes"))
		{
			finished = false;
			while(finished == false)
			{
				System.out.print("Enter your new password: ");
				newPassword = keyboard.nextLine();
				System.out.println("Is the password "+ newPassword + "correct?");
				input = keyboard.nextLine();
				while(input != "yes" || input != "no" || input != "Yes" || input != "No")
				{
					System.out.println("Input invalid. Please enter yes or no");
					System.out.println("Is the password "+ newPassword + "correct?");
					input = keyboard.nextLine();
				}
				if(input.equalsIgnoreCase("yes"))
				{
					finished = true;
					theUser.setPass(newPassword);
				}
			}
		}
		keyboard.close();
	}
	
	public boolean deleteProfile()
	{
		Scanner keyboard = new Scanner(System.in);
		String input;
		String password;
		boolean passCheck;
		int failedAttempts = 0;
		System.out.println("Are you sure you want to delete your profile? (yes/no)");
		input = keyboard.nextLine();
		while(input != "yes" || input != "no" || input != "Yes" || input != "No")
		{
			System.out.println("Input invalid. Please enter yes or no");
			System.out.println("Are you sure you want to delete your profile? (yes/no)");
			input = keyboard.nextLine();
		}
		if(input == "Yes" || input == "yes")
		{
			System.out.println("Please enter your password: ");
			password = keyboard.nextLine();
			passCheck = theUser.checkPass(password);
			while(passCheck == false && failedAttempts > 3)
			{
				failedAttempts++;
				System.out.println("Password incorrect.");
				System.out.println("Please enter your password: ");
				password = keyboard.nextLine();
				passCheck = theUser.checkPass(password);
			}
			if(failedAttempts == 3)
			{
				System.out.println("Too many failed Attempts.");
				System.out.println("Exiting Now.");
				keyboard.close();
				return false;
			}
			else
			{
				Profile[] newAccounts = new Profile[accounts.size() - 1];
				for(int i = 0, k =0; i <accounts.size();i++)
				{
					if(accounts.get(i) != theUser)
					{
						newAccounts[k] = accounts.get(i);
						k++;
					}
				}
				System.out.println("Profile Deleted.");
				keyboard.close();
				return true;
			}
		}
		else
		{
			keyboard.close();
			return false;
		}
			
	}
	
}