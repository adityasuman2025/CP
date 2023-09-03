class Animal
{
	Animal(String a)
	{
		System.out.println(a + " is created");
	}

	void display()
	{
		System.out.println("this is animal");
	}
}

class Dog extends Animal
{
	Dog(String b)
	{
		super(b);
		System.out.println(b + " is created");
	}

	Dog(String a, String b)
	{
		super(a);
		System.out.println(a + " is created from " + b);
	}

	void display()
	{
		System.out.println("this is dog");
	}
}

public class Inheritance
{
	public static void main(String args[])
	{
	//this is allowed
	//going top to bottom in inheritance is allowed in java
		Animal object = new Dog("hello");
		object.display();

	//this is not allowed
	//going bottom to top in inheritance is not allowed in java
		//Dog object1 = new Animal();
	}
}