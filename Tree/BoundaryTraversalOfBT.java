/*
Boundary Traversal of binary tree
Write a function to print Boundary Traversal of a binary tree. Boundary Traversal of a binary tree here means that you have to print boundary nodes of the binary tree Anti-Clockwise starting from the root.
Note: Boundary node means nodes present at boundary of leftSubtree and nodes present at rightSubtree also including leaf nodes.
For below tree, function should print 20 8 4 10 14 25 22 .

Input:
The input contains T, denoting the number of testcases. The task is to complete the method which takes one argument, root of the tree. The struct node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should print Boundary traversal of the tree.

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example:
Input:
2
2
1 2 R 1 3 L
7
20 8 L 20 22 R 8 4 L 8 12 R 12 10 L 12 14 R 22 25 R

Output:
1 3 2
20 8 4 10 14 25 22 .

Explanation:
Testcase 1:

The first testcase represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2. And boundary traversal of this tree prints nodes as 1 3 2.
*/

class BoundaryTraversalOfBT
{
    static LinkedHashSet<Integer> set = new LinkedHashSet<>();
   
	void printBoundary(Node root)
	{
		if(root == null)
			return;

        set.clear();
        
        set.add(root.data);
        
        leftViewRecur(root.left);
        bottomViewRecur(root);
        rightViewRecur(root.right);
        
        StringBuilder sb = new StringBuilder();
        for(int item: set)
            sb.append(item + " ");
        
        System.out.print(sb.toString());
	}
	
	void leftViewRecur(Node root)
	{
		if(root == null)
		{
			return;
		}

        set.add(root.data);
        
        if(root.left != null)
        {
            leftViewRecur(root.left);
        }
        else if(root.right != null)
        {
            leftViewRecur(root.right);
        }
	}
	
	void rightViewRecur(Node root)
	{
		if(root == null)
		{
			return;
		}
        
        if(root.right != null)
        {
            rightViewRecur(root.right);
        }
        else if(root.left != null)
        {
            rightViewRecur(root.left);
        }
        set.add(root.data);
	}
	
	void bottomViewRecur(Node root)
	{
		if(root == null)
		{
			return;
		}
        
        bottomViewRecur(root.left);
        
        if(root.left == null && root.right == null)
        {
            set.add(root.data);
        }
        
        bottomViewRecur(root.right);
	}
}