/*
https://practice.geeksforgeeks.org/problems/ancestors-in-binary-tree/1/?ref=self

Ancestors in Binary Tree
Given a Binary Tree and a target key, your task is to complete the function printAncestors() that prints all the ancestors of the key in the given binary tree.

              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1
Input:
The function takes 2 arguments as input, first the reference pointer to the root node of the binary tree and a integer value target. There will be multiple test cases and for each test the function will be called seperately.
Output:
For each test print all the ancestors of the target vlue in the order of their hierarchy.
Constraints:
1<=T<=100
1<=N<=100
Example:
Input:
2
2
1 2 L 1 3 R
2
5
1 2 R 1 3 L 2 4 L 2 5 R 4 7 L
7
Ouput:
1
4 2 1
*/

class AncestorsInBT
{
	public static boolean printAncestors(Node node, int x)
    {
        if(node == null)
            return false;
            
        if(node.data == x)
            return true;
            
        boolean left = false;
        boolean right = false;
        
        if(node.left != null)
        {
            left = printAncestors(node.left, x);
        }
        
        if(node.right != null)
        {
            right = printAncestors(node.right, x);
        }
        
        if(left || right)
        {
            System.out.print(node.data + " ");
            return true;   
        }
        
        return false;
    }
}