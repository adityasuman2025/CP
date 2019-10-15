import java.util.*;
import java.io.*;

/*
Min distance between two given nodes of a Binary Tree
Given a binary tree and two node values your task is to find the minimum distance between them.

Input:
The task is to complete the fuction findDist which takes 3 argument, the  root of the  Binary Tree and two node values a and b .
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return min distance between two node values .

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example:
Input
1
2
1 2 L 1 3 R
2 3 

Output
2

In above example there is one  test case which represent a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 2 and right child of 1 is 3.  

*/

class MinDistanceBWTwoNodes
{
    int findDist(Node root, int a, int b)
    {
        Node lca = LCA(root,a,b);
        
        int aDist = dist(lca, a);
        int bDist = dist(lca, b);
        
        return aDist+bDist;
    }
    
    static int dist(Node root, int search)
    {
        if(root == null)
            return 0;
            
        if(root.data == search)
            return 0;
        
        int lDist = dist(root.left, search);
        int rDist = dist(root.right, search);
        
        return Math.min(lDist, rDist) + 1;
    }
    
    static Node LCA(Node node, int a, int b)
    {
        if(node == null)
            return null;
            
        if(node.data ==a || node.data ==b)
            return node;
            
        Node left = LCA(node.left, a, b);
        Node right = LCA(node.right, a, b);
        
        if(left !=null && right !=null)
            return node;
            
        if(left == null)
            return right;
        else
            return left;
    }
}