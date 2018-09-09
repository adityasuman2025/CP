import java.util.*;
import java.lang.*;
import java.io.*;
class sumOfPrime
 {
    public static boolean isPrime(int N)
	{
		if(N ==1)
		{
			return false;
		}
		if(N ==2)
		{
			return true;
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
	    
	    for(int n = 0; n<T; n++)
	    {
	        String no = scanner.nextLine();
	        
	        ArrayList<Integer> primes = new ArrayList<>();
	        
	        int N = Integer.parseInt(no);
    		for(int i=2; i<N; i++)
    		{
    		    if(isPrime(i))
    			{
    				primes.add(i);
    			}
    		}
    		
    		int flag = -1;
    		for(int i : primes)
    		{
    		    int f = i;
    		    int s = N-i;
    		    
    		    if(primes.contains(s))
    		    {
    		        System.out.println(i + " " + s);
    		        flag =0;
    		        break;
    		    }
    		}
    		
    		if(flag == -1)
    		{
    		    System.out.println(-1);
    		}
	    }
	 }
}