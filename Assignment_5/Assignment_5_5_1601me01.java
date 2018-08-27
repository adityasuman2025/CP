import java.util.*;

public class Assignment_5_5_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{		
		String str_arr[] = scanner.nextLine().split("\\ ");

		int arr[] = new int[str_arr.length];	
		for(int i=0 ; i<str_arr.length; i++)
		{
			int value = Integer.parseInt(str_arr[i]);
			arr[i] = value;
		}

		Arrays.sort(arr);

		int sum = 0;
		for(int i=1; i<arr.length-1; i++)
		{
			sum += arr[i];
		}
		
		System.out.println((float)sum/(float)(arr.length-2));

	}
}