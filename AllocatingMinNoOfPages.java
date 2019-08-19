import java.util.*;
import java.io.*;

/*
Allocate minimum number of pages
You are given N number of books. Every ith book has Pi number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. 

Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding).

Input:
The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
Each case begins with a single positive integer N denoting the number of books.
The second line contains N space separated positive integers denoting the pages of each book.
And the third line contains another integer M, denoting the number of students.


Output:
For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.

Constraints:
1<= T <= 100
1 <= N <= 106
1 <= A [ i ] <= 106
1 <= M <= 106

Example:
Input:
2
4
12 34 67 90
2
3
15 17 20

Output:
113
32

Explaination: Allocation can be done in following ways:
{12} and {34, 67, 90}     Maximum Pages = 191
{12, 34} and {67, 90}     Maximum Pages = 157
{12, 34, 67} and {90}        Maximum Pages = 113

Therefore, the minimum of these cases is 113, which is selected as output.
*/

class AllocatingMinNoOfPages
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = Integer.parseInt(bf.readLine());
	        
	        String str[] = bf.readLine().split(" ");
	        
            long start = Long.parseLong(str[0]);
            long end = 0;
            
	        long arr[] = new long[N];
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Long.parseLong(str[i]);
	            
	            if(arr[i]>start)
	                start = arr[i];
	                
	            end += arr[i];
            }
            
            long M = Long.parseLong(bf.readLine()); //no of students
           
            int ans = solve(arr, start, end, M);
            System.out.println(ans);
	    }
	}
	
	static int solve(long arr[], long start, long end, long K)
	{
	    long N = arr.length;
	    
	    if(N < K) 
	        return -1;
	    
	    start = 0;
	    
	    int ans = Integer.MAX_VALUE;
        while(start<=end)
        {
            long mid = start + (end-start)/2;
            
            if(isPossible(arr, K, mid))
            {
                ans = Math.min(ans, (int)mid);
                end = mid-1;
            }
            else
                start = mid+1;
        }
     
        return ans;       
	}
	
	static boolean isPossible(long arr[], long K, long ans)
	{
        long noOfStudents = 1;
        long currStudentPages = 0;
        
        for(int i=0; i<arr.length; i++)
        {
            if(currStudentPages+arr[i]<=ans)
            {
                currStudentPages += arr[i];
            }
            else
            {
                noOfStudents++;
                currStudentPages = arr[i];
                
                if(noOfStudents>K)
                    return false;
            }
        }
        
        return true;
	}
}