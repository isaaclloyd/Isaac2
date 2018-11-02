package chp7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Sticks {
	public static void main(String[] args) throws FileNotFoundException
	{
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		File f = new File("C:/Files/sticks.txt");
		Scanner scan2 = new Scanner(f); 	
		PrintStream p = new PrintStream(f);
		game(scan, scan2, rand, p);
	}
	public static void game(Scanner scan, Scanner scan2, Random rand, PrintStream p)
	{
		int sticks = 15;
		int arr[][] = new int[sticks][3];
		readToArr(arr, scan2, sticks);
		print2DArr(arr);
		int temp[][] = new int[sticks][3];
		blankArr(temp);
		int botChoice=0;
		int humanChoice=0;
		boolean humanWin=false;
		int i = 0;
		
		while(sticks>1)
		{
			System.out.println("There are "+sticks+" sticks");
			sticks-=human(scan, sticks);
			if(sticks==1)
			{
				humanWin=true;
				break;
			}
			botChoice=bot(rand, sticks);
			temp[sticks][botChoice-1]++;
			sticks-=botChoice;
			System.out.println("Computer chose "+botChoice+" and there are "+sticks+" sticks left");
			
			if(sticks==1)
			{
				combindArr(arr, temp);
				break;
			}
			i++;
			
		}
		String str = arrToStr(arr);
		p.println(str);
		
		if(humanWin)
		{
			System.out.println("You win");
		}
		else
		{
			System.out.println("You lose");
		}
		print2DArr(arr);
	}
	public static int human(Scanner scan, int sticks)
	{
		int result=4;
		while(result>3){
		System.out.println("how many sticks do you want to take? (1-3, don't take the last one)");
			result=scan.nextInt();
			if(sticks-result<=0)
			{
				result=4;
			}
		}
		return result;
	}
	public static int bot(Random rand, int sticks)
	{
		if(sticks==3)
		{
			return rand.nextInt(2)+1;
		}
		if(sticks==2)
		{
			return rand.nextInt(1)+1;
		}
		return rand.nextInt(3)+1;
		
	}
	public static void readToArr(int[][] arr, Scanner scan, int sticks)
	{
		for(int i=0; i<sticks; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(scan.hasNextInt()){
					arr[i][j]=scan.nextInt();
					System.out.println(arr[i][j]);
				}
			}
		}
	}
	public static String arrToStr(int[][] arr)
	{
		String result = "";
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				result+=arr[i][j]+" ";
			}
		}
		return result.substring(0, result.length()-1);
	}
	public static void blankArr(int[][] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<arr[0].length; j++)
			{
				arr[i][j]=0;
			}
		}
	}
	public static void combindArr(int[][] arr, int[][] temp)
	{
		for(int i =0; i<arr.length; i++)
		{
			for(int j =0; j<arr[0].length; j++)
			{
				arr[i][j]+=temp[i][j];
			}
		}
	}
	public static void print2DArr(int[][] arr)
	{
		for(int i =0; i<arr.length; i++)
		{
			System.out.print("[ ");
			for(int j =0; j<arr[i].length; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("]");
		}
	}
}
