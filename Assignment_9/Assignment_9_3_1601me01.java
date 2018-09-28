abstract class Employee
{
	private String fName;
	private String lName;
	private int SSN;
	
	Employee(String f, String l, int SSN)
	{
		this.fName = f;
		this.lName = l;
		this.SSN = SSN;
	}

	abstract void earnings();

	String getName()
	{
		return fName + " " + lName;
	}

	int getSSN()
	{
		return SSN;
	}

	public String toString()
	{
		System.out.println("Name" + ": " + fName + " " + lName);
		System.out.println("Social Security Number: " + SSN);

		return "";
	}
}

class SalariedEmployee extends Employee
{
	float weeklySalary;

	SalariedEmployee(String f, String s, int SSN, int weekSal)
	{
		super(f,s,SSN);

		if(weekSal <0)
		{
			System.out.println("Weekly Salary can't be negative");
			this.weeklySalary = 0;
		}
		else
		{
			this.weeklySalary = weekSal;
		}
	}

	void earnings()
	{
		System.out.println("Salary is: " + weeklySalary);
	}

	public String toString()
	{
		System.out.println("Salaried Employee: " + getName());
		System.out.println("Social Security Number: " + getSSN());
		System.out.println("Salary: " + weeklySalary);

		return "";
	}
}

class HourlyEmployee extends Employee
{
	float hourlyWage;
	float hrs;
	float salary;

	HourlyEmployee(String f, String s, int SSN, float hWage, float hrs)
	{
		super(f,s,SSN);

		if(hWage <0)
		{
			System.out.println("Hourly Wage can't be negative");
			this.hourlyWage = 0;
		}
		else
		{
			this.hourlyWage = hWage;
		}

		if(hrs >=0 && hrs<=168)
		{
			this.hrs = hrs;
		}
		else
		{
			System.out.println("Value of hours should be in between 0 and 168.");			
			this.hrs = 0;
		}
	}

	void earnings()
	{
		if(hrs <=40.0)
		{
			salary = hourlyWage*hrs;
		}
		else
		{
			salary = (float)(40.0*hourlyWage) + (float)((hrs-40.0)*hourlyWage*1.5);
		}

		System.out.println("Salary is: " + salary);	
	}

	public String toString()
	{
		System.out.println("Hourly Employee: " + getName());
		System.out.println("Social Security Number: " + getSSN());
		System.out.println("Hourly Wage: " + hourlyWage);
		System.out.println("Hours Worked: " + hrs);

		return "";
	}
}

class CommissionEmployee extends Employee
{
	float comRate;
	float grossSale;
	float salary;

	CommissionEmployee(String f, String s, int SSN, float comRate, float grossSale)
	{
		super(f,s,SSN);

		if(comRate <0)
		{
			System.out.println("Commission rate can't be negative");
			this.comRate = 0;
		}
		else
		{
			this.comRate = comRate;
		}

		if(grossSale< 0)
		{
			this.grossSale = 0;
			System.out.println("Value of gross sales can't be negative");						
		}
		else
		{
			this.grossSale = grossSale;
		}
	}

	void earnings()
	{
		salary = comRate * grossSale;
		System.out.println("Salary is: " + salary);	
	}

	public String toString()
	{
		System.out.println("Commission Employee: " + getName());
		System.out.println("Social Security Number: " + getSSN());
		System.out.println("Gross Sale: " + grossSale);
		System.out.println("Commission Rate: " + comRate);

		return "";
	}
}

class BasePlusCommissionEmployee extends CommissionEmployee
{
	float baseSalary;
	float salary;

	BasePlusCommissionEmployee(String f, String s, int SSN, float comRate, float grossSale, float baseSalary)
	{
		super(f,s,SSN, comRate, grossSale);

		if(baseSalary< 0)
		{
			this.baseSalary = 0;
			System.out.println("Value of Base Salary can't be negative");						
		}
		else
		{
			this.baseSalary = baseSalary;
		}
	}

	void earnings()
	{
		salary = comRate * grossSale + baseSalary;
		System.out.println("Salary is: " + salary);	
	}

	public String toString()
	{
		System.out.println("Commission Employee: " + getName());
		System.out.println("Social Security Number: " + getSSN());
		System.out.println("Gross Sale: " + grossSale);
		System.out.println("Commission Rate: " + comRate);
		System.out.println("Base Salary: " + baseSalary);

		return "";
	}
}

class Assignment_9_3_1601me01
{
	public static void main(String[] args) 
	{
	//salaried employee
		Employee sal1 = new SalariedEmployee("Aditya", "Suman", 465465, 100000);
		sal1.earnings();
		sal1.toString();
		System.out.println();

	//hourly employee
		Employee hr1 = new HourlyEmployee("Adarsh", "Boi", 695465, 1000, 50);
		hr1.earnings();
		hr1.toString();
		System.out.println();

	//commission employee
		Employee com1 = new CommissionEmployee("Aditi", "Suman", 186465, 30000, 4);
		com1.earnings();
		com1.toString();
		System.out.println();

	//base commission employee
		BasePlusCommissionEmployee bcom1 = new BasePlusCommissionEmployee("Swapnil", "Sr.", 689465, 900, 38, 50000);
		bcom1.earnings();
		bcom1.toString();
		System.out.println();	

	//heloo world
		Employee obj[] = new Employee[5];
		float baseSal = 10000;
		
		for(int i=0; i<obj.length; i++)
		{
			obj[i] = new BasePlusCommissionEmployee("Adi", "World", 565846, 100, 45, baseSal);
			obj[i].earnings();
			obj[i].toString();
			System.out.println();
			
			baseSal += baseSal*.1;
		}
	}
}