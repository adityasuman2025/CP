import java.util.*;

public class Assignment_5_2_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String str_arr[] = scanner.nextLine().split("\\ ");

	//removing that element from the array
		int arr[] = new int[str_arr.length];
		for(int i=0 ; i<str_arr.length; i++)
		{
			arr[str_arr.length-i-1] = Integer.parseInt(str_arr[i]);
		}

	//printing the new updated array
		for(int e: arr)
		{
			System.out.print(e + " ");
		}
	}
}