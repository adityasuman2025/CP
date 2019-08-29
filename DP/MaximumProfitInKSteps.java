import java.util.*;
import java.lang.*;
import java.io.*;

/*
In stock market , a person buys a stock and sells it on some future date. Given the stock prices of N days in an form of an array A[ ] and a positive integer K, find out the maximum profit a person can make in atmost K transactions. A transaction is equivalent to (buying + selling) of a stock and new transaction can start only when the previous transaction has been completed.

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
The first line of each test case contains a positve integer K, denoting the number of transactions.
The second line of each test case contains a positve integer N, denoting the length of the array A[ ].
The third line of each test case contains a N space separated positive integers, denoting the prices of each day in the array A[ ].


Output
Print out the maximum profit earned by the person.
No profit will be equivalent to 0.


Constraints
1 <= T <= 100
0 <   K <= 10
2 <= N <=30
0 <= A[ ] <= 1000

Examples 

Input
3
2
6
10 22 5 75 65 80
3
4
20 580 420 900
1
5
100 90 80 50 25

Output
87
1040
0
 

Explanation:
Output 1: Trader earns 87 as sum of 12 and 75  i.e. Buy at price 10, sell at 22, buy at  5 and sell at 80
Output 2: Trader earns 1040 as sum of 560 and 480 i.e. Buy at price 20, sell at 580, buy at 420 and sell at 900
Output 3: Trader cannot make any profit as selling price is decreasing day by day.Hence, it is not possible to earn anything.

Solution: 
Idea is to Find Max with position j(sell index) and check from 0 to j-1 (buy) 
Store it in dp array
Everytime when we find max we add maximum profit founded by k-1 steps and jth index sell ,
This will take O(n^2k)

If we can find 0 to j-1 then we can reduce complexity.
*/

class maxProfitDp
 {
  public static int maxProfitDp(int arr[],int k,int n)
  {
   int profit[][]=new int[k+1][n+1];
   for(int i=1;i<=k;++i)
   {
    int max=Integer.MIN_VALUE;
    for(int j=1;j<n;++j)
    {
     max=Math.max(max,profit[i-1][j-1]-arr[j-1]);
     profit[i][j]=Math.max(profit[i][j-1],max+arr[j]);
    }
   }
   return profit[k][n-1];
  }
 public static void main (String[] args)
  {
 Scanner ab=new Scanner(System.in);
 int t=ab.nextInt();
 while(t-->0)
 {
     int k=ab.nextInt();
     int n=ab.nextInt();
     int arr[]=new int[n];
     for(int i=0;i<n;++i)
     arr[i]=ab.nextInt();
     System.out.println(maxProfitDp(arr,k,n));
 }
  }
}