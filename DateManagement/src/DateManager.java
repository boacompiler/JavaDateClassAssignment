import java.time.DayOfWeek;

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
	
	private double daysFormulae(DateManager date)
	{
		//TODO clean
		//System.out.println("" + date.month);
		if(date.month <= 2)
		{
			date.setMonth(date.month + 12);
			date.setYear(date.year - 1);
		}
		//System.out.println("" + date.month);
		
		return 365*date.year + Math.floor(date.year/4) - Math.floor(date.year/100) + Math.floor(date.year/400) + date.day + Math.floor((153*date.month+8)/5); 
		//365*year + year/4 - year/100 + year/400 + date + (153*month+8)/5
		
		
	}
	
	public String dayName(DateManager date)
	{
		//TODO finish this
		//d= ([2.6*M -0.2] + D + Y + [Y/4] + [C/4] -2*C) modulo 7
		int d = date.day;
		int m = 0;
		int c = Integer.parseInt(String.valueOf(date.year).substring(0, 2));//2 most significant digits of year
		int y = Integer.parseInt(String.valueOf(date.year).substring(2, 4));//2 least significant digits of year
		
		if(date.month <= 2)
		{
			m = date.month + 10; // TODO +1 error gaahahaha
			date.setYear(date.year - 1);
		}
		else
		{
			m = date.month - 2;//TODO march = 1
		}
		
		double day = Math.round(((2.6*m-0.2)+d+y+(y/4)+(c/4)-2*c)%7);
		
		//return DayOfWeek.values()[(int)day-1].name(); // TODO existing libraries ok?
		return day + "";
	}
}
