import java.util.*;
import java.io.*;

/*
Activity Selection
Given N activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. First line is N number of activities then second line contains N numbers which are starting time of activies.Third line contains N finishing time of activities.

Output:
For each test case, output a single number denoting maximum activites which can be performed in new line.

Constraints:
1<=T<=50
1<=N<=1000
1<=A[i]<=100

Example:
Input:
2
6
1 3 2 5 8 5
2 4 6 7 9 9
4
1 3 2 5
2 4 3 6

Output:
4
4
*/

class Activity
{
    int start, end, pos;
    
    Activity(int s, int e, int p)
    {
        start = s;
        end = e;
        pos = p;
    }
}

class CompareByEnd implements Comparator<Activity>
{
    public int compare(Activity a, Activity b)
    {
        return a.end - b.end;   
    }
}

class ActivitySelection
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int a=0; a<T; a++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str1[] = bf.readLine().split(" ");
	        String str2[] = bf.readLine().split(" ");
	        
	        ArrayList<Activity> arr = new ArrayList<>();
	        for(int i=0; i<N; i++)
	        {
	            int start = Integer.parseInt(str1[i]);
	            int end = Integer.parseInt(str2[i]);
	            
	            Activity at = new Activity(start, end, i);
	            arr.add(at);
            }
            Collections.sort(arr, new CompareByEnd());
            
            StringBuffer sb = new StringBuffer();
            
            int count = 0;
            int lastDoneEndTime = -1;
            for(int i=0; i<N; i++)
            {
                if(lastDoneEndTime == -1)//startting 1st activity
                {
                    lastDoneEndTime = arr.get(i).end;
                    count++;
                    
                    sb.append(arr.get(i).pos+1 + " ");
                }
                else
                {
                    if(arr.get(i).start >= lastDoneEndTime)
                    {
                        lastDoneEndTime = arr.get(i).end;
                        count++;
                        
                        sb.append(arr.get(i).pos+1 + " ");
                    }
                }
            }
            //System.out.println(sb);
            System.out.println(count);
	    }
	}
}