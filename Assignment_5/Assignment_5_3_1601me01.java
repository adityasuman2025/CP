import java.util.*;

public class Assignment_5_3_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{		
		System.out.print("Array 1:");
		String str_arr1[] = scanner.nextLine().split("\\ ");

		System.out.print("Array 2:");
		String str_arr2[] = scanner.nextLine().split("\\ ");

		HashMap<String, Integer> map = new HashMap<>();
		for(String e : str_arr2)
		{
			map.put(e, 1);
		}

		System.out.print("Common elements: ");
		for(int i=0; i<str_arr1.length; i++)
		{
			String value = str_arr1[i];

			if(map.containsKey(value))
			{
				System.out.print(value + " ");
			}
		}
	}
}