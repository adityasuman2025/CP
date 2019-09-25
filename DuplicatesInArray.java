/*

https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1

Find duplicates in an array
Given an array A[], Your task is to complete the function printDuplicates which prints the duplicate elements of the given array. If no duplicate element is found  print -1.

Note: Auxiliary Space must be O(1) and Time complexity must be O(n).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N which denotes number of elements of Array. Second line of each test case contains N space separated integers denoting elements of Array A[].

Output:
Print the duplicate elements from the array.The order of the output should be as the element found to be repeated.

Constraints:
1<=T<=100
1<=N<=50
0<=A[]

Example:
Input:
2
4
0 3 1 2
5
2 3 1 2 3 
Output:
-1
2 3 
*/

class DuplicatesInArray
{
    public static void printDuplicates(int arr[], int N)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
        {
            int index = arr[i]%N;
            arr[index] += N;
            
            if(arr[index]/N == 2)
            {
                sb.append(index + " ");
            }
        }
        
        //System.out.println(java.util.Arrays.toString(arr));
        
        if(sb.length() == 0)
            System.out.print(-1);
        else
            System.out.print(sb.toString());
    }
}