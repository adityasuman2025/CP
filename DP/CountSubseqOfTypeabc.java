import java.util.*;
import java.io.*;
import java.util.regex.*;  

/*
Count subsequences of type a^i b^j c^k
Given a string s, the task is to count number of subsequences of the form aibjck, where i >= 1, j >=1 and k >= 1.

Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.


Examples:

Input  : abbc
Output : 3
Subsequences are abc, abc and abbc

Input  : abcabc
Output : 7
Subsequences are abc, abc, abbc, aabc
abcc, abc and abc


Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string s.

Output:
For each test case in a new line print the required output.

Constraints:
1<=T<=100
1<=Length of string <=100

Example:
Input:
2
abbc
abcabc
Output:
3
7
*/

class CountSubseqOfTypeabc
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String input = bf.readLine();
            
            int aCount=0;
		    int bCount=0;
		    int cCount=0;
		    for(int i=0;i<input.length();i++)
		    {
		        if(input.charAt(i)=='a')
		            aCount=(1+2*aCount);
		        else if(input.charAt(i)=='b')
		            bCount=(aCount + 2*bCount);
		        else if(input.charAt(i)=='c')
		            cCount=(bCount + 2*cCount);
		    }
		    System.out.println(cCount);
	    }
	}
	
}