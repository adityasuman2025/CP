import java.util.*;
import java.lang.*;
import java.io.*;

/*
Sum of bit differences
Write a program to find the sum of bit differences in all pairs that can be formed from array elements n. Bit difference of a pair (x, y) is a count of different bits at same positions in binary representations of x and y. For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).

Input: The first line of input contains an integer T denoting the number of test cases. First line of the test case will contain an array of elements n.
Output: The sum of bit differences of all pairs that can be formed by given array.
Constraints:

1 <=T<= 100

1 <=N<= 10

1 <=a[i]<= 10
Example:

Input:

2
2 
1 2
3 
1 3 5

Output:

4
8
*/

class SumOfBitDifferences
 {
	public static void main (String[] args)
	 {
        Scanner sc=new Scanner(System.in);
	    int tc=sc.nextInt();
	        while(tc--!=0)
	        {
	            int n=sc.nextInt();
	            int ar[]=new int[n];
	            for(int x=0; x<n; x++)
	                ar[x]=sc.nextInt();
	            
	            int sum=0;
	            for(int x=0; x<n-1; x++)
	            {
	                for(int y=x+1; y<n; y++)
	                {
	                    int bits=0;
	                    int diff=ar[x]^ar[y];
	                    while(diff>0)
	                    {
	                        diff=diff & (diff-1);
	                        bits++;
	                    }
	                    sum=sum+(2*bits);
	                }
	            }
	            System.out.println(sum);
	            
	        }   
	        
	 }
}