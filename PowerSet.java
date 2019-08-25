import java.util.*;
import java.io.*;

/*
Power Set
Given a string of length n, print all the possible subsets of the string in a lexiographically-sorted order.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer n denoting the length of the string. The second line of each test case contains the string consisting of lower-case english alphabets.

Output:
For each testcase, in a new line, print all the possible subsets (except the null subset) in a sorted order with a space between each subset.

Constraints:
1<= T <=100
1<= n <=16

Example:
Input:
1
3
abc
Output:
a ab abc ac b bc c
*/

class PowerSet
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        String str = bf.readLine();
	        
	        list.clear();
	        printSubSeq(str, "");
	        Collections.sort(list);
	        
	        StringBuilder s = new StringBuilder();
	        for(String item: list)
	        {
	            s.append(item + " ");
	        }
	        System.out.println(s);
	    }
	}
	
	static ArrayList<String> list = new ArrayList<>();

	static void printSubSeq(String input, String output)
	{
		if(input.length() ==0)
		{
			if(output != "")
			{
				list.add(output);
			}
			return;
		}

		printSubSeq(input.substring(1), output);
		printSubSeq(input.substring(1), output+input.charAt(0));
	}
}