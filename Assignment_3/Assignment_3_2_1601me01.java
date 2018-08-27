import java.util.*;

public class Assignment_3_2_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String text1 = scanner.nextLine();
		String text2 = scanner.nextLine();

		if(text1.compareTo(text2)>=1)
		{
			System.out.println("First string is greater");
		}
		else
		{
			System.out.println("Second string is greater");
		}
	}
}