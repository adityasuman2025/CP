import java.util.*;

class Student
{
	String name;
	int age;
	String address;

	public Student()
	{
		this.name = "unknown";
		this.age = 0;
		this.address = "not available";		
	}

	public void setInfo(String name, int age)
	{
		this.name = name;
		this.age  =age;
	}

	public void setInfo(String name, int age, String address)
	{
		this.name = name;
		this.age  =age;
		this.address  =address;
	}
}

public class Assignment_4_1_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
	// in normal object form
		// Student a = new Student();
		// a.setInfo("hello", 15);
		// System.out.println(a.address);
		
	//in the form of a array
		Student[] obj = new Student[10];

	//creating details of 10 student object
		obj[1] = new Student();
		obj[1].setInfo("Aditya SUman", 21, "Bihta");

		obj[2] = new Student();
		obj[2].setInfo("Aditya s", 25, "Ghta");

		obj[3] = new Student();
		obj[3].setInfo("hello s", 25, "near");

		obj[3] = new Student();
		obj[3].setInfo("Aditi s", 20, "kankar");

		obj[4] = new Student();
		obj[4].setInfo("Adarsh s", 16, "baag");

		obj[5] = new Student();
		obj[5].setInfo("Rohit kr", 27);

		obj[6] = new Student();
		obj[6].setInfo("junior s", 24, "asha");

		obj[7] = new Student();
		obj[7].setInfo("siddhant", 19, "bihar");

		obj[8] = new Student();
		obj[8].setInfo("gully", 30, "punjab near");
		
		obj[9] = new Student();
		obj[9].setInfo("satyam s", 45, "near chennai");

		obj[0] = new Student();
		obj[0].setInfo("rahul", 70, "home");

	//printing details of 10 student object
		for(int i=0; i<obj.length; i++)
		{
			System.out.println("Name: " + obj[i].name + ", Age: " + obj[i].age + ", Address: " + obj[i].address);
		}
		
	}
}