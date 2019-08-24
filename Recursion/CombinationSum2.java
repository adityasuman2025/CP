import java.util.*;
import java.io.*;

/*
Combination Sum - Part 2
Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

ach number in A may only be used once in the combination.

Note:
   All numbers will be positive integers.
   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
   The combinations themselves must be sorted in ascending order.
   If there is no combination possible the print "Empty" (without qoutes).
Example,
Given A = 10,1,2,7,6,1,5 and B(sum) 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

Input:
First is T , no of test cases. 1<=T<=500
Every test case has three lines.
First line is N, size of array. 1<=N<=12
Second line contains N space seperated integers(x). 1<=x<=9.
Third line is the sum B. 1<=B<=30.
 
Output:
One line per test case, every subset enclosed in () and in every set intergers should be space seperated.(See example)

Example:
Input:
2
7
10 1 2 7 6 1 5
8
5
8 1 8 6 8
12

Output:
(1 1 6)(1 2 5)(1 7)(2 6)
Empty
*/

class CombinationSum2
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
	            arr[i] = (Integer.parseInt(str[i]));
            }
            Arrays.sort(arr);
            
            int K = Integer.parseInt(bf.readLine().trim());
            
            List<List<Integer>> result =  new ArrayList<>();
            findCombination(arr, 0, K, new ArrayList<Integer>(), result);
            
            if(result.isEmpty())
                System.out.println("Empty");
            else
            {
                for(List<Integer> list: result)
                {
                    String s = "(";
                    for(int val: list)
                    {
                        s += (val + " ");
                    }
                    s = s.substring(0, s.length()-1);
                    s += ")";
                    
                    System.out.print(s);
                }
                System.out.println();
            }
	    }
	}
	
	static void findCombination(int arr[], int index, int target, List<Integer> current, List<List<Integer>> result)
	{
	    if(target ==0 )
	    {
	        result.add(new ArrayList<>(current));
	        return;
	    }
	    
	    if(target<0)
	        return;
	        
	    for(int i=index; i<arr.length; i++)
	    {
	        if(i == index || arr[i] != arr[i-1])
	        {
	            current.add(arr[i]);
	            findCombination(arr, i+1, target-arr[i], current, result);
	            current.remove(current.size()-1);
	        }
	    }
	}
}