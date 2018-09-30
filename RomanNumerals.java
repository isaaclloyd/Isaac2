package chp4;
import java.util.Scanner;
public class RomanNumerals {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        final int[] VALUES = {1000, 500, 100, 50, 10, 5, 1};
        final String[] CHARACTERS = {"M", "D", "C", "L", "X", "V", "I"};
        printRomanNumerals(scan, CHARACTERS, VALUES);
    }
    public static void printRomanNumerals(Scanner scan, String[] CHARACTERS, int[] VALUES)
    {
        
    	System.out.println("Enter a number: ");
        int num = scan.nextInt();
        
        String roman = "";
        for (int i = 0; i < VALUES.length; i++) 
        {
        	if(Integer.toString(num).substring(0, 1).equals("4") && i!=0) 
        	{
        		roman += CHARACTERS[CHARACTERS.length-Integer.toString(num).length()*2+1]+CHARACTERS[CHARACTERS.length-Integer.toString(num).length()*2];
        		num -= 4*Math.pow(10, Integer.toString(num).length()-1);
        	}
        	else if(Integer.toString(num).substring(0, 1).equals("4") && i==0 && num<4000) 
        	{
        		roman += CHARACTERS[CHARACTERS.length-Integer.toString(num).length()*2+1]+CHARACTERS[CHARACTERS.length-Integer.toString(num).length()*2];
        		num -= 4*Math.pow(10, Integer.toString(num).length()-1);
        	}
        	if(i!=0)
        	{
        		if(num>=VALUES[i-1]-100/(Math.pow(10, i/2))) {
		        	while (num >= VALUES[i]) 
		        	{ 
		        		if(Integer.toString(VALUES[i]).substring(0, 1).equals("5"))
		        		{
			        		roman += CHARACTERS[i+1] + CHARACTERS[i-1];
			                num -= VALUES[i-1]-VALUES[i+1];;
		        		}
		        		if(Integer.toString(VALUES[i]).substring(0, 1).equals("1")) 
		        		{
		        			roman += CHARACTERS[i] + CHARACTERS[i-1];
			                num -= VALUES[i-1]-VALUES[i];
		        		}
		            }
	        	}
        	}
        	while (num >= VALUES[i]) 
        	{ 
        		roman += CHARACTERS[i];
                num -= VALUES[i];
            }
        }
        System.out.println(roman);
    }
    
    
}


