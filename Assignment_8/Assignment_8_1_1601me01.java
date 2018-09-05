class Employee
{
	String fName;
	String lName;
	String secNo;

	Employee(String fName, String lName, String secNo)
	{
		this.fName = fName;
		this.lName = lName;
		this.secNo = secNo;

		System.out.println("this is Employee constructor");
		System.out.println("Name: " + fName + " " + lName);
	}

	void toString(String hello)
	{
		System.out.println("This is Employee " + hello);
	}
}

class PieceWorker extends Employee
{
	PieceWorker(String fName, String lName, String secNo)
	{
		super(fName, lName, secNo);
	}

	void toString(String hello)
	{
		super.toString(hello);
	}
}

public class Assignment_8_1_1601me01 
{
	public static void main(String[] args) 
	{
		PieceWorker obj1 = new PieceWorker("Aditya", "Suman", "46966");
		obj1.toString("world");
	}	
}