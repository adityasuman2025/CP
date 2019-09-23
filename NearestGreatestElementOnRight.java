import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/save-gotham/0

Save Gotham!
Gotham has been attacked by Joker . Bruce Wayne has deployed automatic machine gun at each tower of Gotham.
All the towers in Gotham are in straight line.
You are given no of towers 'n' followed by height of 'n' towers.
For every tower(p), find the height of the closest tower (towards the right), greater than the height of tower(p).
Now , Print sum of all such heights (mod 1000000001).

Note : If for a tower(k) , no such tower exsits then take its height as 0.

Input:
First line of the input contains t, the number of test cases. First line of each test case contains 'n' denoting no of towers.
This is followed by 'n' spaced integers h1,h2.....h(n) representing height of towers. 

Output:
On a single line, output the sum(mod 1000000001). 
 

Constraints:
1<=t<=100
1<=n<=18000
0<=a[i]<=100000


Example:

Input:
1
9
112 133 161 311 122 512 1212 0 19212
 

Output:
41265

Explanation :
nextgreater(112) : 133
nextgreater(133) : 161
nextgreater(161) : 311
nextgreater(311) : 512
nextgreater(122) : 512
nextgreater(512) : 1212
nextgreater(1212) : 19212
nextgreater(0) : 19212
nextgreater(19212) : 0

add = 133+161+311+512+512+1212+19212+19212+0 = 41265.

Expected Time complexity - O(n).
*/

class NearestGreatestElementOnRight
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str[] = bf.readLine().split(" ");
	        
	        int arr[] = new int[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
            }
            
            solve(arr, N);
	    }
	}
	
	static void solve(int arr[], int N)
	{
    	int res[] = new int[N];
    	res[N-1] = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(arr[N-1]);
        
		for(int i=N-2; i>=0; i--)
		{
		    if(stack.peek()>arr[i])
		    {
		        res[i] = stack.peek();
		    }
		    else
		    {
		        while(!stack.isEmpty() && stack.peek()<=arr[i])
		        {
		            stack.pop();
		        }
		        if(!stack.isEmpty())
		            res[i] = stack.peek();
		    }
		    
		    stack.push(arr[i]);
		}

        long sum = 0;
        for(int i=0; i<N; i++)
        {
            sum += res[i];
        }
        
        //System.out.println(Arrays.toString(res));
		System.out.println(sum%1000000001);
	}
}