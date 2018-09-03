class Rupees // converts dollar into rupees
{
	float rupees;
	float dollars;

	public Rupees(float dollar)
	{
		this.dollars = dollar;
		this.rupees = dollar * (float)70.84;
	}
}

class Dollars // converts rupees into dollars
{
	float dollar;
	float rupees;	

	public Dollars(float rupees)
	{
		this.rupees = rupees;
		this.dollar = rupees / (float)70.84;
	}
}

class Assignment_6_1_1601me01
{
	public static void main(String[] args) 
	{
		Rupees to_rupees = new Rupees(2);
		float dollar_into_rupees = to_rupees.rupees;
		System.out.println(Float.toString(to_rupees.dollars) + " dollars into rupees: " + Float.toString(dollar_into_rupees));

		Dollars to_dollars = new Dollars((float)70.84);
		float rupees_into_dollars = to_dollars.dollar;
		System.out.println(Float.toString(to_dollars.rupees) + " rupees into dollars: " + Float.toString(rupees_into_dollars));
	}
}