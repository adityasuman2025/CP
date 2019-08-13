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
	        int N = Integer.parseInt(scanner.nextLine());
	        
	        String arr[] = scanner.nextLine().split(" ");
	        
	        int pre[] = new int[N];
	        for(int i =0; i<N; i++)
	        {
	            pre[i] = Integer.parseInt(arr[i]);
	        }
	        
	        int in[] = pre.clone();
	        Arrays.sort(in);
	        
	        printPostOrder(in, pre, N);
	        System.out.println();
	       // System.out.println(Arrays.toString(pre));
	       // System.out.println(Arrays.toString(in));
	    }
	}
	
	static void printPostOrder(int in[], int pre[], int n)
	{
	    int root = search(in, pre[0], n);
	    
	    if(root != 0)
	        printPostOrder(in, Arrays.copyOfRange(pre, 1, n), root);
	        
        if(root != n-1)
	        printPostOrder(Arrays.copyOfRange(in, root+1, n), Arrays.copyOfRange(pre, root+1, n), n-1-root);
	        
        System.out.print(pre[0] + " ");
	}
	
// A utility function to search x in arr[] of size n 
    static int search(int arr[], int x, int n) 
    { 
        for (int i = 0; i < n; i++) 
            if (arr[i] == x) 
                return i; 
        return -1; 
    } 
	
}