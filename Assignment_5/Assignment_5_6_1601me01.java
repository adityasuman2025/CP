import java.util.*;

public class Assignment_5_6_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]) throws Exception
	{		
		System.out.print("Enter size of the array: ");
		int n = Integer.parseInt(scanner.nextLine());
		
		String str_arr[] = scanner.nextLine().split("\\ ");

		int arr[] = new int[n];	
		for(int i=0 ; i<str_arr.length; i++)
		{
			int value = Integer.parseInt(str_arr[i]);
			try
			{
				arr[i] = value;
			}
			catch (IndexOutOfBoundsException e)
			{
				System.out.println("Exception: You have entered more values than the define size of index");
			}
		}
	}
}