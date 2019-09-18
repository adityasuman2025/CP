import java.util.*;
import java.io.*;

/*
Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is n,n is the number.

Output:

Print the greater number than n with same set of digits and if not possible then print "not possible" without double quote.

Constraints:

1 ≤ T ≤ 100
1 ≤ n ≤ 100000

Example:

Input
2
143
431

Output
314
not possible
*/

class NextGreatestNumber
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str[] = bf.readLine().split(" ");
	        
	        int arr[] = new int[N]; //stores number
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
            }
            
            int i = N-1;
            while(i>0 && arr[i-1]>=arr[i])
            {
                i--;
            }
            //System.out.println(i);
            
            StringBuilder sb = new StringBuilder();
            if(i == 0) //if the given no is largest no
            {
               sb.append("Not possible ");
            }
            else
            {
                int min = arr[i];
                int minIndex = i;
                
            //checking the position/index after which we can do changes
                for(int j = i; j<N; j++)
                {
                    if(arr[j]<min && arr[j]>arr[i-1])
                    {
                        min = arr[j];
                        minIndex = j;
                    }
                }
                
            //swapping that element with the samllest no after it
                int temp = arr[i-1];
                arr[i-1] = arr[minIndex];
                arr[minIndex] = temp;
             
            //sorting elements after i    
                int sort[] = new int[N-i];
                for(int k=i; k<N; k++)
                {
                    sort[k-i] = arr[k];
                }
                Arrays.sort(sort);
                
            //storing ans in string    
                for(int k=0; k<i; k++)
                {
                    sb.append(arr[k] + " ");
                }
                for(int k=0; k<sort.length; k++)
                {
                    sb.append(sort[k] + " ");
                }
                
                // System.out.println(Arrays.toString(arr));
                // System.out.println(Arrays.toString(sort));
            }
            
            System.out.println(sb.toString());
	    }
	}
}