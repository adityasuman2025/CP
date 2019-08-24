import java.util.*;
import java.io.*;

/*
Combination Sum
Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B. The same repeated number may be chosen from A unlimited number of times.

Note:
        1. All numbers will be positive integers.
        2. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        3. The combinations themselves must be sorted in ascending order.

Input:
First line of input contains number of testcases T. For each testcase, there will be three lines of input, first of which contains N, size of array. Next line contains N space seperated integers, and the last line contains B.

Output:
For each testcase, print the sets enclosing a backet "(" and ")". No space between two sets. If no set can be formed with the given set, then print "Empty" (without quotes).

Constraints:
1 <= T <= 500
1 <= N <= 12
1 <= A[i] <= 9
1 <= B <= 30

Example:
Input:
3
4
7 2 6 5
16
11
6 5 7 1 8 2 9 9 7 7 9
6
4
2 4 6 8
8

Output:
(2 2 2 2 2 2 2 2)(2 2 2 2 2 6)(2 2 2 5 5)(2 2 5 7)(2 2 6 6)(2 7 7)(5 5 6)
(1 1 1 1 1 1)(1 1 1 1 2)(1 1 2 2)(1 5)(2 2 2)(6)
(2, 2, 2, 2)(2, 2, 4)(2, 6)(4, 4)(8)

Explanation:
Testcase 1: Required sets with sum equal to B (8) are as follows:
[2, 2, 2, 2]
[2, 2, 4]
[2, 6]
[4, 4]
[8]
*/

class CombinationSum
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str[] = bf.readLine().split(" ");
	        
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(int i=0; i<N; i++)
	        {
	            int temp = Integer.parseInt(str[i]);
	            
	            if(!arr.contains(temp))
	                arr.add(temp);
            }
            Collections.sort(arr);
            
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
	
	static void findCombination(ArrayList<Integer> arr, int index, int target, ArrayList<Integer> current, List<List<Integer>> result)
	{
	    if(target ==0 )
	    {
	        result.add(new ArrayList<>(current));
	        return;
	    }
	    
	    if(target<0)
	        return;
	        
	   for(int i = index; i<arr.size(); i++)
	   {
	       current.add(arr.get(i));
	       findCombination(arr, i, target-arr.get(i), current, result);
	       current.remove(current.size() -1);
	   }
	}
}