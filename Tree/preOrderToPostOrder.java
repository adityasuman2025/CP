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
	        
	        int preOrder[] = new int[N];
	        for(int i =0; i<N; i++)
	        {
	            preOrder[i] = Integer.parseInt(arr[i]);
	        }
	        
	        int inOrder[] = preOrder.clone();
	        Arrays.sort(inOrder);
	        
	        printPostOrder(inOrder, preOrder, N);
	        System.out.println();
	    }
	}
	
	static void printPostOrder(int inOrder[], int preOrder[], int n) //inOrder array, postOrder array, size of array
	{
	    int root = Arrays.binarySearch(inOrder, preOrder[0]);
	    
	    if(root != 0)
	        printPostOrder(inOrder, Arrays.copyOfRange(preOrder, 1, n), root);
	        
        if(root != n-1)
	        printPostOrder(Arrays.copyOfRange(inOrder, root+1, n), Arrays.copyOfRange(preOrder, root+1, n), n-1-root);
	        
        System.out.print(preOrder[0] + " ");
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