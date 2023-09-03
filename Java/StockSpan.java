import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/stock-span-problem/0/?ref=self

Stock span problem
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the size of the array. The second line of each test case contains N input C[i].

Output:
For each testcase, print the span values for all days.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ C[i] ≤ 800

Example:
Input:
2
7
100 80 60 70 60 75 85
6
10 4 5 90 120 80

Output:
1 1 1 2 1 4 6
1 1 2 4 5 1
*/

class StockSpan
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
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            
            int res[] = new int[N];
            for(int i=0; i<N; i++)
            {
                int c= 1;
                
                int temp = arr[i];
                
                while(!stack.isEmpty() && arr[i]>=arr[stack.peek()])
                    stack.pop();
                    
                if(stack.isEmpty())
                    res[i] = i+1;
                else
                    res[i] = i-stack.peek();
                    
                stack.push(i);
            }
            
            StringBuilder sb = new StringBuilder();
            for(int item: res)
                sb.append(item + " ");
                
            System.out.println(sb.toString());
	    }
	}
}