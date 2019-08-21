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

//search function
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

	Node search(Node head, int value)
    {
        if(head == null)
        {    
            return null;
        }
            
        if(head.data == value)
        {
            return head;
        }
        else if(head.data > value)
        {
            return search(head.left, value);
        }
        else
        {
            return search(head.right, value);
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

//vertical sum
	void printVertical(Node root)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        printV(root, 0, map);
        
        int c =0;
        int min = 0;
        int max = 0;
        for(int key: map.keySet())
        {
            if(c ==0)
            {
                c++;
                min = key;
                max = key;
            }
            
            if(key<min)
                min = key;
                
            if(key>min)
                max = key;
        }
        
        System.out.print("Vertical sum of given tree is: ");
        for(int i=min; i<=max; i++)
        {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }
    
    static void printV(Node root, int index, HashMap<Integer, Integer> map)
    {
        if(root.left != null)
        {
            printV(root.left, index-1, map);
        }
        
        if(map.containsKey(index))
        {
            int old = map.get(index);
            int new_val = old + root.data;
            map.put(index, new_val);
        }
        else
        {
            map.put(index, root.data);    
        }
       
        if(root.right != null)
        {
            printV(root.right, index+1, map);
        }
    }

//level order sum
    public int maxLevelSum(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int res = root.data;
        while(!q.isEmpty())
        {
            int c = q.size();
            
            int sum = 0;
            while(c>0)
            {
                Node temp = q.poll();
                sum +=temp.data;
                
                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                 
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
                
                c--;
            }
            
            res = Math.max(sum,res);
        }
        
        return res;
    }

//all diagonals sum
	public void diagonalsum(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int sum = 0;
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
                Node temp = q.poll();
                
                while(temp != null)
                {
                    if(temp.left !=null)
                        q.add(temp.left);
                        
                    sum +=temp.data;
                    temp=temp.right;
                }
            }
            
            System.out.print(sum + " ");
        }
        System.out.println();
    }

//lowest common ancestor in bST
    Node LCA(Node node, int n1, int n2) 
    {
        if(node == null)
            return null;
            
        if(n1<node.data && n2<node.data)
            return LCA(node.left, n1, n2);
        else if(n1>node.data && n2>node.data)
            return LCA(node.right, n1, n2);
            
        return node;
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

		bst.printVertical(root);

		System.out.println("Maximum level sum: " + bst.maxLevelSum(root));	

		Node val = bst.search(root, 11);	

		System.out.println(val.data);
	}	
}