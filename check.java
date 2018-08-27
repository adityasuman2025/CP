class hello
{
	int hello = 1;

	void display()
	{
		System.out.println(2);
	}
}

class world extends hello
{
	void display()
	{
		System.out.println(5);
	}
}

public class check
{
	public static void main(String args[])
	{
		hello object = new world();
		object.display();
	}
}