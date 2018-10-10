import java.math.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

class Node
{
	int data;
	Node left;
	Node right;
}

public class BST_all
{
//insert
	public static void insert(Node root, int value)
	{
		if(root.data == 0)
		{
			root.data = value;
		}
		else
		{
			if(value<root.data)
			{
				if(root.left == null)
				{
					Node temp = new Node();
					temp.data = value;
					root.left = temp;
				}
				else
				{
					insert(root.left, value);
				}				
			}
			else
			{
				if(root.right == null)
				{
					Node temp = new Node();
					temp.data = value;
					root.right = temp;
				}
				else
				{
					insert(root.right, value);
				}
			}
		}
	}
	
//depth-first search
	public static void inOrder(Node root)
	{
		if(root.left != null)
		{
			inOrder(root.left);
		}

		System.out.print(root.data + " ");

		if(root.right != null)
		{
			inOrder(root.right);
		}
	}

	public static void preOrder(Node root)
	{
		System.out.println(root.data);

		if(root.left!=null)
		{
			preOrder(root.left);
		}

		if(root.right!=null)
		{
			preOrder(root.right);
		}
	}

	public static void postOrder(Node root)
	{
		if(root.left!=null)
		{
			preOrder(root.left);
		}

		if(root.right!=null)
		{
			preOrder(root.right);
		}

		System.out.println(root.data);
	}

//breadth-first search
	public static void levelOrder(Node root)
	{
		if(root == null)
		{
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty())
		{
			Node temp = q.poll();

			System.out.println(temp.data);		

			if(temp.left !=null)
			{
				q.add(temp.left);
			}

			if(temp.right !=null)
			{
				q.add(temp.right);
			}
		}
	}

//min max in BST
	public static int min(Node root)
	{
		Node current = root;
		while(current.left !=null)
		{
			current = current.left;
		}

		return current.data;
	}

	public static int max(Node root)
	{
		Node current = root;
		while(current.right !=null)
		{
			current = current.right;
		}

		return current.data;
	}

//height of BST
	public static int height(Node root) //or max-height
	{
		if(root == null)
		{
			return -1;
		}

		int lHeight = height(root.left);
		int rHeight = height(root.right);

		return Math.max(lHeight, rHeight) +1;
	}	

//checking if the binary tree is binary search tree or not
	static List<Integer> list = new ArrayList<>();

	public static void inOrder_forCheckingBST(Node root)
	{
		if(root.left != null)
		{
			inOrder_forCheckingBST(root.left);
		}

		list.add(root.data);

		if(root.right != null)
		{
			inOrder_forCheckingBST(root.right);
		}
	}

	public static void checkBST(Node root)
	{
		inOrder_forCheckingBST(root);	

		boolean flag = true;
		for(int i=0; i<list.size()-1; i++)
		{
			//System.out.print(list.get(i) + " ");
			if(list.get(i+1) <= list.get(i)) //equal to sign varify for duplicate enteries also
			{				
				flag = false;
			}
		}

		if(flag)
		{
			System.out.println("This Tree is BST");
		}
		else
		{
			System.out.println("Not BST");
		}
	}

//the main function
	public static void main(String[] args) 
	{
		Node node = new Node();
		insert(node, 8);
		insert(node, 11);
		insert(node, 6);
		insert(node, 10);
		insert(node, 7);
		insert(node, 1);

		levelOrder(node);	
		
		System.out.println(height(node));

		checkBST(node);
	}
}