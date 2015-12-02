public class DateManager
{
	private int year;
	private int month;
	private int day;

	// constructor taking parameters in osi date standard order
	public DateManager(int year, int month, int day)
	{
		if(month > 12 || month < 1)
		{
			throw new IllegalArgumentException("Month must be between 1 and 12");
		}
		//TODO add day validation per month or use valid date, but this returns a bool so we cannot return a specialised error message
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
		boolean valid = true;
		if(month > 12 || month < 1)
		{
			valid = false;
		}
		
		return valid;
	}
	
	public String europeanString()
	{
		return day + "/" + month + "/"+ year;
	}
	public String americanString()
	{
		return month + "/" + day + "/"+ year;
	}
	public String internationalString()
	{
		return year + "/" + month + "/"+ day;
	}
	
	public boolean leapYear()
	{
		//TODO finish this
		return true;
	}
	//todo put this back to int
	public double daysDifferent(DateManager initialDate,DateManager finalDate)
	{
		//TODO finish this
		//http://mathforum.org/library/drmath/view/66857.html
		
		return Math.abs(daysFormulae(initialDate) - daysFormulae(finalDate));
	}
	
	private double daysFormulae(DateManager myDate)
	{
		System.out.println("" + myDate.month);
		if(myDate.month <= 2)
		{
			myDate.setMonth(myDate.month + 12);
			myDate.setYear(myDate.year - 1);
		}
		System.out.println("" + myDate.month);
		
		return 365*myDate.year + Math.floor(myDate.year/4) - Math.floor(myDate.year/100) + Math.floor(myDate.year/400) + myDate.day + Math.floor((153*myDate.month+8)/5); 
		//365*year + year/4 - year/100 + year/400 + date + (153*month+8)/5
		
		
	}
	
	public String dayName(DateManager date)
	{
		//TODO finish this
		return "";
	}
}
