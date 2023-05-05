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
		// Scanner keyboard = new Scanner(System.in);
		// int input;
		// int startMonth, startDay, endMonth, endDay;
		// System.out.println("1: January");
		// System.out.println("2: February");
		// System.out.println("3: March");
		// System.out.println("4: April");
		// System.out.println("5: May");
		// System.out.println("6: June");
		// System.out.println("7: July");
		// System.out.println("8: August");
		// System.out.println("9: September");
		// System.out.println("10: October");
		// System.out.println("11: November");
		// System.out.println("12: December");
		// System.out.println("13: View Entire Calendar");
		// System.out.println("Enter the number according to the starting month or view entire Calendar: ");
		// input = keyboard.nextInt();
		// while(input < 1 || input > 13)
		// {
		// 	System.out.println("Input invalid. Please enter a number 1 - 13");
		// 	input = keyboard.nextInt();
		// }
		// if(input != 13)
		// {
		// 	startMonth = input-1;
		// 	System.out.println("Enter the starting day: ");
		// 	input = keyboard.nextInt();
		// 	if(input > theUser.getMyCalender().days[startMonth].length || input < 1)
		// 	{
		// 		while(input > theUser.getMyCalender().days[startMonth].length || input < 1)
		// 		{
		// 			System.out.println("Input invalid. Enter starting day: ");
		// 			input = keyboard.nextInt();
		// 		}
		// 	}
		// 	startDay = input-1;
		// 	System.out.println("1: January");
		// 	System.out.println("2: February");
		// 	System.out.println("3: March");
		// 	System.out.println("4: April");
		// 	System.out.println("5: May");
		// 	System.out.println("6: June");
		// 	System.out.println("7: July");
		// 	System.out.println("8: August");
		// 	System.out.println("9: September");
		// 	System.out.println("10: October");
		// 	System.out.println("11: November");
		// 	System.out.println("12: December");
		// 	System.out.println("Enter the number according to the end month: ");
		// 	input = keyboard.nextInt();
		// 	while(input < startMonth+1 || input > 12)
		// 	{
		// 		System.out.println("Input invalid. Please enter a number 1 - 12");
		// 		input = keyboard.nextInt();
		// 	}
		// 	endMonth = input-1;
		// 	System.out.println("Enter the ending day: ");
		// 	input = keyboard.nextInt();
		// 	if(input > theUser.getMyCalender().days[endMonth].length || input < 1 || (startMonth == endMonth && input<startDay+1))
		// 	{
		// 		while(input > theUser.getMyCalender().days[startMonth].length || input < 1 || (startMonth == endMonth && input<startDay+1))
		// 		{
		// 			System.out.println("Input invalid. Enter ending day: ");
		// 			input = keyboard.nextInt();
		// 		}
		// 	}
		// 	endDay = input-1;
		// 	theUser.getMyCalender().display(startMonth,startDay,endMonth,endDay);
		// }
		// else
		// {
		// 	theUser.getMyCalender().display(0,0,11,30);
		// }
		// keyboard.close();
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
			while(input != "yes" || input != "no" || input != "Yes" || input != "No")
			{
				System.out.println("Input invalid. Please enter yes or no");
				System.out.println("Would you like to change your list name? (yes/no)");
				input = keyboard.nextLine();
			}
			if(input == "yes" || input == "Yes")
			{
				System.out.println("Please enter the new list name: ");
				newListName = keyboard.nextLine();
				theUser.getLists().get(match).setListName(newListName);
			}
			while(finished == false)
			{
				System.out.println("Would you like to delete a task? (yes/no)");
				input = keyboard.nextLine();
				while(input != "yes" || input != "no" || input != "Yes" || input != "No")
				{
					System.out.println("Input invalid. Please enter yes or no");
					System.out.println("Would you like to delete a task? (yes/no)");
					input = keyboard.nextLine();
				}
				if(input == "yes" || input == "Yes")
				{
					int taskNum;
					theUser.getLists().get(match).display();
					System.out.print("Enter task number to delete: ");
					taskNum = keyboard.nextInt();
					while(taskNum > theUser.getLists().get(match).getSize())
					{
						System.out.print("Input invalid. Please enter a task number to delete: ");
						input = keyboard.nextLine();
					}
					theUser.getLists().get(match).removeTask(theUser.getLists().get(match).getTask(taskNum));
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

	public void addReminder(String start, String end, String time){
		theUser.getMyCalender().addReminder(start, end, time);
	}

	public void setReminder(String start, String end, String newTime)
	{
		//theUser.getMyCalender().setReminder();
	}

	public void removeReminder(String start, String end){
		//theUser.getMyCalender().removeReminder();
	}
	
	public void printToFile()
	{
		//theUser.getMyCalender().printToFile();
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