import java.lang.*;
import java.io.*;

class addingArrayELementsTillAllGreaterThanK {
	public static void main (String[] args)throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0)
		{
		    String[] p = br.readLine().split(" ");
		    int n = Integer.parseInt(p[0]);
		    int k = Integer.parseInt(p[1]);
		    
		    String[] arr = br.readLine().split(" ");
		    int[] a = new int[n];
		    
		    
		    for(int i=0;i<n;i++)
		        a[i] = Integer.parseInt(arr[i]);
		    
/* *********************************************  1) sort the array ********************************************************* */
		    Arrays.sort(a);
		    
/* ********************************  2) find index of rightmost element less than k ***************************************** */		  
		    int index_small_k = 0;
		    for(int i=0;i<n;i++)
		       if(a[i]<k)
		        index_small_k = i;

/* ******************************** 3) Use pointers, left = 0 and right (found in 2) ***************************************** */		  		       
	    
	      int left = 0;
	      int right = index_small_k;
	      int count = 0;
	      
/* *********************************   4) while (left < right) ***************************************** */		  		       
      
	      while(left<right)
	      {
	        if(a[left] + a[right] >= k)
	        {
	            a[right] = a[left] + a[right];
	            a[left] = -1;
	            left++;
	            right--;
	            count++;
	        }
	        else
	        {
	            left++;   
	        }
	      }
	    
 /* ********************************* 5) Now make a heap and insert elements into the heap except -1 ***************************************** */		  		       
	 
	   
	     PriorityQueue<Integer> q = new PriorityQueue<>();
		    
		        for(int i=0;i<n;i++)
		        if(a[i]!=-1)
		            q.add(a[i]);
		    
		        
		    
		    while(q.size()>0 && q.peek()<k)
	        {
	            if(q.size()>1)
	            {
	                q.add(q.poll()+q.poll());
	                count++;    
	            }
	            else{
	                count = -1;
	                break;
	            }
	            
	        }
	        
	        System.out.println(count);
		    
		    
		}
	}
}