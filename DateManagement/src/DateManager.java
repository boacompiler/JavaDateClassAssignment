public class DateManager
{
	private int year;
	private int month;
	private int day;

	// constructor taking parameters in osi date standard order
	public DateManager(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// getters and setters
	public void setYear(int year)
	{
		this.year = year;
	}

	public int getYear()
	{
		return year;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getMonth()
	{
		return month;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public int getDay()
	{
		return day;
	}
	
	public boolean validDate(int year, int month, int day)
	{
		//TODO finish this
		return true;
	}
	
	public String toString()
	{
		//TODO more formats
		return day + "/" + month + "/"+ year;
	}
	
	public boolean leapYear()
	{
		//TODO finish this
		return true;
	}
	
	public int daysDifferent(DateManager initialDate,DateManager finalDate)
	{
		//TODO finish this
		return 0;
	}
}
