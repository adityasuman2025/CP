import java.util.*;

public class Assignment_3_12_1601me01
{
//insert character into the string function
	public static void insertChar(String string, char ch, int pos)
	{
		//System.out.println(String.valueOf(ch));
		String result = new String();

		if(pos >string.length()-1)
		{
			result =  string + String.valueOf(ch);
		}
		else if(pos == 0)
		{
			result = "don't be so smart!! start choosing position from 1";
		}
		else
		{
			result = string.substring(0, pos-1) + String.valueOf(ch) + string.substring(pos-1, string.length());
		}

		System.out.println(result);
	}

//delete character from the string function
	public static void deltChar(String string, int pos)
	{
		//System.out.println(String.valueOf(ch));
		String result = new String();

		if(pos >string.length())
		{
			result =  string;
		}
		else if(pos == 0)
		{
			result = "don't be so smart!! start choosing position from 1";
		}
		else
		{
			result = string.substring(0, pos-1) + string.substring(pos, string.length());
		}

		System.out.println(result);
	}

//count vowels and consonants
	public static void countChar(String string)
	{
		int vowels =0;
		int consonants = 0;

		for(int i=0; i<string.length(); i++)
		{
			char ch = string.charAt(i);

			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
			{
				vowels++;
			}
			else
			{
				consonants++;
			}
		}	

		System.out.println("Number of vowels: " + String.valueOf(vowels));
		System.out.println("Number of consonants: " + String.valueOf(consonants - 1));
	}

//the main function	
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
	//showing operations to the user
		System.out.print("Enter the String: ");
		String text = scanner.nextLine();
				
		System.out.println("1. Insert a character in any position of given string.");	
		System.out.println("2. Delete a character in any position of given string.");	
		System.out.println("3. Count the number of vowels and Consonants.");	

		System.out.print("Choose the operation to perform:");	
		int action = scanner.nextInt();

	//on choosing an action to perform
		if(action ==1) //choosed to insert a character in the string
		{
			System.out.print("Enter the character: ");
			char ch = scanner.next().charAt(0);

			System.out.print("Enter the position: ");
			int position = scanner.nextInt();
				
		//doing the operation
			insertChar(text, ch, position);
		}
		else if(action ==2) //choosed to delete a character in the string
		{
			System.out.print("Enter the position to delete from the string: ");
			int position = scanner.nextInt();

			deltChar(text, position);
		}
		else if(action ==3)
		{
			countChar(text);
		}
		else
		{
			System.out.println("Choose from 1 to 3.");
		}

	}
}