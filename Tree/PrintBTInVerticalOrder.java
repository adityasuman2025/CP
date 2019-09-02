/*
Print a Binary Tree in Vertical Order
You are given a binary tree for which you have to print its vertical order traversal. your task is to complete the function verticalOrder which takes one argument the root of the binary tree and prints the node of the binary tree in vertical order as shown below.
If there are multiple nodes passing through a vertical line, then they should printed as they appear in level order traversal.

Input Format:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains 2 lines of input. The first line contains number of operations to insert the nodes. The second line contains the nodes and their position during the insertion.

Output Format:
For each testcase, the vertical order traversal of the tree is to be printed. The nodes' data are to be separated by spaces.

Your Task:
This is a function problem. Your task is to just complete the verticalOrder() function and you don't have to take any input or output. The newline is automatically appended by the driver code.

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 5000

Example:
Input:
4
3
1 2 L 1 3 R 3 5 L
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
4
1 2 L 1 3 R 2 4 R 4 5 R

Output:
2 1 5 3
3 1 2
40 20 10 60 30
2 1 4 3 5

Explanation:
Testcase1:
         1
       /     \
    2         3
              /
         5
As it is evident from the above diagram that during vertical traversal 2 will come first, then 1 and  5, and then 3. So output is 2 1 5 3
Testcase2:
         1
       /     \
     3       2
As it is evident from the above diagram that during vertical traversal 3 will come first, then 1 and then 2. So output is 3 1 2
*/

class PrintBTInVerticalOrder
{    
    static void verticalOrder(Node node)
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
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node , 0));
        
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            Node tempNode = temp.node;
            int tempIndex = temp.index;
            
            if(map.containsKey(tempIndex))
            {
                ArrayList<Integer> val = map.get(tempIndex);
                val.add(tempNode.data);
                
                map.put(tempIndex, val);
            }
            else
            {
                ArrayList<Integer> val = new ArrayList<>();
                val.add(tempNode.data);
                
                map.put(tempIndex, val);
            }
            
            if(tempNode.left !=null)
                q.add(new Pair(tempNode.left , tempIndex-1));

            if(tempNode.right !=null)
                q.add(new Pair(tempNode.right , tempIndex+1));
        }
        
        StringBuilder str = new StringBuilder();
        for(int key: map.keySet())
        {
            ArrayList<Integer> val = map.get(key);
            
            for(int item: val)
                str.append(item + " ");
        }
        System.out.print(str.toString());
    }
}
