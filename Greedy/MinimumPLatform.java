import java.util.*;
import java.io.*;

/*
Minimum Platforms
Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.

Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal to departure of the other.

In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.

Input:
The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , where the first two charcters represent hour (between 00 to 23 ) and last two characters represent minutes (between 00 to 59).

Output:
For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] < D[i] <= 2359

Example:
Input:
2
6 
0900  0940 0950  1100 1500 1800
0910 1200 1120 1130 1900 2000
3
0900 1100 1235
1000 1200 1240 

Output:
3
1

Explanation:
Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.
*/

import java.util.*;
import java.io.*;
class MinimumPLatform
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(reader.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int n = Integer.parseInt(reader.readLine());
		    String[] arrivalsStr = reader.readLine().split(" ");
		    String[] departuresStr = reader.readLine().split(" ");
		    int[] arrivals = new int[n];
		    int[] departures = new int[n];
		    
		    for (int j=0 ; j<n ; j++) {
		        arrivals[j] = Integer.parseInt(arrivalsStr[j]);
		        departures[j] = Integer.parseInt(departuresStr[j]);
		    }
		    
		    int ans = solve(arrivals, departures);
		    System.out.println(ans);
	    }
	}
	
	static int solve(int arr[], int dept[])
    {
        int timeInt[] = new int[2400];
        for(int i=0; i<arr.length; i++)
        {
            for(int j= arr[i]; j<=dept[i]; j++)
            {
                timeInt[j]++;
            }
        }
        
        int max = timeInt[0];
        for(int i=0; i<2400; i++)
        {
            if(timeInt[i]>max)
                max = timeInt[i];
        }
        
        return max;
    }
}