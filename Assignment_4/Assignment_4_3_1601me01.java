import java.util.*;

class Calculator
{
	public void calculate()
	{
		System.out.println("This is Calculator class");
	}
}

class Sum extends Calculator
{
	public void calculate(int a, int b, int c)
	{
		int sum =  a+b+c;
		System.out.println(sum);
	}
}

class Subtract extends Calculator
{
	public int calculate(int a, int b)
	{
		return a-b;
	}
}

class Division extends Calculator
{
	public float calculate(float a, float b)
	{
		return a/b;
	}
}

public class Assignment_4_3_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
	//default calculator class
		Calculator calc = new Calculator();
		calc.calculate();

	//using sum class
		Sum sum = new Sum();
		sum.calculate(4,5,8);

	//using Subtract class
		Subtract subtract = new Subtract();
		System.out.println(subtract.calculate(5,8));

	//using Division class
		Division divide = new Division();
		System.out.println(divide.calculate(58, (float)8.2));
    }
}