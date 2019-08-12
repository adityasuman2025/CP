import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node left, right;

	Node(int data)
	{
		this.data = data;
	}
}

class BSTNew
{
//insert function
	void insert(Node root, int data)
	{
		if(root == null)
		{
			root = new Node(data);
			return;
		}

		if(data<root.data)
		{
			if(root.left == null)
			{
				root.left = new Node(data);
			}
			else
			{
				insert(root.left, data);
			}
		}
		else
		{
			if(root.right == null)
			{
				root.right = new Node(data);
			}
			else
			{
				insert(root.right, data);
			}
		}
	}

//search function()
	boolean contains(Node root, int value)
	{
		if(root == null)	
			return false;	

		if(root.data == value)
		{
			return true;
		}
		else if(value<root.data)
		{
			return contains(root.left, value);
		}
		else
		{
			return contains(root.right, value);
		}
	}

//inorderal transversal
	void inOrder(Node root)
	{
		if(root == null)
		{
			return;
		}

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

//preorder transversal
	void preOrder(Node root)
	{
		if(root == null)
		{
			return;
		}

		System.out.print(root.data + " ");

		if(root.left != null)
		{
			preOrder(root.left);
		}

		if(root.right != null)
		{
			preOrder(root.right);
		}
	}

//postorder transversal
	void postOrder(Node root)
	{		
		if(root == null)
		{
			return;
		}

		if(root.left != null)
		{
			postOrder(root.left);
		}

		if(root.right != null)
		{
			postOrder(root.right);
		}

		System.out.print(root.data + " ");
	}

//level order transversal
	void levelOrder(Node root)
	{
		if(root == null)
			return;

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);		

		while(!q.isEmpty())
		{
			Node temp = q.poll();

			System.out.print(temp.data + " ");

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

//min max in tree
	int findMin(Node root)
	{
		if(root == null)
			return -1;

		while(root.left != null)
		{
			root = root.left;
		}

		return root.data;
	}

	int findMax(Node root)
	{
		if(root == null)
			return -1;

		while(root.right != null)
		{
			root = root.right;
		}

		return root.data;
	}

	Node findMinNode(Node root)
	{
		if(root == null)
			return null;

		while(root.left != null)
		{
			root = root.left;
		}

		return root;
	}

//height of the tree
	int height(Node root)
	{
		if(root == null)
			return -1;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

//delete node with a particular value in tree
	Node remove(Node root, int data)
	{
		if(root == null)
		{
			return root;
		}

		if(data < root.data) //the node which we want to delete is in the left of the root node
		{
			root.left = remove(root.left, data);
		}
		else if(data > root.data)
		{
			root.right = remove(root.right, data);
		}
		else // if the root is the node which we want to delete
		{
		//case 1: the node which we want to delete have no any child nodes
			if(root.left == null && root.right == null)
			{
				root = null; //deleteting that node
			}
		//case 2: the node which we want ot delete have only one child-node
			else if(root.left == null) //have only right node
			{
				Node temp = root;
				root = root.right; //making its right child new root of the sub tree

				temp = null; //deleteting that node
			}
			else if(root.right == null) //have only left node
			{
				Node temp = root;
				root = root.left; //making its left child new root of the sub tree

				temp = null; //deleteting that node
			}
		//case 3: if that node have both the left and right nodes
			else
			{
				Node temp = findMinNode(root.right); //finding the minimum value node in the right sub tree of the root node
				
				root.data = temp.data; //making value of root node as temp node

				root.right = remove(root.right, temp.data); // deleting that duplicate node from the right subtree of the root node
			}
		}

		return root;
	}

//checking if the binary tree is binary search tree or not
	List<Integer> list = new ArrayList<>();

	public void inOrder_forCheckingBST(Node root)
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

	public void checkBST(Node root)
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

//main function
	public static void main(String[] args) 
	{
		Node root = new Node(10);
		BSTNew bst = new BSTNew();
		bst.insert(root, 5);
		bst.insert(root, 1);
		bst.insert(root, 12);
		bst.insert(root, 2);
		bst.insert(root, 30);
		bst.insert(root, 11);

		int toSearch = 12;
		boolean ifContains = bst.contains(root, toSearch);
		System.out.println("If BST contains " + toSearch + ": " + ifContains);

		System.out.print("InOrder transversal: ");
		bst.inOrder(root);
		System.out.println();

		System.out.print("PreOrder transversal: ");
		bst.preOrder(root);
		System.out.println();

		System.out.print("PostOrder transversal: ");
		bst.postOrder(root);
		System.out.println();

		System.out.print("LevelOrder transversal: ");
		bst.levelOrder(root);
		System.out.println();

		System.out.println("Minimum value in tree: " + bst.findMin(root));
		System.out.println("Maximum value in tree: " + bst.findMax(root));

		System.out.println("Height of the tree: " + bst.height(root));

		bst.checkBST(root);

		// System.out.print("LevelOrder transversal: ");
		// bst.levelOrder(root);
		// System.out.println();

	}	
}