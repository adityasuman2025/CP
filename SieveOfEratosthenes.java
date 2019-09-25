import java.util.*;
import java.io.*;

/*
Algo to find all the primes less than a number N
*/

class SieveOfEratosthenes
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        boolean primes[] = new boolean[N+1];
	        Arrays.fill(primes, true);
	        
	        for(int i=2; i*i<=N; i++)
	        {
	            if(primes[i])
	            {
	                for(int j=i*i; j<=N; j+=i)
	                {
	                    primes[j] = false;
	                }
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i=2; i<=N; i++)
	        {
	            if(primes[i])
	                sb.append(i + " ");
	        }
	        
	        System.out.println(sb.toString());
	    }
	}
}