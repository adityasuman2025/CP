import java.util.Stack;
import java.util.Scanner;
import java.util.*;

public class Stack_max_val
{
	static void max(Stack<Integer> stack)
	{
		Stack<Integer> temp = (Stack<Integer>)stack.clone();
		List<Integer> list  = new ArrayList<>();

		while(!temp.empty())
		{
			int data = temp.pop();
			//System.out.println(data);
			list.add(data);
		}

		int data =  Collections.max(list);
		System.out.println(data);
	}

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<n; i++)
		{		
			String arr[] = scanner.nextLine().split("\\ ");

			int option = Integer.parseInt(arr[0]);
			if(option == 1) //push into the stack
			{
				int val = Integer.parseInt(arr[1]);
				
				stack.push(val);
			}
			else if(option == 2) //pop from the stack
			{
				if(!stack.empty())
				{
					stack.pop();
				}				
			}
			else if(option == 3) // printing max element in the stack
			{
				if(!stack.empty())
				{
					max(stack);
				}
			}
		}

	}
}