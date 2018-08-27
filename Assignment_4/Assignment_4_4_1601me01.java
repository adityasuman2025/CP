import java.util.*;

class Info
{
	String fName;
	String lName;
	int age;
	String address;

	public Info()
	{
		System.out.println("First Name: " + this.fName);
		System.out.println("Last Name: " + this.lName);
		System.out.println("Age: " + this.age);
		System.out.println("Address: " + this.address);
	}

	public Info(int age)
	{
		this.age = age;
	}

	public Info(String address)
	{
		this.address = address;
	}

	public Info(String fName, String lName)
	{
		this.fName = fName;
		this.lName = lName;
	}
}

public class Assignment_4_4_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		Info obj = new Info(51);
	}
}