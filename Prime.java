import java.util.*;
import java.lang.*;
import java.io.*;

class Prime 
{
    public static boolean isPrime(int N)
    {
        if(N <= 1)
            return false;
    
        if(N <= 3)
            return true;

        if (N%2 == 0 || N%3 == 0) 
            return false; 
        
        for(int i=5; i*i<=N; i += 6)
        {
            if(N%i == 0 || N%(i+2) == 0)
            {
                return false;
            }
        }

        return true;
    }
	
    static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
        
        for(int i =0; i<T; i++)
        {
            int no = Integer.parseInt(scanner.nextLine());
            
            int x=1;
            int start = no;
            
            ArrayList<Integer> arr = new ArrayList<Integer>();
            
    		while(start>0)
    		{
    			if(isPrime(x))
    			{
    				arr.add(x);
    				start--;
    			}
    			x++;
    		}
            
            
            int count = no;
            for(int j=1; j<=no; j++)
            {
                for(int b : arr)
                {
                    if(j%b ==0)
                    {
                        no ++;
                        count++;
                    }
        				
                }   
            }
            
            System.out.println(count);
        }
	}
}