import java.util.*;

public class Assignment_10_4_1601me01
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Stack<Integer> input = new Stack<>();
		Stack<Integer> output = new Stack<>();

		System.out.print("Enter N elements separated by single space: ");
		String data[] = scanner.nextLine().split(" ");

		for(int i=0; i<data.length; i++)
		{
			input.push(Integer.parseInt(data[i]));
		}
		System.out.println("Data in the stack is: " + input);

		int val= input.peek();
		while(!input.isEmpty())
		{
			int temp1 = input.pop();
			if(output.isEmpty())
			{
				output.push(temp1);
			}
			else
			{
				int temp2 = output.peek();	

				if(temp2 == temp1)
				{
					output.pop();
					val = temp2;
				}
				else
				{
					if(val !=temp1)
					{
						output.push(temp1);	
					}					
				}
			}
			
		}

		Collections.reverse(output);
		System.out.println("Output: " + output);
	}
}