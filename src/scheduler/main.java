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
		String desc;
		String start;
		String end;

		//TODO sign user into profile

		//DDMM24HR
		while(input != 6)
		{
			System.out.println("Please pick one of the following: \n");


			System.out.println("1: View Calender");
			System.out.println("2: Add Event to Calender");
			System.out.println("3: Create new To-Do List");
			System.out.println("4: Add Task to To-Do List");

			System.out.println("5:");
			System.out.println("6 Exit");

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
			//Admit a patient
			if(input == 1)
			{
				System.out.println("Enter event name: ");
				name = keyboard.nextLine();
				System.out.println("Enter event start time: ");
				start = keyboard.nextLine();
				System.out.println("Enter event end time: ");
				end = keyboard.nextLine();
				
				theControl.addEvent(name, start, end);
			}
			
			////////////////////////////////////////////////////////////////////
			else if(input == 2)
			{

			}
			
			
			////////////////////////////////////////////////////////////////////
			else if(input == 3)
			{
			}

			
			////////////////////////////////////////////////////////////////////
			else if(input == 4)
			{
			}
			////////////////////////////////////////////////////////////////////
			else if(input == 5)
			{
			}
			////////////////////////////////////////////////////////////////////
			// Exit Program
			else if(input == 6)
			{
				//nothing, this ends the program.
			}
		}
		System.out.println("Goodbye!");
		keyboard.close();
	}
}
