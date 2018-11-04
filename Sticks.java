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

		File f = new File("C://CompSciFiles/sticksSave.txt");

		Scanner scan2 = new Scanner(f);
		
		System.out.println(scan2.hasNext());

		PrintStream p = new PrintStream(f);

		train(scan2, rand, p, 1000);

	}
	public static void train(Scanner scan2, Random rand, PrintStream p, int times) throws FileNotFoundException
	{
		int sticks = 15;
		int sticks2 = sticks;
		
		int arr[][] = new int[sticks][3];
		int temp1[][] = new int[sticks][3];
		int temp2[][] = new int[sticks][3];
		boolean bot1=false;
		for(int i = 0; i<times; i++) 
		{
			readToArr(arr, scan2, sticks);
			blankArr(temp1);
			blankArr(temp2);
			while(sticks2>1) 
			{
				int bot1Choice=bot(rand, sticks, arr[sticks2-1]);
				sticks2-=bot1Choice;
				temp1[sticks2][bot1Choice]++;
				if(sticks2<=1) 
				{
					bot1=true;
					break;
				}
				int bot2Choice=bot(rand, sticks, arr[sticks2-1]);
				sticks2-=bot2Choice;
				temp2[sticks2][bot2Choice]++;
			}
			if(bot1) 
			{
				combindArr(arr, temp1);
				p.println(arrToStr(arr));
			}
			else 
			{
				combindArr(arr, temp2);
				p.println(arrToStr(arr));
			}
			bot1=false;
			sticks2=sticks;
		}
		print2DArr(arr);
	}
	public static void game(Scanner scan, Scanner scan2, Random rand, PrintStream p) throws FileNotFoundException

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

			botChoice=bot(rand, sticks, arr[sticks-1]);

			temp[sticks][botChoice]++;

			sticks-=botChoice+1;

			System.out.println("Computer chose "+(botChoice+1)+" and there are "+sticks+" sticks left");

			

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

	public static int bot(Random rand, int sticks, int[] row)

	{
		int one = row[0];
		int two = row[1]+one;
		int three = row[2]+two;
		int choice;
		if(sticks==2) 
		{
			return 0;
		}
		if(sticks == 3 && one == 0 && two==0 && three==0) 
		{
			return rand.nextInt(2);
		}
		if(one == 0 && two==0 && three==0) 
		{
			return rand.nextInt(3);
		}
		else 
		{
			choice=rand.nextInt(three);
		}
		if(choice<two || two==0 && choice==two) 
		{
			return 0;
		}
		else if(choice<three || three==0 && choice==three) 
		{
			return 1;
		}
		else if(choice>=three && three != 0) 
		{
			return 2;
		}
		return rand.nextInt(3);

	}

	public static void readToArr(int[][] arr, Scanner scan, int sticks) throws FileNotFoundException

	{
		for(int i = 0; i<arr.length; i++) 
		{
			for(int j =0; j<3; j++) 
			{
				arr[i][j]=scan.nextInt();
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
