import java.util.*;

public class Assignment_5_1_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String str_arr[] = scanner.nextLine().split("\\ ");

		System.out.print("Remove:");
		int remove = scanner.nextInt();

	//removing that element from the array
		List<Integer> list = new ArrayList<>();
		for(int i=0 ; i<str_arr.length; i++)
		{
			int value = Integer.parseInt(str_arr[i]);

			if(value != remove)
			{
				list.add(value);
			}
		}

	//printing the new updated array
		for(int e: list)
		{
			System.out.print(e + " ");
		}
	}
}