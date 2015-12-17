public class DateManager
{
	private int year;
	private int month;
	private int day;

	//we could import standard java classes to return the names of weekdays and months, but using private arrays allows our class to stand alone
	//this also allows for the weekdays to be presented compliant with Zeller's congruence
	private static int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};// 0 = January
	private static String[] weekDayName = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
	
	public DateManager()
	{
		//Empty constructor for when you don't want a date
		//TODO is this overriding? mention it. also mention, calling the class within itself
	}
	
	// constructor taking parameters in ISO date standard order
	public DateManager(int year, int month, int day)
	{
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}

	// getters and setters
	//validation is handled in the setters
	public void setYear(int year)
	{
		if(year < 1)
		{
			throw new IllegalArgumentException("Year must be above 0");
		}
		this.year = year;
	}

	public int getYear()
	{
		return year;
	}

	public void setMonth(int month)
	{
		if(month > 12 || month < 1)
		{
			throw new IllegalArgumentException("Month must be between 1 and 12");
		}
		this.month = month;
	}

	public int getMonth()
	{
		return month;
	}

	public void setDay(int day)
	{
		if(month == 2 && ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))))
		{
			if(day > 29)
			{
				throw new IllegalArgumentException("Too many days in the month");
			}
		}
		else
		{
			if(day > daysInMonth[month - 1])
			{
				throw new IllegalArgumentException("Too many days in the month");
			}
		}
		this.day = day;
	}

	public int getDay()
	{
		return day;
	}
	//Returns true or false
	//requires int parameters instead of a datemanager class because the date manager class constructor will throw an error at any incorrect date trying to be passed
	public boolean validDate(int year, int month, int day)
	{
		boolean valid = true;
		if(year < 1)
		{
			valid = false;
		}
		else if(month > 12 || month < 1)
		{
			valid = false;
		}
		else if(month == 2 && ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))))
		{
			if(day > 29)
			{
				valid = false;
			}
		}
		else
		{
			if(day > daysInMonth[month - 1])
			{
				valid = false;
			}
		}
		return valid;
	}
	
	public String europeanString()
	{
		return day + "/" + month + "/"+ year;
	}
	public String europeanString(char separator) //overload allows for a default parameter to be used or a custom separator
	{
		return day + "" + separator + month + "" + separator + year;
	}
	public String americanString()
	{
		return month + "/" + day + "/"+ year;
	}
	public String americanString(char separator)
	{
		return month + "" + separator + day + "" + separator + year;
	}
	public String internationalString()
	{
		return year + "/" + month + "/"+ day;
	}
	public String internationalString(char separator)
	{
		return year + "" + separator + month + "" + separator + day;
	}
	
	public boolean leapYear(int year)
	{
		//TODO Test this
		return  (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
	public int daysDifferent(DateManager initialDate,DateManager finalDate)
	{
		//TODO clean this
		//http://mathforum.org/library/drmath/view/66857.html
		//Math.abs provides an absolute value, insuring you will never get a negative number of days
		return (int)Math.round(Math.abs(daysFormulae(initialDate) - daysFormulae(finalDate)));
	}
	//This function is private because it is only used internally during the calculation of daysDifferent
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
		//Restarting with a basic implementation of Zeller's congruence with software as described on this page https://en.wikipedia.org/wiki/Zeller's_congruence
		int h;
		int q = date.day; 
		int m = date.month; // march = 3
		int k = date.year;// % 100;
		int j = date.year;// / 100;
		
		if( m <= 2)
		{
			m += 12; //January and February are treated as months 13 and 14 of the previous year
			k = j -= 1;
		}
		
		k %= 100;//Modulus of 100 gives us the first 2 significant digits
		j /= 100;//integer division of 100 gives us the last 2 significant digits
		
		//TODO remove testing stuff
		h = (q+((13*(m+1))/5)+k+(k/4)+(j/4)+5*j)%7;
		
		//System.out.println("h: "+h+", q: "+q+", m: "+m+", k: "+k+", j: "+j);
		//System.out.println(date.year);
		return weekDayName[h];
	}
}