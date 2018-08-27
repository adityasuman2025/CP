import java.util.Scanner;

public class Assignment_3_6_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		System.out.print("Enter a String: ");
		String text1 = scanner.nextLine();

	//reversing the string
		char rev_arr[] = new char[text1.length()];
		for(int i= text1.length()-1, j=0; i>=0; i--, j++)
		{
			rev_arr[j] = text1.charAt(i);
		}

		String rev_str = new String(rev_arr);

	//checking palindrome
		boolean isPalindrome = true;
		for(int j=0; j<text1.length(); j++)
		{
			if(text1.charAt(j) != rev_str.charAt(j))
			{
				isPalindrome = false;
				break;
			}
		}

	//showing result in the output
		System.out.println("Reverse string: " + rev_str);

		if(isPalindrome)
		{
			System.out.println("Is Palindrome: Yes");
		}
		else
		{	
			System.out.println("Is Palindrome: No");
		}

		System.out.println("String length: " + text1.length());
	}
}