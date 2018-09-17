import java.util.*;

public class Assignment_10_1_1601me01
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Stack<Integer> stack = new Stack<>();				
		
		while(true)
		{
			System.out.println();
			System.out.println("Choose an action:");
			System.out.println("1. Push an element");
			System.out.println("2. Pop an element");
			System.out.println("3. Top element in the stack");
			System.out.println("4. Push N number of element from stack");
			System.out.println("5. Pop N Number of element from Stack");
			System.out.println("6. Exit");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			if(n == 6)
			{
				break;
			}
			else if(n ==1)
			{
				System.out.print("Enter the element to add: ");
				int no = scanner.nextInt();
				stack.add(no);
				System.out.println(no + " is successfully added in the stack.");
			}
			else if(n ==2)
			{
				if(stack.isEmpty())
				{
					System.out.println("This stack is already empty.");
				}
				else
				{
					int no = stack.pop();
					System.out.println(no + " is removed from top of the stack.");	
				}
				
			}
			else if(n ==3)
			{
				if(stack.isEmpty())
				{
					System.out.println("This stack is empty.");
				}
				else
				{
					int no = stack.peek();
					System.out.println(no + " is the top element in the stack");
				}
			}
			else if(n == 4)
			{
				System.out.print("Enter N elements separating them by a space: ");
				String data[] = scanner.nextLine().split(" ");

				for(int i=0; i<data.length; i++)
				{
					int val = Integer.parseInt(data[i]);
					stack.push(val);
					System.out.println(val + " is successfully added in the stack.");
				}				
			}
			else if(n == 5)
			{
				System.out.println("Enter the number of elements you want to remove from the stack: ");
				int N = scanner.nextInt();

				if(N> stack.size())
				{
					System.out.println("You have entered a value greater than the size of the stack.");
				}
				else
				{
					for(int i=0; i<N; i++)
					{
						int val = stack.pop();
						System.out.println(val + " is successfully removed from the top of the stack.");
					}
				}			
			}
			else 
			{
				System.out.print("Choose only from 1 to 6");
			}
		}
	}	
}