import java.util.Scanner;

public class Assignment_2_1_1601me01  
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of pattern");

		int n = scanner.nextInt();
		
		System.out.println("you have entered " + n);
			
		int arr[][] = new int[n][n];
 
 		for (int line = 0; line < n; line++)
		{
		//left spaces
			// for(int k=line; k<n-1; k++)
			// {
			// 	System.out.print(" ");
			// }

		//printing values
			for (int i = 0; i <= line; i++)
			{
				// First and last values in every row are 1
				if (line == i || i == 0)
				{
					arr[line][i] = 1;
				}
				else // Other values are sum of values just above and left of above
				{
					arr[line][i] = arr[line-1][i-1] + arr[line-1][i];					
				}	
				System.out.print(arr[line][i]);
			}
			System.out.println("");
		}
		
	}
}
