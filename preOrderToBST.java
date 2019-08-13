import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = scanner.nextInt();
	     
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            int val = scanner.nextInt();
	            arr[i] = val;
	        }
	        
	        boolean ans = canRepresentBST(arr, N);
	        
	        if(ans)
	            System.out.println(1);
	        else
	            System.out.println(0);
	    }
	}
	
	 static boolean canRepresentBST(int pre[], int n) 
	 { 
        // Create an empty stack 
        Stack<Integer> s = new Stack<Integer>(); 
  
        // Initialize current root as minimum possible 
        // value 
        int root = Integer.MIN_VALUE; 
  
        // Traverse given array 
        for (int i = 0; i < n; i++) { 
            // If we find a node who is on right side 
            // and smaller than root, return false 
            if (pre[i] < root) { 
                return false; 
            } 
  
            // If pre[i] is in right subtree of stack top, 
            // Keep removing items smaller than pre[i] 
            // and make the last removed item as new 
            // root. 
            while (!s.empty() && s.peek() < pre[i]) { 
                root = s.peek(); 
                s.pop(); 
            } 
  
            // At this point either stack is empty or 
            // pre[i] is smaller than root, push pre[i] 
            s.push(pre[i]); 
        } 
        return true; 
    } 
}