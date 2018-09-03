import java.util.*;

class Customer
{
	String name;
	boolean member = false;
	String memberType;

	Customer(String name)
	{
		this.name = name;
	}

//getters and setters
	String get_name()
	{
		return this.name;
	}

	String getMemberType()
	{
		return this.memberType;
	}

	boolean isMember()
	{
		return this.member;
	}

	void setMember(boolean mem)
	{
		this.member = mem;
	}

	void setMemberType(String type)
	{
		this.memberType = type;
	}
}

class Visit
{
	Customer customer;
	Date date;
	double serviceExpense;
	double productExpense;

	Visit(String name, Date date)
	{
		this.customer = new Customer(name);
		this.date = date;
	}

//getters and setters
	String getName()
	{
		return this.customer.get_name();
	}

	double getServiceExpense()
	{
		return this.serviceExpense;
	}

	double getProductExpense()
	{
		return this.productExpense;
	}

	double getTotalExpense()
	{
		String memType = this.customer.getMemberType();

		DiscountRate disc = new DiscountRate();
		double servDiscPercent = disc.getServDisc(memType);

		double servExp = this.serviceExpense - (this.serviceExpense*servDiscPercent);
		double prodExp = this.productExpense*.9;

		return (servExp+ prodExp);
	}

	void setServiceExpense(double ex)
	{
		this.serviceExpense = ex;
	}

	void setProductExpense(double ex)
	{
		this.productExpense = ex;
	}

}

class DiscountRate
{
	static double sDPrem = 0.2;
	static double sDGold = .15;
	static double sdSilver = .1;

	static double pDPrem = .1;
	static double pDGold = .1;
	static double pDSilver = .1;

	static double getServDisc(String type)
	{
		if(type.equals("Premium"))
		{
			return sDPrem;
		}
		else if(type.equals("Gold"))
		{
			return sDGold;
		}
		else if(type.equals("Silver"))
		{
			return sdSilver;
		}
		else
		{
			return 0.0;
		}
	}
}

public class Assignment_7_2_1601me01
{
	public static void main(String[] args) 
	{
		Visit visit1 = new Visit("Aditya", new Date());
		visit1.customer.setMemberType("Premium");

		System.out.println("Customer name: " + visit1.getName());
		System.out.println("Membership Type: " + visit1.customer.getMemberType());
		System.out.println("Date of purchase: " + visit1.date);

		visit1.setServiceExpense(1000);
		visit1.setProductExpense(2000);

		System.out.println("Expenses on Service: " + visit1.getServiceExpense());
		System.out.println("Expenses on Product: " + visit1.getProductExpense());
		System.out.println("Total expenses of the customer " + visit1.getName() + " after doing all types of discount is " + Double.toString(visit1.getTotalExpense()));
		
	}	
}