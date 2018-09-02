import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Node
{
	int data;
	Node next;
}

class Stacks
{
	static void push(Node root, int data)
	{
		Node temp =  new Node();
		temp.data = data;

		if(root == null)
		{
			root = temp;
		}
		else
		{
			while(root.next !=null)
			{
				root =  root.next;
			}			
			root.next = temp;
		}		
	}

	static void pop(Node root)
	{
		if(root == null)
		{
			//System.out.println("root is null");
		}
		else if(root.next == null)
		{
			//System.out.println("root.next is null");
			root.data = Integer.MIN_VALUE;
		}		
		else
		{
			//System.out.println("all is fine");
			while(root.next.next !=null)
			{
				root = root.next;
			}

			root.next = null;
		}
	}

	static void max(Node root)
	{
		List<Integer> list = new ArrayList<>();

		if(root != null)
		{
			while(root.next !=null)
			{
				list.add(root.data);
				root = root.next;
			}
			list.add(root.data);

			int max =  Collections.max(list);
			System.out.println(max);
		}
	}

	static void print(Node root)
	{
		if(root != null)
		{
			while(root.next !=null)
			{
				System.out.println(root.data);
				root = root.next;
			}

			int data = root.data;
			if(data != Integer.MIN_VALUE)
			{
				System.out.println(root.data);
			}
		}	
	}

	static boolean isEmpty(Node root)
	{
		return root == null;
	}

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Node stack = null;

		int n = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<n; i++)
		{		
			String arr[] = scanner.nextLine().split("\\ ");

			int option = Integer.parseInt(arr[0]);
			if(option == 1) //push into the stack
			{
				int val = Integer.parseInt(arr[1]);
				
				if(isEmpty(stack))
				{
					stack = new Node();
					stack.data = val;
				}
				else
				{
					push(stack, val);
				}
				
			}
			else if(option == 2) //pop from the stack
			{
				pop(stack);
			}
			else if(option == 3) // printing max element in the stack
			{
				max(stack);
			}
		}
	}
}