import java.util.*;

class Node
{
	int val, height;
	Node left, right;

	Node(int val)
	{
		this.val = val;
		height = 1;
	}
}

class AVL 
{
//function to get the height of a node
	static int getHeight(Node node)
	{
		if(node == null)
		{
			return 0;
		}

		return node.height;
	}

//function to get the height difference of its left and right child nodes
	static int hDiff(Node node)
	{
		if(node == null)
		{
			return 0;
		}

		return getHeight(node.left) - getHeight(node.right);
	}

//function to perform left rotation of the nodes
	static Node leftRot(Node root)
	{
		Node x = root;
		Node y = x.right;
		Node t = y.left;

	//rotating nodes
		y.left = x;
		x.right = t;

	//updating the heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;
	}

//funciton to perform right rotation of the nodes
	static Node rightRot(Node y)
	{
		Node x = y.left;
		Node T2 = x.right;

	// Perform rotation
		x.right = y;
		y.left = T2;

	// Update heights
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

		return x;
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

//function to insert nodes in the AVL tree
	static Node insert(Node root, int val)
	{
	//doing the simple insertion action	
		if(root == null)
		{
			root= new Node(val);
		}

		if(val > root.val)
		{
			root.right = insert(root.right, val);
		}
		else if(val <root.val)
		{
			root.left = insert(root.left, val);
		}

	//update the height of the root node
		root.height = Math.max(getHeight(root.left),getHeight(root.right)) + 1;

	//checking the differenec in height of its left and right child nodes
		int hDiff = hDiff(root);

	//if hdiff is greater than 1 then the tree become non-AVL, so making it AVL by doing rotation action
	//case 1: right-right error
		if(hDiff <-1 && val> root.right.val)
		{
			return leftRot(root);
		}
	//case 2: left-left error
		if(hDiff >1 && val<root.left.val)
		{
			return rightRot(root);
		}
	//case 3: left-right error
		if(hDiff >1 && val>root.left.val)
		{
			root.left = leftRot(root.left);
			return rightRot(root);
		}
	//case 4: right-left rotation
		if(hDiff< -1 && val< root.right.val)
		{
			root.right = rightRot(root.right);
			return leftRot(root);
		}

		return root;
	}	

//function to delete node in the AVL tree
	static Node delete(Node root, int val)
	{
		if(root==null)
		{
			return root;
		}

		if(val>root.val)
		{
			root.right = delete(root.right, val);
		}
		else if(val<root.val)
		{
			root.left = delete(root.left, val);
		}
		else //we get the node to delete
		{
		//case 1: no child nodes	
			if(root.left ==null && root.right ==null)
			{
				root = null;
			}
		//case 2: only 1 child node
			else if(root.left == null)
			{
				Node temp = root;				
				root= root.right;

				temp =null;
			}
			else if(root.right == null)
			{
				Node temp = root;
				root = root.left;

				temp = null;
			}
		//case 3: root node have 2 child nodes
			else
			{
				Node temp = findMin(root.right);
				root.val = temp.val;

				root.right = delete(root.right, temp.val);
			}
		}

	// If the tree had only one node then return  
        if (root == null)  
            return root;

	//updating the height of the root node
		root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

	//getting the hight difference of the root node
		int hDiff = hDiff(root);

	//if the node become unbalancde(non-AVL)
	//case 1: left-left case
		if(hDiff > 1 && hDiff(root.left) >= 0)  
			return rightRot(root);  

	//case 2: Left-Right Case  
		if(hDiff > 1 && hDiff(root.left) < 0)  
		{
			root.left = leftRot(root.left);  
			return rightRot(root);  
		}

	//case 3: Right-Right Case  
		if(hDiff < -1 && hDiff(root.right) <= 0)  
			return leftRot(root);  

	//case 4: Right-Left Case  
		if(hDiff < -1 && hDiff(root.right) > 0)  
		{
			root.right = rightRot(root.right);  
			return leftRot(root);  
		}

		return root;
	}

//function to do level order transversal
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
			
			if(temp.left != null)
			{
				q.add(temp.left);
			}
			
			if(temp.right != null)
			{
				q.add(temp.right);
			}
		}
	}

//main function
	public static void main(String[] args) 
	{
		Node root = new Node(1);
  
       	root = insert(root, 2);
        root = insert(root, 4);
        root = insert(root, 5);
      	root = insert(root, 9);
  		root = insert(root, 3);
        root = insert(root, 6);
      	root = insert(root, 7);
      	root = insert(root, 8);
        root = insert(root, 10);

        BFS(root);
        System.out.println();
        System.out.println();

        root = delete(root, 6);
        
        BFS(root);
        System.out.println();
        System.out.println();
	}
}

