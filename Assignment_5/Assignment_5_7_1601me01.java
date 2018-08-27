import java.util.*;

public class Assignment_5_7_1601me01
{
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) throws Exception
	{
		System.out.print("Initial Balance: ");
		int balance = scanner.nextInt();

		System.out.print("Withdraw: ");
		int withdraw = scanner.nextInt();

		if(balance-withdraw<0)
		{
			throw new Exception("Sorry, insufficient balance! Current balance: " + balance); 
		}
		else
		{
			System.out.println("Withdrawal successful! Remaining balance: " + (int)(balance-withdraw));
		}

		// try
		// {
		// 	int a = balance-withdraw >=0;
		// }
		// catch (Exception e)
		// {
		// 	System.out.println("Sorry, insufficient balance! Current balance: " + balance);
		// }
	}
}