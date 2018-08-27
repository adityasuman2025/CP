public class Dog extends Inheritance
{
	public Dog()
	{
		super(15);
		System.out.println("A dog has been created");
	}

	public static void main(String args[])
	{
		Dog a = new Dog();
		a.eat();
	}
}