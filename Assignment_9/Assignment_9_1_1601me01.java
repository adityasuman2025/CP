class Employee
{
	private static int count;

	Employee()
	{
		count++;
	}

	public static void getCount()
	{
		System.out.println(count);
	}
}

class Assignment_9_1_1601me01
{
	public static void main(String[] args) 
	{
		Employee obj1 = new Employee();
		Employee obj2 = new Employee();
		Employee obj3 = new Employee();
		Employee obj4 = new Employee();
		obj1.getCount();
	}
}