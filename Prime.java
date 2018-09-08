import java.util.*;
import java.lang.*;
import java.io.*;

class Prime 
{
    public static boolean isPrime(int N)
	{
		if(N <=5)
		{
			return false;
		}
		
		for(int i=2; i*i<=N; i++)
		{
			if(N%i ==0)
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