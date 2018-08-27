public class Inheritance
{
	public Inheritance(int age)
	{
		System.out.println("Inheritance is created of age: " + age);
	}

	public void eat()
	{
		System.out.println("animal is eating");
	}

	public static void main(String args[])
	{
		Dog a = new Dog();
		a.eat();
	}
}