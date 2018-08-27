import java.util.Scanner;

public class Assignment_2_4_1601me01
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
			for(int k =i-2; k>=0; k--)
			{
				System.out.print(" ");		
			}
			
		//center symbol								
			for(int k =0; k<n; k++)
			{
				if(k<=a-i)
				{
					System.out.print(k+1);
				}
				else
				{
					int h = a-i;
					System.out.print((2*h)-k+1);
				}
			}
							
			System.out.println("");					
			n+=2;
		}
		
	}
}
