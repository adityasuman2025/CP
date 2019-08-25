import java.util.*;
import java.lang.*;
import java.io.*;

/*
Return two prime numbers
Given an even number (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair. 

NOTE: A solution will always exist, read Goldbach’s conjecture. Also, solve the problem in linear time complexity, i.e., O(n).

Input:
The first line contains T, the number of test cases. The following T lines consist of a number each, for which we'll find two prime numbers.

Note: The number would always be an even number.

Output:
For every test case print two prime numbers space separated, such that the smaller number appears first. Answer for each test case must be in a new line.

Constraints:
1 ≤ T ≤ 70
1 ≤ N ≤ 10000

Example:
Input:
5
74
1024
66 
8
9990

Output:
3 71
3 1021
5 61
3 5
17 9973
*/

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