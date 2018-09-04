interface Payable
{
	double getPaymentAmount();
}

class Invoice implements Payable
{
	private String partNo;
	private String partDesc;
	private int quantity;
	private double price;

	public Invoice(String no, String desc, int q, double price)
	{
		this.partNo = no;
		this.partDesc = desc;
		this.quantity = q;
		this.price = price;
	}

	double getPrice()
	{
		return this.price;
	}

	int getQuantity()
	{
		return this.quantity;
	}	

	public double getPaymentAmount()
	{
		return (double)quantity*price;
	}
}

abstract class Employee implements Payable
{
	private String firstName;
	private String lastName;
	private String secNum;

	Employee(String fName, String lName, String secNum)
	{
		this.firstName = fName;
		this.lastName = lName;
		this.secNum = secNum;
	}

	void setFname(String fName)
	{
		this.firstName = fName;
	}

	void setLname(String lName)
	{
		this.lastName = lName;
	}

	String getfName()
	{
		return this.firstName;
	}

	String getlName()
	{
		return this.lastName;
	}
}

class SalariedEmployee extends Employee
{
	double weeklySalary;

	SalariedEmployee(String fName, String lName, String secNum, double weeklySalary)
	{
		super(fName, lName, secNum);
		this.weeklySalary = weeklySalary;

		if (weeklySalary < 0.0)
		{
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		else
		{
			this.weeklySalary = weeklySalary;
		}
	}

	public double getPaymentAmount()
	{
		return 2.0;
	}
}

public class Assignment_7_3_1601me01
{
	public static void main(String[] args) 
	{
		
	}	
}