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

//zig-zag or spiral level order transevrsal
	void printSpiral(Node node) 
    {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);
        
        StringBuilder str = new StringBuilder();
        boolean flag = true;
        while(!stack1.isEmpty() || !stack2.isEmpty())
        {
            if(flag)
            {
                while(!stack1.isEmpty())
                {
                    Node top = stack1.pop();
            
                    str.append(top.data +  " ");
                     
                    if(top.right!=null)
                    {
                        stack2.push(top.right);
                    }
                    
                    if(top.left!=null)
                    {
                        stack2.push(top.left);
                    }
                }
            }
            else
            {
                while(!stack2.isEmpty())
                {
                    Node top = stack2.pop();
            
                    str.append(top.data +  " ");
                    
                    if(top.left!=null)
                    {
                        stack1.push(top.left);
                    }
                    
                    if(top.right!=null)
                    {
                        stack1.push(top.right);
                    }
                }
            }
            
            flag = !flag;
        }
        
        System.out.print(str.toString());
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

//max-width of the tree
	int getMaxWidth(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int maxSize = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            maxSize = Math.max(size, maxSize);
            
            while(size>0)
            {
                Node temp = q.poll();
             
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                
                size--;
            }
        }
        
        return maxSize;
    }

//width of the tree
    static int max = 0;
    static int min = 0;

    void getWidth(Node root, int curr) 
	{ 
	    if (root == null) 
	        return; 
	  
    // traverse left 
	    getWidth(root.left, curr - 1); 
	  
	    // if curr is decrease then get 
	    // value in minimum 
	    if (curr<min) 
	        min = curr; 
	  
	    // if curr is increase then get 
	    // value in maximum 
	    if (curr>max) 
	        max = curr;

    // traverse right 
	   	getWidth(root.right, curr + 1); 
	} 
	  
	int width(Node root) 
	{ 
	    max = 0;
	    min = 0; 

	    getWidth(root, 0); 
	  	    
	    return (max - (min) + 1); // 1 is added to include root node in the width 
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
	static TreeMap<Integer, Integer> map = new TreeMap<>();

	void printVertical(Node root)
    {
        map.clear();
        
        printV(root, 0);
        
        StringBuilder sb = new StringBuilder();
        for(int key: map.keySet())
        {
            int val = map.get(key);
            sb.append(val+ " ");
        }
        
        System.out.println(sb.toString());
    }
    
    static void printV(Node node, int dist)
    {
        if(node == null)
            return;
            
        if(map.containsKey(dist))
        {
            int val = map.get(dist);
            map.put(dist, val+node.data);
        }
        else
        {
            map.put(dist, node.data);
        }
        
        if(node.left !=null)
        {
            printV(node.left, dist-1);
        }
        
        if(node.right !=null)
        {
            printV(node.right, dist+1);
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

//root to leaf path sum
    public static int treePathsSum(Node root)
    {
        return t(root,0);        
	}
	
	static int t(Node root,int val)
    {
        if(root==null)
            return 0;
        
        val = (val*10+root.data);
        
        if(root.right==null && root.left==null)
            return val;
        
        return t(root.left,val)+t(root.right,val);
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

//inorder successor in bst
    public int inorderSuccessor(Node root,Node k)
    {
        ArrayList<Integer> list = new ArrayList<>();        
        inOrderS(root, list);
        
        int toFind = k.data;        
        int i=0;
        for(i=0; i<list.size(); i++)
        {
            if(list.get(i)==toFind)
                break;
        }
        
        if(i>=list.size()-1)
            return 0;
            
        int data = list.get(i+1);
        
        return data;
    }
    
    public void inOrderS(Node root, ArrayList<Integer> list)
    {
        if(root.left != null)
            inOrderS(root.left, list);
            
        list.add(root.data);
        
        if(root.right != null)
            inOrderS(root.right, list);
    }
 
//mirror a binary tree
	void mirror(Node node)
    {
	    if(node == null)
	        return;
	        
	    Node left = node.left;
	    
	    node.left = node.right;
	    mirror(node.left);
	    
	    node.right = left;
	    mirror(node.right);
    }

//left view of the tree
    //static TreeMap<Integer, Integer> map = new TreeMap<>();
    //depth, node.data
    
    void leftView(Node root)
    {
        map.clear();
        
        StringBuilder str = new StringBuilder();
        
        lView(root, 0);
        
        for(int key: map.keySet())
        {
            int val = map.get(key);
            
            str.append(val + " ");
        }
        System.out.print(str.toString());
    }
    
    void lView(Node root, int depth)
    {
        if(root == null)
            return;
            
        if(!map.containsKey(depth))
        {
            map.put(depth, root.data);
        }
        
        if(root.left !=null)
            lView(root.left, depth+1);
            
        if(root.right !=null)
            lView(root.right, depth+1);
    }

//right view of the tree   
    void rightView(Node root)
    {
        map.clear();
        
        StringBuilder str = new StringBuilder();
        
        rView(root, 0);
        
        for(int key: map.keySet())
        {
            int val = map.get(key);
            
            str.append(val + " ");
        }
        System.out.print(str.toString());
    }
    
    void rView(Node root, int depth)
    {
        if(root == null)
            return;
            
        if(!map.containsKey(depth))
        {
            map.put(depth, root.data);
        }
        
        if(root.right !=null)
            rView(root.right, depth+1);
            
        if(root.left !=null)
            rView(root.left, depth+1);            
    }

//bottom view of the tree
    public void bottomView(Node root)
    {
        map.clear();
        
        StringBuilder str = new StringBuilder();
        
        bView(root, 0);
        
        for(int key: map.keySet())
        {
            int val = map.get(key);
            
            str.append(val + " ");
        }
        System.out.print(str.toString());
    }
    
    static void bView(Node root, int index)
    {
        if(root == null)
            return;
        
        if(root.left !=null)
            bView(root.left, index-1);
            
        map.put(index, root.data);
        
        if(root.right !=null)
            bView(root.right, index+1);
    }

//top view of the tree
    public void topView(Node node)
    {
        if(node == null)
            return;
            
        class Pair
        {
            Node node;
            int index;
            
            Pair(Node node, int index)
            {
                this.node = node;
                this.index= index;
            }
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node , 0));
        
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            Node tempNode = temp.node;
            int tempIndex = temp.index;
            
            if(!map.containsKey(tempIndex))
            {
                map.put(tempIndex, tempNode.data);
            }
            
            if(tempNode.left !=null)
                q.add(new Pair(tempNode.left , tempIndex-1));

           if(tempNode.right !=null)
                q.add(new Pair(tempNode.right , tempIndex+1));
        }
        
        StringBuilder str = new StringBuilder();
        for(int key: map.keySet())
        {
            int val = map.get(key);
            
            str.append(val + " ");
        }
        System.out.print(str.toString());
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