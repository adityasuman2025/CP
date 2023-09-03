import java.util.*;
import java.lang.*;
import java.io.*;

/*
Palindromic Array
You are given an array A of size N. Your task is to find the minimum number of operations needed to convert the given array to 'Palindromic Array'.

Palindromic Array:
[23,15,23] is a ‘Palindromic Array’ but [2,0,1] is not.

The only allowed operation is that you can merge two adjacent elements in the array and replace them with their sum.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N, where N is the size of array.
The second line of each test case contains N space separated integers which is the input for the array.

Output:
Output the minimum number of operations required to make the given array a palindromic array.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
2
5
3 2 3 3 5
4
5 3 3 4
Output:
1
3

Explanation:
For Test Case 1: [3 2 3 3 5] after merging the 1st two elements 3 and 2, we get the array as [5 3 3 5] which is a palindrome, hence only 1 operation is needed.
*/

class PalindromicArray
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuffer sb = new StringBuffer();
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("\\s+");
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = Integer.parseInt(input[i]);
            }
            int count = 0;
            int i = 0;
            int j=n-1;
            int iSum = arr[i]; //Accumulate sum from left
            int jSum = arr[j]; //Accumulate sum from right

            while(i<j)
            {
                if(iSum==jSum)
                {
                    iSum = arr[i+1]; //Reset sum to next element in case both are equal.
                    jSum = arr[j-1];
                    i++;
                    j--;
                }
                else if(iSum>jSum)
                {
                    count++;
                    jSum+=arr[j-1]; //if sum on left is > than right then merge on right side.
                    j--;
                }
                else
                {
                    count++;
                    iSum+=arr[i+1]; //Merge on left
                    i++;
                }
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}