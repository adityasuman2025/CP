import java.util.*;

public class Assignment_10_3_1601me01
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Stack<Integer> input = new Stack<>();
		Stack<Integer> output = new Stack<>();

		for(int i =0; i<10; i++)
		{
			input.push(i+1);
		}
		System.out.println(input);

		for(int i =0; i<10; i++)
		{
			int val = input.pop();
			output.push(val);
		}
		System.out.println(output);
	}
}