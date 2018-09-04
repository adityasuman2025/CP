import java.util.Scanner;

public class Assignment_7_4_1601me01 
{
	static void get_money(int shift, int rounds)
	{
		double price = 2.0; 
		if(shift == 1)
		{
			price = 1.5;
		}

		double earning = (double)rounds*price;
		System.out.println("Total earning: " + Double.toString(earning));
	}

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.print("Enter the shift, 0 for morning and 1 for evening: ");		
		int shift = scanner.nextInt();

		System.out.println("");
		System.out.print("Enter number of rounds: ");
		int rounds = scanner.nextInt();

		get_money(shift, rounds);
	}	
}