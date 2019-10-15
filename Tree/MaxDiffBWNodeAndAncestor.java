
/*
Maximum difference between node and its ancestor
Given a Binary Tree you need to find maximum value which you can get by subtracting value of node B from value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. You are required to complete the function maxDiff. You should not read any input from stdin/console. There are multiple test cases. For each test case, this method will be called individually.

Input:
The task is to complete the function maxDiff which takes 1 argument, root of the Tree. The struct node has a data part which stores the data, pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return an integer denoting the maximum difference.

User Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.

Constraints:
1 <= T <= 100
1 <= Number of edges <= 1000
0 <= Data of a node <= 1000

Example:
Input:
1
2
5 2 L 5 1 R

Output:
4

Explanation:
Testcase 1:

             5
           /    \
         2      1
The maximum difference we can get is 4, which is bewteen 5 and 1.
*/

class MaxDiffBWNodeAndAncestor
{
    static int diff = -1;
    
    int maxDiff(Node root)
    {
        diff = -1;
        
        helper(root);
        return diff;
    }
    
    static void helper(Node root)
    {
        if(root == null)
            return;
            
        Node min = min(root);
        
        if(min!=null && min!=root)
        {
            int newDiff = (root.data)-(min.data);
            diff = Math.max(diff, newDiff);
        }
        
        helper(root.left);
        helper(root.right);
    }
    
    static Node min(Node root)
    {
        if(root == null)
            return null;
            
        Node lMin = min(root.left);
        Node rMin = min(root.right);
        
        if(lMin!=null && rMin!=null)
        {
            if(lMin.data<rMin.data && lMin.data<root.data)
                return lMin;
            else if(rMin.data<lMin.data && rMin.data<root.data)
                return rMin;
            else
                return root;
        }
        else if(lMin==null && rMin==null)
        {
            return root;
        }
        else if(lMin==null)
        {
            if(rMin.data<root.data)
                return rMin;
            return root;
        }
        else //if(rMin == null)
        {
            if(lMin.data<root.data)
                return lMin;
            return root;
        }
    }
}