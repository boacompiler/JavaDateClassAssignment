import java.time.DayOfWeek;
import java.time.Month;

public class Main
{

	/**
	 * @param args
	 */
	static DateManager dm;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		dm = new DateManager(1994,12,12);//Month.January is an existing month class
		//System.out.println(dm.dayName(new DateManager(1994,8,24)));//2005,3,5 returns -1
		System.out.println("");
		//System.out.println(dm.daysDifferent(new DateManager(1994,11,4), new DateManager(1994,11,1)));
	}

}
