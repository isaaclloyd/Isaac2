package chp4;



public class PascalsTriangle {
	
	public static void main(String[] args)
	{
		printTriangle(findTriangle(15));
	}

	public static void printTriangle(int[][] triangle)
	{
		int rows = triangle.length;
		
		for(int i = 0; i<triangle.length; i++)
		{
			printSpace(i, rows);
			for(int j = 0; j<triangle[i].length; j++)
			{
				for(int k = 1; k<=4-Integer.toString(triangle[i][j]).length(); k++) {System.out.print(" ");}
				System.out.print(triangle[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static int[][] findTriangle(int rows)
	{
		int[][] triangle = new int[rows][];
		triangle[0]=new int[1];
		triangle[0][0]=1;
		triangle[1]=new int[2];
		triangle[1][0]=1;
		triangle[1][1]=1;

		for(int i=2; i<rows; i++)
		{
			triangle[i]=new int[i+1];
			triangle[i][0]=1;
			
			for(int j=1; j<i; j++)
			{
				triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
			}

			triangle[i][i]=1;
		}
		return triangle;
	}

	public static void printSpace(int row, int rows)
	{
		for(int i = 1; i<=rows-row-1; i++)
		{
			System.out.print("   ");
		}
		if(row!=rows)
		{
			System.out.print("  ");
		}
	}
}
