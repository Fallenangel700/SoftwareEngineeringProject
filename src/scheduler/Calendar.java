package scheduler;

import javax.lang.model.util.ElementScanner14;

public class Calendar {
	
	public Day [] [] days;
	
	public Calendar()
	{
		this.days= new Day [12] [];
		this.days[0]= new Day[31];
		this.days[1]= new Day[28];
		this.days[2]= new Day[31];
		this.days[3]= new Day[30];
		this.days[4]= new Day[31];
		this.days[5]= new Day[30];
		this.days[6]=new Day[31];
		this.days[7]=new Day[31];
		this.days[8]=new Day[30];
		this.days[9]= new Day[31];
		this.days[10]= new Day[30];
		this.days[11]=new Day [31];
		//setting the amount of days in each month
		
	}
	
	public void display(int startMonth, int startDay, int endMonth, int endDay)
	{
		for(int i=startMonth;i<=endMonth;i++)
		{
			if(i == startMonth)
			{
				for (int j=startDay;j<this.days[startMonth].length;j++)
				{
					System.out.println("Schedule for " + i+1+"/"+ j+1 +":");
					if(this.days[i][j]!=null)
						this.days[i][j].display();
					else
						System.out.println("Nothing scheduled for today."); 
				}
			}
			else if(i == endMonth)
			{
				for (int j=0;j<endDay;j++)
				{
					System.out.println("Schedule for " + i+1+"/"+ j+1 +":");
					if(this.days[i][j]!=null)
						this.days[i][j].display();
					else
						System.out.println("Nothing scheduled for today.");
				}
			}
			else if(startMonth == endMonth)
			{
				for (int j=startDay;j<endDay;j++)
				{
					System.out.println("Schedule for " + i+1+"/"+ j+1 +":");
					if(this.days[i][j]!=null)
						this.days[i][j].display();
					else
						System.out.println("Nothing scheduled for today.");
				}
			}
			else
			{
				for (int j=0;j<this.days[i].length;j++)
				{
					System.out.println("Schedule for " + i+1+"/"+ j+1 +":");
					if(this.days[i][j]!=null)
						this.days[i][j].display();
					else
						System.out.println("Nothing scheduled for today.");
				}
			}
		}
	}

	// public void addEvent(Day day, String name, String start, String end)

	// public void editEvent(Day day, oldName, newName, start, end)

	// public void removeEvent(Day day, name)
}
