import java.util.*;

public class Assignment_3_3_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String text = scanner.nextLine();
		
		for(int i=0; i<text.length(); i++)
		{
			for(int j=i+1; j<=text.length(); j++)
			{
				System.out.println(text.substring(i,j));
			}
		}
	}
}