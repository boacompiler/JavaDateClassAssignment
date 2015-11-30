public class Main
{

	/**
	 * @param args
	 */
	static DateManager dm;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		dm = new DateManager(1994,Month.November.getValue(),1);
		System.out.println(dm.toString());
	}

}
