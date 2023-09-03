import java.util.*;
import java.io.*;

/*
String formation from substring
Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.  For example "abab" can be created by appending "ab" to "ab", but "abac" cannot be created by appending a substring to itself.

Input:
The first line contains T denoting the number of test cases. Then follows description of testcases. Each case contains a string.


Output:
For each test case, output "True" if it is possible and "False" if not.
 

Constraints:
1<=T<=100
1<=Length of String<=1000 
 

Example:
Input:
1
abcabcabc

Output:
True

Explanation :
The given string is 3 times repetition of "abc"
*/

class StringFormationFromSubstring
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String str = bf.readLine();
	        int n = str.length();
	        
	        if(n==1)
            {
                System.out.println("False");
                continue;
            }
            
	        int lps[] = lps(str);
	        //System.out.println(Arrays.toString(lps));
	        
	        int length = n - lps[n-1];
	       // System.out.println(length);
	        
	        int flag = 1;
	        if(n%length !=0 || lps[n-1] == 0)
	            flag = 0;
	        else
	        {
	            for(int i=0; i<n; i++)
                {
                    if(str.charAt(i%length) != str.charAt(i))
                    {
                        flag=0;
                        break;
                    }
                }
	        }
	        
	        if(flag == 0)
                System.out.println("False");
            else
                System.out.println("True");
	    }
	}

    static int[] lps(String pattern)
	{
		int n = pattern.length();

		int lps[] = new int[n];

		int j=0;
		int i=1;
		while(i<n)
		{
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				lps[i] = j+1;
				i++;
				j++;
			}
			else
			{
				if(j!=0)
					j = lps[j-1];
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}

		return lps;
	}
}