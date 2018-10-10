import java.math.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

class Node
{
	int val;
	Node left;
	Node right;

	Node(int val)
	{
		this.val = val;
	}
}

public class BST
{
//insert function
	static void insert(Node root, int no)
	{
		if(root == null)
		{
			root = new Node(no);
		}

		if(no > root.val)
		{
			if(root.right == null)
			{
				root.right = new Node(no);
			}
			else
			{
				insert(root.right, no);
			}			
		}
		else if(no < root.val)
		{
			if(root.left == null)
			{
				root.left = new Node(no);
			}
			else
			{
				insert(root.left, no);
			}		
		}
	}

//BFS
	static void BFS(Node root)
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
			System.out.print(temp.val + " ");

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

//DFSs
	static void preOrder(Node root)
	{
		if(root != null)
		{
			System.out.print(root.val + " ");
		}

		if(root.left != null)
		{
			preOrder(root.left);
		}
		
		if(root.right != null)
		{
			preOrder(root.right);
		}
	}

	static void inOrder(Node root)
	{
		if(root.left != null)
		{
			inOrder(root.left);
		}
		
		if(root != null)
		{
			System.out.print(root.val + " ");
		}

		if(root.right != null)
		{
			inOrder(root.right);
		}
	}

	static void postOrder(Node root)
	{
		if(root.left != null)
		{
			postOrder(root.left);
		}

		if(root.right != null)
		{
			postOrder(root.right);
		}
		
		if(root != null)
		{
			System.out.print(root.val + " ");
		}
	}

//finding the minimum node in the subtree of a node
	static Node findMin(Node root)
	{
		Node temp = root;
		while(temp.left != null)
		{
			temp = temp.left;
		}

		return temp;
	}

//remove node 
	static Node delete(Node root, int data)
	{
		if(root == null)
		{
			return root;
		}

		if(data <root.val) //the node which we want to delete is in the left of the root node
		{
			root.left = delete(root.left, data);
		}
		else if(data > root.val)
		{
			root.right = delete(root.right, data);
		}
		else // if the root is the node which we want to delete
		{
		//case 1: the node which we want to delete have no any child nodes
			if(root.left == null && root.right == null)
			{
				root = null; //deleteting that node
			}
		//case 2: the node which we want ot delete have only one sub-node
			else if(root.left == null) //if it does not have left node
			{
				Node temp = root;				
				root = root.right; //replacing that position with the right child of the root node

				temp = null; // deleting that node
			}
			else if(root.right == null) //if it does not have right node
			{
				Node temp = root;
				root = root.left; //making its left child new root of the sub tree

				temp = null; // deleting that node
			}
		//case 3: if that node have both the left and right nodes
			else
			{
				Node temp = findMin(root.right); //finding the minimum value node in the right sub tree of the root node
				root.val = temp.val; //making that temp node the new root node

				root.right = delete(root.right, temp.val); // deleting that duplicate node from the right subtree of the root node
			}
		}

		return root;
	}

//main function
	public static void main(String[] args) {
		Node root = new Node(-1);
		insert(root, 0);
		insert(root, -3);
		insert(root, -2);
		insert(root, 5);
		insert(root, 4);

		System.out.println("Level order transversal of the tree is: ");
		BFS(root);
		System.out.println();
		System.out.println();

		// System.out.println("Pre Order transversal of the tree is: ");
		// preOrder(root);
		// System.out.println();
		// System.out.println();

		// System.out.println("In Order transversal of the tree is: ");
		// inOrder(root);
		// System.out.println();
		// System.out.println();

		// System.out.println("Post Order transversal of the tree is: ");
		// postOrder(root);
		// System.out.println();
		// System.out.println();

		delete(root, -1);

		System.out.println("Level order transversal of the tree is: ");
		BFS(root);
		System.out.println();
		System.out.println();
	}
}