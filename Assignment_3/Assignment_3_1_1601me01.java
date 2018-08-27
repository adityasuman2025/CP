import java.util.*;

public class Assignment_3_1_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String text = scanner.nextLine();
		text= text.trim().toLowerCase();

	//all upper case
		System.out.println(text.toUpperCase());

	//all capital case
		char to_array[] = text.toCharArray();
		to_array[0] = Character.toUpperCase(to_array[0]);

		for(int i=0; i<to_array.length; i++)
		{
			if(to_array[i] == ' ')
			{
				to_array[i+1] = Character.toUpperCase(to_array[i+1]);
			}
		}

		System.out.println(new String(to_array));		
	}
}