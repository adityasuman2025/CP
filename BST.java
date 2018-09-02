class Node
{
	Node left, right;
	int data;

	public Node(int data)
	{
		this.data = data;
	}

	public void insert(int value)
	{
		if(value <=data)
		{
			if(left == null)
			{
				left = new Node(value);
			}
			else
			{
				left.insert(value);
			}
		}
		else
		{
			if(right == null)
			{
				right = new Node(value);
			}
			else
			{
				right.insert(value);
			}
		}
	}

	public boolean contains(int value)
	{
		if(data == value)
		{
			return true;
		}
		else if(value<data)
		{
			if(left == null)
			{
				return false;
			}
			else
			{
				return left.contains(value);
			}
		}
		else
		{
			if(right == null)
			{
				return false;
			}
			else
			{
				return right.contains(value);
			}
		}
	}


	public void printInOrder()
	{
		if(left != null)
		{
			left.printInOrder();
		}
		System.out.println(data);
		if(right !=null)
		{
			right.printInOrder();
		}
	}

	public void printPreOrder()
	{		
		System.out.println(data);
		if(left != null)
		{
			left.printPreOrder();
		}
		if(right !=null)
		{
			right.printPreOrder();
		}
	}
}

public class BST
{
	public static void main(String[] args)
	{
		Node obj = new Node(80);

		obj.insert(50);	
		obj.insert(100);	
		obj.insert(10);	
		obj.insert(60);	
		obj.insert(90);	
		obj.insert(110);	

		obj.printInOrder();
		obj.printPreOrder();
	}
}