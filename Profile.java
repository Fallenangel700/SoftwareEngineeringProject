package scheduler;

import java.util.LinkedList;

public class Profile {
	
	private Calendar myCalendar;
	LinkedList <List> lists;
	private String userName;
	private String password; 
	
	public Profile(String name, String pass)
	{
		this.myCalendar = new Calendar();
		this.lists = new LinkedList <List>();
		this.userName = name;
		this.password = pass;
	}
	
	public void display()
	{
		
	}

	public String getName()
	{
		return this.userName;
	}
	public bool checkPass(input pass)
	{
		return this.password == pass;
	}
}
