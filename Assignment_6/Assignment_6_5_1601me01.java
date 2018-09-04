class Invoice
{
	String pName;
	String pDesc;
	int quantity;
	double price;

	public Invoice(String pName, String pDesc, int q, double price)
	{
		this.pName = pName;
		this.pDesc = pDesc;
		this.quantity = q;
		this.price = price;
	}

//setters
	void set_pName(String pName)
	{
		this.pName = pName;
	}

	void set_pDesc(String pDesc)
	{
		this.pDesc = pDesc;
	}

	void set_quantity(int q)
	{
		this.quantity = q;
	}

	void set_price(double price)
	{
		this.price = price;
	}

//getters
	void get_pName()
	{
		System.out.println("Part Name is: " + this.pName);
	}

	void get_pDesc()
	{
		System.out.println("Part Description is: " + this.pDesc);
	}

	void get_quantity()
	{
		System.out.println("Quantity is: " + Integer.toString(this.quantity));
	}

	void get_price()
	{
		System.out.println("Price per item is: " + Double.toString(this.price));
	}

//other functions
	double getInvoiceAmount()
	{
		if(this.quantity <0)
		{
			return 0;
		}
		else if(this.price <0)
		{
			return 0.0;
		}
		else
		{
			double res = price*(double)quantity;
			return res;
		}
	}
}

public class Assignment_6_5_1601me01
{
	public static void main(String[] args) 
	{
		Invoice one = new Invoice("Laptop", "Apple Macbook", 2, 100000.0);

		one.get_pName();
		one.get_pDesc();
		one.get_quantity();
		one.get_price();

		double amount = one.getInvoiceAmount();
		System.out.println(amount);
	}
}