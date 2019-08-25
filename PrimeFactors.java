import java.util.*;
import java.io.*;

/*
Prime Factors and their Powers
Given a number N, print all its unique prime factors and their powers in N.

N = 100
Factor Power
  2      2
  5      2

N = 35
Factor  Power
  5      1
  7      1
Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:
Print all prime factors and their powers separated by spaces.  The output should be printed in increasing order of prime factors.

Constraints:
1 ≤ T ≤ 200
2 ≤ N ≤ 10000

Example:
Input:
2
100
35

Output:
2 2 5 2
5 1 7 1
*/

class PrimeFactors
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        primeFactors(N);
	    }
	}
	
	static void primeFactors(int n)
	{
	    TreeMap<Integer, Integer> map = new TreeMap<>();
	    
	    while(n%2 ==0)
	    {
	        if(map.containsKey(2))
	        {
	            int val = map.get(2);
	            map.put(2, val+1);
	        }
	        else
	        {
	            map.put(2,1);
	        }
	        n = n/2;
	    }
	    
	    // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
	    for(int i=3; i*i<=n; i+=2)
	    {
	        while(n%i ==0)
	        {
    	        if(map.containsKey(i))
    	        {
    	            int val = map.get(i);
    	            map.put(i, val+1);
    	        }
    	        else
    	        {
    	            map.put(i,1);
    	        }
    	        n = n/i;
	        }
	    }
	    
	    if(n>2)
	        map.put(n,1);
	        
	    StringBuilder str = new StringBuilder();
	    for(int key: map.keySet())
	    {
	        int val = map.get(key);
	        
	        str.append(key + " " + val + " ");
	    }
	    
	    System.out.println(str.toString());
	}
}