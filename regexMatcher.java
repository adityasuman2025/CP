import java.util.Scanner;

public class regexMatcher 
{    
	public static Scanner Input = new Scanner(System.in);
    public static void checker(String Regex_Pattern)
    {   
        String Test_String = Input.nextLine();
       	System.out.println(Test_String.matches(Regex_Pattern));
    }   

    public static void main(String[] args) 
    {
    	checker("^[^0-9][^aeiou][^bcDF][^\\r\\n\\t\\f\\ ][^AEIOU][^\\.\\,]$"); // Use \\ instead of using \ 
    }
}
