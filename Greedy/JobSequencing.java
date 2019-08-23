import java.util.*;
import java.io.*;

/*
Given a set of N jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of an integer N in first line denoting the number of jobs and the next line consist of Job id, Deadline and the Profit associated to that Job.

Output:
Output the number of jobs done and the maximum profit.

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= Deadline <= 100
1 <= Profit <= 500

Example:
Input:
2
4
1 4 20 2 1 10 3 1 40 4 1 30
5
1 2 100 2 1 19 3 2 27 4 1 25 5 1 15

Output:
2 60
2 127

Explanation:
Testcase 1: 2 jobs can be done with maximum profit of 60.
*/

class Job
{
    int id, deadline, profit;
    
    Job(int i, int d, int p)
    {
        id = i;
        deadline = d;
        profit = p;
    }
}

class SortByProfit implements Comparator<Job>
{
    public int compare(Job a, Job b)
    {
        return b.profit - a.profit;   
    }
}

class JobSequencing
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str[] = bf.readLine().split(" ");
	        
	        Job arr[] = new Job[N];
	        boolean slot[] = new boolean[N];
	        
	        int k = 0;
	        for(int i=0; i<N*3; i+=3)
	        {
	            int id = Integer.parseInt(str[i+0]);
	            int d = Integer.parseInt(str[i+1]);
	            int p= Integer.parseInt(str[i+2]);
	            
	            Job job = new Job(id,d,p);
	            arr[k] = job;
	            
	            slot[k] = false;
	            
	            k++;
            }
            Arrays.sort(arr, new SortByProfit());
            
            int c = 0;
            int sum = 0;
             
            for(int i=0; i<N; i++)
            {
                for(int j = Math.min(N, arr[i].deadline) - 1; j>=0; j--)
                {
                    if(slot[j] == false) //that slot is free
                    {
                        slot[j] = true;
                        c++;
                        sum += arr[i].profit;
                        break;
                    }
                }
            }
            
            System.out.println(c + " " + sum);
	    }
	}
}