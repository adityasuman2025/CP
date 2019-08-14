import java.util.*;

class kthLargestInAStream
{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        int K = scanner.nextInt();
	        int N = scanner.nextInt();
	        
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = scanner.nextInt();
	        }
	        
	        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
	        
	        for(int i=0; i<K-1; i++)
	        {
	            System.out.print("-1 ");
	            
	            pQueue.add(arr[i]);
	        }
	       
	        for(int i=K-1;i<N;i++)
	        {
                pQueue.add(arr[i]); 
                
                if(i != K-1)
                    pQueue.poll(); 
                    
                System.out.print(pQueue.peek() + " ");
        	} 
	  
	        System.out.println();
	    }
	}
}