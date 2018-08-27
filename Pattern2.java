import java.util.Scanner;

public class Pattern2
{
	public static void main(String [] args)
	{
	
		int a;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of pattern");
		a = s.nextInt();
		System.out.println("you have entered " + a);
		
		for(int i =a; i>0; i--)
		{
			for(int k =0; k<a+1-i; k++)
			{
				System.out.print("*");			
			}
			
			System.out.println(" ");
		}
		
		for(int x =a; x>0; x--)
		{
			for(int y = x; y>0; y--)
			{
				System.out.print("*");			
			}
			
			System.out.println(" ");
		}
	}
}
