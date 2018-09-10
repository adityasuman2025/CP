import java.util.Scanner;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.lang.Integer;
import java.util.HashMap;
// A Binary Search Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class test
{
	/*void printInorder(Node node)
    {
        if (node == null)
            return;
        /* first recur on left child */
        //printInorder(node.left);
        /* then print the data of node */
       // System.out.print(node.data + " ");
        /* now recur on right child */
        //printInorder(node.right);
    //}*/
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		test ob = new test();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
			
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
			GfG g = new GfG();
            System.out.println(g.isBST(root));
			//ob.printInorder(root);
            t--;
			
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*  A Binary Search Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class GfG
{
    static List<Integer> list = new ArrayList<>();
    
    public static void inOrder(Node root)
    {
          if(root.left !=null)
          {
              inOrder(root.left);
          }
       
        list.add(root.data);
       
          if(root.right !=null)
          {
              inOrder(root.right);
          }
    }
    
    int isBST(Node root)  
    {
        if(root == null)
        {
            return 1;
        }
        
        inOrder(root);
        System.out.println(list);
        
        for(int i=0; i<list.size()-1; i++)
        {
            if(list.get(i)>list.get(i+1))
            {
                return 0;
            }
        }
        return 1;
    }
}