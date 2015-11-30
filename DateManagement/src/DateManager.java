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
	
	public int daysDifferent(DateManager initialDate,DateManager finalDate)
	{
		//TODO finish this
		//http://mathforum.org/library/drmath/view/66857.html
		daysFormulae(initialDate);
		daysFormulae(finalDate);
		return 0;
	}
	
	private int daysFormulae(DateManager myDate)
	{
		if(myDate.month == 1 || myDate.month == 2)
		{
			myDate.setMonth(myDate.month + 12);
			myDate.setYear(myDate.year - 1);
		}
		
		//return 365*myDate.month + Math.floor(myDate.year/4) - Math.floor(myDate.year/100) + Math.floor(myDate.year/400) + myDate.day + Math.floor((153*myDate.month+8)/5); 
		//365*year + year/4 - year/100 + year/400 + date + (153*month+8)/5
		return 1;
		
	}
	
	public String dayName(DateManager date)
	{
		//TODO finish this
		return "";
	}
}
