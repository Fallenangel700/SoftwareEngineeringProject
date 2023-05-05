package scheduler;

import java.util.Scanner;

public class main {


	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		Controller theControl = new Controller();
		int input=0;
		String choice;
		String name;
		String name2;
		String start;
		String end;

		while(theControl.getTheUser() == null)
		{
			System.out.println("Please pick one of the following: \n");
			System.out.println("1: Sign In");
			System.out.println("2: Create New Profile");
			System.out.println("3: Exit");
			choice = keyboard.next();
			try
			{
				input = Integer.parseInt(choice);
			}
			catch (NumberFormatException e)
			{
				input = -1;
			}
			if (input < 1)
			{
				input = -1;
			}
			//if invalid, start while loop
			while (input == -1)
			{
				System.out.println("\nThat is not a valid choice. Please try again.");
				System.out.print("Enter a number between 1 and 3 :");
				choice = keyboard.next();
				try
				{
					input = Integer.parseInt(choice);
				}
				catch (NumberFormatException e)
				{
					input = -1;
				}
				if (input < 1 || input > 6)
				{
					input = -1;
				}			
			}

			if(input == 1)
			{
				boolean isLoggedIn = false;
				while(isLoggedIn == false)
				{
					System.out.println("Please enter username: ");
					name = keyboard.nextLine();
					System.out.println("Please enter password: ");
					name2 = keyboard.nextLine();
					isLoggedIn = theControl.signIn(name, name2);
				}
			}
			if(input == 2)
			{
				System.out.println("Please enter username: ");
				name = keyboard.nextLine();
				System.out.println("Please enter password: ");
				name2 = keyboard.nextLine();
				theControl.addNewProfile(name, name2);
			}
			if(input == 3)
			{
				System.out.println("Goodbye!");
				keyboard.close();
				System.exit(0);
			}
						
		}
		
