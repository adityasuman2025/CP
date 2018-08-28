import java.util.*;

class Info
{
	public static Scanner scanner = new Scanner(System.in);
	
	String fName;
	String lName;
	int age;
	String address;

	public Info()
	{
		this(Integer.parseInt(scanner.nextLine()));
		System.out.println("First Name: " + this.fName);
		System.out.println("Last Name: " + this.lName);
		System.out.println("Age: " + this.age);
		System.out.println("Address: " + this.address);
	}

	public Info(int age)
	{
		this(scanner.nextLine());
		this.age = age;
	}

	public Info(String address)
	{
		this(scanner.nextLine().split("\\ "));
		this.address = address;
	}

	public  Info(String name[])
	{

		this.fName = name[0];
		this.lName = name[1];
	}
}

public class Assignment_4_4_1601me01
{
	public static void main(String args[])
	{
		Info a  = new Info();
	}
}