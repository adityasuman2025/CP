import java.util.Scanner;

public class Pattern_Home4
{
	public static void main(String [] args)
	{
		int a;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of pattern");
		a = s.nextInt();
		
		System.out.println("you have entered " + a);
			
		int n = 1;
		for(int i = a; i>0; i--)
		{
		//left space
			for(int k =0; k<a+1-i; k++)
			{
				System.out.print(" ");			
			}

		//center symbol				
			for(int k =i-2; k>=0; k--)
			{
				System.out.print((i*2)-1);			
			}						
			
		//center symbol				
			for(int k =i-2; k>=0; k--)
			{
				System.out.print((i*2)-1);			
			}

			System.out.println((i*2)-1);					
			n+=2;
		}		
	}
}