		while(input != 15)
		{
			System.out.println("Please pick one of the following: \n");


			System.out.println("1: View Calender");
			System.out.println("2: Add Event to Calender");
			System.out.println("3: Edit Event in Calender");
			System.out.println("4: Remove Event from Calender");
			System.out.println("5: Display To-Do List");
			System.out.println("6: Create new To-Do List");
			System.out.println("7: Edit To-Do List");
			System.out.println("8: Delete To-Do List");
			System.out.println("9: Add Task to To-Do List");
			System.out.println("10: Remove Task from To-Do List");
			System.out.println("11: Set Reminder for Event");
			System.out.println("12: Print Calender to file");
			System.out.println("13: Edit Profile");
			System.out.println("14: Delete Profile");

			System.out.println("15: Exit");

			////////////////////////////////////////////////////////////////////
			//Get and validate input
			choice = keyboard.next();
			try
			{
				input = Integer.parseInt(choice);
			}
			catch (NumberFormatException e)
			{
				input = -1;
			}
			if (input < 1)
			{
				input = -1;
			}
			//if invalid, start while loop
			while (input == -1)
			{
				System.out.println("\nThat is not a valid choice. Please try again.");
				System.out.print("Enter a number between 1 and 15 :");
				choice = keyboard.next();
				try
				{
					input = Integer.parseInt(choice);
				}
				catch (NumberFormatException e)
				{
					input = -1;
				}
				if (input < 1 || input > 12)
				{
					input = -1;
				}			
			}
			
			System.out.print("\n");
			
			////////////////////////////////////////////////////////////////////
			//View Calender
			if(input == 1)
			{
				System.out.println("Displaying Calender. ");
				theControl.displayCalender();
			}
			
			////////////////////////////////////////////////////////////////////
			//Add Event
			else if(input == 2)
			{
				System.out.println("Adding New Event to Calender. ");
				System.out.println("Enter event name: ");
				name = keyboard.nextLine();
				System.out.println("Time must be in DDMM24HR. Example: 01 10 1300 for October 1st at 1 pm. ");
				System.out.println("Enter event start time in: ");
				start = keyboard.nextLine();
				System.out.println("Enter event end time: ");
				end = keyboard.nextLine();
				
				theControl.addEvent(name, start, end);
			}
			////////////////////////////////////////////////////////////////////
			//Edit Event
			else if(input == 3)
			{
				System.out.println("Editing Event in Calender. ");
				System.out.println("Enter event name: ");
				name = keyboard.nextLine();
				System.out.println("Enter new event name: ");
				name2 = keyboard.nextLine();
				System.out.println("Time must be in DDMM24HR. Example: 01 10 1300 for October 1st at 1 pm. ");
				System.out.println("Enter new event start time in: ");
				start = keyboard.nextLine();
				System.out.println("Enternew  event end time: ");
				end = keyboard.nextLine();
				
				theControl.editEvent(name, name2, start, end);
			}
			////////////////////////////////////////////////////////////////////
			//Remove Event
			else if(input == 4)
			{
				System.out.println("Removing Event from Calender. ");
				System.out.println("Enter event name: ");
				name = keyboard.nextLine();
				
				theControl.removeEvent(name);
			}
			////////////////////////////////////////////////////////////////////
			//Display the TO-DO lists
			else if(input == 5)
			{
				System.out.println("Displaying To-Do Lists. ");
				
				theControl.displayLists();
			}			
			
			////////////////////////////////////////////////////////////////////
			//Create new TO-DO list
			else if(input == 6)
			{
				System.out.println("Making a new To-Do Lists. ");
				System.out.println("Enter new List name: ");
				name = keyboard.nextLine();
				
				theControl.createList(name);
			}
			////////////////////////////////////////////////////////////////////
			//Edit the TO-DO lists
			else if(input == 7)
			{
				System.out.println("Editing To-Do Lists. ");
				System.out.println("Enter List name: ");
				name = keyboard.nextLine();
				
				theControl.editList(name);
			}			
			////////////////////////////////////////////////////////////////////
			//Delete TO-DO list
			else if(input == 8)
			{
				System.out.println("Deleteing To-Do List. ");
				theControl.displayLists();

				System.out.println("Enter List name to delete: ");
				name = keyboard.nextLine();
				
				theControl.deleteList(name);
			}
			////////////////////////////////////////////////////////////////////
			//Add task to TO-DO list
			else if(input == 9)
			{
				System.out.println("Adding New Task to a To-Do List. ");
				System.out.println("Enter List name: ");
				name = keyboard.nextLine();
				System.out.println("Enter Task name: ");
				name2 = keyboard.nextLine();				
				theControl.addTask(name, name2);
			}
			////////////////////////////////////////////////////////////////////
			//Edit task in TO-DO list
			else if(input == 9)
			{
				System.out.println("Editing Task in a To-Do List. ");
				System.out.println("Enter List name: ");
				name = keyboard.nextLine();			
				theControl.editTask(name);
			}
			////////////////////////////////////////////////////////////////////
			//delete task in TO-DO list
			else if(input == 10)
			{
				System.out.println("Deleting Task in a To-Do List. ");
				System.out.println("Enter List name: ");
				name = keyboard.nextLine();
				System.out.println("Enter Task name: ");
				name2 = keyboard.nextLine();				
				theControl.removeTask(name, name2);
			}
			////////////////////////////////////////////////////////////////////
			//Set Reminder
			else if(input == 11)
			{
				System.out.println("Setting a reminder for an event. ");
				System.out.println("Enter Event name: ");
				name = keyboard.nextLine();			
				theControl.setReminder(name);
			}
			////////////////////////////////////////////////////////////////////
			//Print to file
			else if(input == 12)
			{
				System.out.println("Printing to file. ");
				theControl.printToFile();
			}
			////////////////////////////////////////////////////////////////////
			//Edit Profile
			else if(input == 13)
			{
				System.out.println("Editing Profile. ");
				theControl.editProfile();
			}
			////////////////////////////////////////////////////////////////////
			//Delete Profile
			else if(input == 14)
			{
				boolean out = theControl.deleteProfile();
				if(out == true)
					input = 14;
			}
			////////////////////////////////////////////////////////////////////
			else if(input == 15)
			{
				//nothing, this ends the program.
			}
			////////////////////////////////////////////////////////////////////
		}
		System.out.println("Goodbye!");
		keyboard.close();
	}
}
