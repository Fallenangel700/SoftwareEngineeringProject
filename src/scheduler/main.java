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

		//TODO let user make accounts
		while(theControl.getTheUser() == null)
		{
			System.out.println("Please enter username: ");
			name = keyboard.nextLine();
			System.out.println("Please enter password: ");
			name2 = keyboard.nextLine();
			theControl.signIn(name, name2);			
		}
		
		while(input != 6)
		{
			System.out.println("Please pick one of the following: \n");


			System.out.println("1: View Calender");
			System.out.println("2: Add Event to Calender");
			System.out.println("3: Create new To-Do List");
			System.out.println("4: Add Task to To-Do List");
			System.out.println("5: Exit");

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
				System.out.print("Enter a number between 1 and 6 :");
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
			//Display the TO-DO lists
			else if(input == 3)
			{
				System.out.println("Displaying To-Do Lists. ");
				
				theControl.displayLists();
			}			
			
			////////////////////////////////////////////////////////////////////
			//Create new TO-DO list
			else if(input == 4)
			{
				System.out.println("Making a new To-Do Lists. ");
				System.out.println("Enter new List name: ");
				name = keyboard.nextLine();
				
				theControl.createList(name);
			}
			////////////////////////////////////////////////////////////////////
			//Add task to TO-DO list
			else if(input == 5)
			{
				System.out.println("Adding New Task to a To-Do List. ");
				System.out.println("Enter List name: ");
				name = keyboard.nextLine();
				System.out.println("Enter Task name: ");
				name2 = keyboard.nextLine();				
				theControl.addTask(name, name2);
			}
			////////////////////////////////////////////////////////////////////
			else if(input == 6)
			{
				//nothing, this ends the program.
			}
			////////////////////////////////////////////////////////////////////
		}
		System.out.println("Goodbye!");
		keyboard.close();
	}
}
