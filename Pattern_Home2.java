import java.util.Scanner;

public class Pattern_Home2
{
	public static void main(String [] args)
	{
	
		int a;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of pattern");
		a = s.nextInt();
		System.out.println("you have entered " + a);
		
		for(int x =a; x>0; x--)
		{
			for(int y = x; y>0; y--)
			{
				int ok = 65;
				System.out.print((char)(ok+x-y));			
			}
			
			System.out.println(" ");
		}
	}
}
