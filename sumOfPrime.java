import java.util.*;
import java.lang.*;
import java.io.*;
class sumOfPrime
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    ArrayList<Integer> primes = new ArrayList<>();
	    for(int i=2; i<10000; i++)
	    {
	        if(isPrime(i))
	            primes.add(i);
	    }
	    
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	   
	        int flag = 0;
	        StringBuilder str = new StringBuilder();
	        for(int i=N; i*i>=N; i--)
	        {
	            if(primes.contains(i))
	            {
	               if(primes.contains(N-i))
	               {
	                   str.append(N-i + " " + i);
	                   flag = 1;
	                   break;
	               }
	            }
	        }
	        
	        System.out.println(str.toString());
	    }
	}
	
    static boolean isPrime(int n)
    {
        if(n<=1)
            return false;
        if(n <=3)
            return true;
            
        if(n%2 == 0 || n%3 == 0)
            return false;
            
        for(int i=5; i*i<=n; i+=6)
        {
            if(n%i == 0 || n%(i+2) == 0)
                return false;
        }
        
        return true;
    }
}