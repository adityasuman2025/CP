import java.util.*;
import java.io.*;

/*
Given a number line from -infinity to +infinity. You start at 0 and can go either to the left or to the right. The condition is that in i’th move, you take i steps. You are given a Destination , you have to print the minimum number of steps required to reach that destination.

Input:
The first line of the input contains the number of test cases T, then T lines follow and each lines contains an integer D specifying the destination.


Output:
Corresponding to each test case print in a new line the minimum number of steps required to reach that destination.

Constraints: 
1<=T<=100
0<=D<=1000

Example:
Input:
2
2
10

Output:
3
4

Explanation:

In the first test case we can go from 0 to 1 (1 step) and then from 1 to -1 (2 steps) and then from -1 to 2 (3 steps). So in 3 steps we have reached our destination by taking i steps in ith turn.
*/

class GFG
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int n = Integer.parseInt(bf.readLine().trim());
	        int reached = 0;
	        int steps = 0;
	        
	        while( reached<n )
	        {
	            steps++;
	            reached = reached + steps;
	        }
	        
	        if( reached > n )
	        {
	            int extra = reached - n ;
	            if( extra %2 !=0 )
	                steps++;
	        }
	        
	        System.out.println(steps);
	    }
	}
	
	static int steps(int source, int step, int dest) 
    { 
        // base cases 
        if (Math.abs(source) > (dest))  
            return Integer.MAX_VALUE; 
      
        if (source == dest)  
            return step; 
  
        step++;
        int pos = steps(source+step, step, dest);
        int neg = steps(source-step, step, dest);
        
        return Math.min(pos, neg);
    }
}