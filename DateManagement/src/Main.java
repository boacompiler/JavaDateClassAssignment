
public class Main
{

	/**
	 * @param args
	 */
	static DateManager dm;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		dm = new DateManager(2008,2,29);//Month.January is an existing month class
		System.out.println(dm.dayName(new DateManager(2000,3,1)));//2005,3,5 returns -1 Sunday = 0
		//System.out.println(dm.validDate(2007, 2, 29));
		//System.out.println(dm.daysDifferent(new DateManager(1994,11,4), new DateManager(1994,11,1)));
	}

}
