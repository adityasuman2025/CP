import java.util.*;
import java.lang.*;
import java.io.*;

class maxAreaInHistogram
{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = scanner.nextInt();
	        
	        long arr[] = new long[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = scanner.nextLong();
	        }
	        
	        long maxArea = maxAreaHistogram(arr);
	        System.out.println(maxArea);
	    }
	}
	
	static long maxAreaHistogram(long arr[])
	{
	    int n = arr.length;
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    long area = 0;
	    long maxArea = 0;
	    
	    int i = 0;
	    while(i<n)
	    {
	        if(stack.empty() || arr[i] >= arr[stack.peek()]) //if stack is empty or 
	        {
	            stack.push(i++);
	            //i++;
	        }
	        else
	        {
	            int top = stack.pop();
	            
	            if(stack.empty())
	            {
	                area = arr[top]*i;
	            }
	            else
	            {
	                area = arr[top]*(i-stack.peek()-1);
	            }
	            
            //updating max area
	            if(area > maxArea)
	            {
                    maxArea = area;
                }
	        }
	    }
	    
	    while(!stack.empty())
	    {
	        int top = stack.pop();
	            
            if(stack.empty())
            {
                area = arr[top]*i;
            }
            else
            {
                area = arr[top]*(i-stack.peek()-1);
            }
            
        //updating max area
            if(area > maxArea)
            {
                maxArea = area;
            }
	    }
	    
	    return maxArea;
	}
}