import java.util.*;
import java.io.*;

/*

https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

Stock buy and sell
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Input: 
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days. 

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
*/

class Interval
{
    int buy,sell;    
}

class StockBuySell
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
            
            stockBuySell(arr);
	    }
	}
	
	static void stockBuySell(int prices[])
	{
	    int n = prices.length;
	    
	    if(n==1)
	        return;
	    
	    ArrayList<Interval> sol = new ArrayList<Interval>(); 
	    
	    int i=0;
	    while(i<n-1)
	    {
	    //for getting buy day
	        while(i<n-1 && prices[i+1] <= prices[i])
	            i++;
	            
	        if(i == n-1)
	            break;
	            
	        Interval interval = new Interval();
	        interval.buy = i;
	        i++;
	        
	    //for getting sell day
	        while(i<n-1 && prices[i+1] >= prices[i])
	            i++;
	            
	        interval.sell = i;
	        sol.add(interval);
	    }
	    
	    if(sol.size() ==0)
	    {
	        System.out.println("No Profit");
	        return;
	    }
	    
	    for(Interval item: sol)
	    {
	        int buy = item.buy;
	        int sell = item.sell;
	        System.out.print("(" + buy + " " + sell + ") ");
	    }
	    System.out.println();
	}
}