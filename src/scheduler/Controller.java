package scheduler;
/* 
 * 
 */
import java.util.Scanner;

public class Controller 
{
	private Profile theUser = null;
	private Profile[] accounts;
	
	public Controller()
	{
		accounts = new Profile[0];
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
		Profile newAccounts[] = new Profile[accounts.length+1];
		for(int i = 0; i < accounts.length; i++)
			newAccounts[i] = accounts[i];
		newAccounts[accounts.length+1] = newProfile;
		accounts = newAccounts;
		theUser = newProfile;
	}
	
	public void displayCalender()
	{
		theUser.getMyCalender().display();
	}
	
	public void addEvent(Day day, String name, int start, int end)
	{
		theUser.getMyCalender().addEvent(day, name, start, end);
	}
	
	public void editEvent(Day day, String oldName, String newName, int start, int end)
	{
		theUser.getMyCalender().editEvent(day, oldName, newName, start, end);
	}
	
	public void removeEvent(Day day, String name)
	{
		theUser.getMyCalender().removeEvent(day, name);
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

	public void removeReminder(String eventName){
		theUser.getMyCalender().removeReminder();
	}
	
	public void printToFile()
	{
		theUser.getMyCalender().printToFile();
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
		while(input != "yes" || input != "no" || input != "Yes" || input != "No")
		{
			System.out.println("Input invalid. Please enter yes or no");
			System.out.println("Would you like to change your username? (yes/no)");
			input = keyboard.nextLine();
		}
		if(input == "yes" || input == "Yes")
		{
			finished = false;
			while(finished == false)
			{
				System.out.print("Enter your new username: ");
				newUsername = keyboard.nextLine();
				System.out.println("Is the username "+ newUsername + "correct?");
				input = keyboard.nextLine();
				while(input != "yes" || input != "no" || input != "Yes" || input != "No")
				{
					System.out.println("Input invalid. Please enter yes or no");
					System.out.println("Is the username "+ newUsername + "correct?");
					input = keyboard.nextLine();
				}
				if(input == "yes" || input == "Yes")
				{
					finished = true;
					theUser.setName(newUsername);
				}
			}
		}
		System.out.println("Would you like to change your password? (yes/no)");
		input = keyboard.nextLine();
		while(input != "yes" || input != "no" || input != "Yes" || input != "No")
		{
			System.out.println("Input invalid. Please enter yes or no");
			System.out.println("Would you like to change your password? (yes/no)");
			input = keyboard.nextLine();
		}
		if(input == "yes" || input == "Yes")
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
				if(input == "yes" || input == "Yes")
				{
					finished = true;
					theUser.setPass(newPassword);
				}
			}
		}
		keyboard.close();
	}
	
	public void deleteProfile()
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
			}
			else
			{
				Profile[] newAccounts = new Profile[accounts.length - 1];
				for(int i = 0, k =0; i <accounts.length;i++)
				{
					if(accounts[i] != theUser)
					{
						newAccounts[k] = accounts[i];
						k++;
					}
				}
				System.out.println("Profile Deleted.");
			}
		}
		keyboard.close();
	}
	
}