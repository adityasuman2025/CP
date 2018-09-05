class Account
{
	String name;
	String accNum;
	String type;
	double balance;

	Account(String name, String accNum, String type, double balance)
	{
		this.name = name;
		this.accNum = accNum;
		this.type = type;
		this.balance = balance;
	}

	void checkBalance()
	{
		System.out.println("Balance: " + Double.toString(this.balance));
	}

	void deposit(double amount)
	{
		System.out.println("Deposited: " + Double.toString(amount));
		this.balance += amount;

		System.out.println("Updated Balance: " + Double.toString(this.balance));
	}

	void withdraw(double amount)
	{
		System.out.println("Withdrawn Amount: " + Double.toString(amount));
		this.balance -= amount;

		System.out.println("Updated Balance: " + Double.toString(this.balance));
	}

	void accDetails()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Account Number: " + this.accNum);
		System.out.println("Account Type: " + this.type);
	}
}

class SavAcc extends Account
{
	SavAcc(String name, String accNum, double balance)
	{
		super(name, accNum, "Saving", balance);
	}

	double Irate = 0.04;

	void calcInterest(int month)
	{
		double interestAmmount = (this.balance*Irate*month)/12;

		System.out.println("Interest Amount: " + Double.toString(interestAmmount));

		this.balance +=interestAmmount;
	}
}

class CurAcc extends Account
{
	double fixAmount = 1000;
	double serCharge = 250;

	CurAcc(String name, String accNum, double balance)
	{
		super(name, accNum, "Current", balance);
	}

	void withdraw(double amount)
	{
		System.out.println("Withdrawn Amount: " + Double.toString(amount));
		this.balance -= amount;

		if(this.balance < this.fixAmount)
		{
			System.out.println("Your left balance is bellow minimum required balance (" + Double.toString(fixAmount) + "), so extra service charge " + Double.toString(serCharge) + " is deducted from your account.");

			this.balance -= this.serCharge;
		}

		System.out.println("Updated Balance: " + Double.toString(this.balance));
	}
}

public class Assignment_7_5_1601me01
{
	public static void main(String[] args) 
	{
	//creating a saving account		
		SavAcc sav1 = new SavAcc("Rohang", "108955465", 50000.0);

		sav1.accDetails();
		sav1.checkBalance();

		sav1.deposit(1000);
		sav1.withdraw(2000);

		sav1.calcInterest(1);
		sav1.checkBalance();

		System.out.println();
	//creating a current account		
		CurAcc curr1 = new CurAcc("Aditya", "489654596465", 5000.0);

		curr1.accDetails();
		curr1.checkBalance();

		curr1.deposit(1000);
		curr1.withdraw(5100);
	}	
}