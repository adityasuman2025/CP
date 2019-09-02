/*
Maximum path sum
Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.

Input:
The input contains T, denoting number of testcases. For each testcase there will be two lines. The first line contains number of edges. The second line contains two nodes and a character separated by space. The first node denotes data value, second node denotes where it will be assigned to the previous node which will depend on character 'L' or 'R' i.e. the 2nd node will be assigned as left child to the 1st node if character is 'L' and so on. The first node of second line is root node. The struct or class Node has a data part which stores the data, pointer to left child and pointer to right child. There are multiple test cases. For each test case, the function will be called individually.

Output:
Return the Maximum possible sum.

Constraints:
1 <=T <= 100
1 <= N <= 30

Example:
Input:
1
12
-15 5 L -15 6 R 5 -8 L 5 1 R -8 2 L -8 -3 R 6 3 L 6 9 R 9 0 R 0 4 L 0 -1 R -1 10 L

Output:
27

Explanation:
Testcase 1: The maximum possible sum from one leaf node to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)
*/

class MaximumPathSum
{
    static int max = 0;
    public static int maxPathSum(Node root)
    {
         max = 0;
         sum(root);
         return max;
    }
    
    static int sum(Node node)
    {
        if(node == null)
            return 0;
            
        if(node.left == null && node.right == null)
            return node.data;
            
        int left = sum(node.left);
        int right = sum(node.right);
        
        max = Math.max((left+right+node.data), max);
        
        return (node.data + Math.max(left, right));
    }
}
