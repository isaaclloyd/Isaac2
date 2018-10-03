package chp4;

import java.util.Scanner;

public class HappyBirthDay {
	final static int CURRENTMONTH = 10;
	final static int CURRENTDAY = 3;
	final static int CURRENTYEAR = 2008;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println(daysTillNextBDay(9, 10));
	}
	
	public static int daysTillNextBDay(int month, int day)
	{
		boolean nextYear = false;
		if(month<CURRENTMONTH){nextYear=true;}
		else if(month==CURRENTMONTH && day<CURRENTDAY){nextYear=true;}
		else if(month==CURRENTMONTH && day==CURRENTDAY){System.out.println("Happy Birthday");}
		
		if(nextYear==false)
		{
			return absoluteDay(month, day)-absoluteDay(CURRENTMONTH, CURRENTDAY);
		}
		return 365-(absoluteDay(CURRENTMONTH, CURRENTDAY)-absoluteDay(month, day));
		
		
	}
	
	public static int absoluteDay(int month, int day)
	{
		int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int result = 0;
		for(int i = 0; i<month-1; i++)
		{
			result+=daysInMonth[i];
		}
		result+=day;
		return result;
	}
	 
}
