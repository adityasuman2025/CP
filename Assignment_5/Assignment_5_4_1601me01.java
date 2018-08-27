import java.util.*;

public class Assignment_5_4_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{		
		String str_arr[] = scanner.nextLine().split("\\ ");

		System.out.print("Sum should be: ");
		int sum = scanner.nextInt();

		for(int i=0 ; i<str_arr.length; i++)
		{
			int value = Integer.parseInt(str_arr[i]);
			int remainder = sum - value;

			for(int j =i+1; j<str_arr.length; j++)
			{
				if(Integer.parseInt(str_arr[j]) == remainder)
				{
					System.out.println("(" + value + ", " + remainder + ")");
				}
			}
		}
	}
}