package scheduler;

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
	
	public void display()
	{
		for(int i=0;i<this.days.length;i++)
		{
			for (int j=0;i<this.days[i].length;i++)
			{
				this.days[i][j].display(); 
			}
		}
	}

}
