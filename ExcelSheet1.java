import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/excel-sheet/0

Excel Sheet | Part - 1
Given a positive integer N, print its corresponding column title as it would appear in an Excel sheet.
For N =1 we have column A, for 27 we have AA and so on.

Note: The alphabets are all in uppercase.

Input:
The first line contains an integer T, depicting total number of test cases. Then following T lines contains an integer N.

Output:
For each testcase, in a new line, print the string corrosponding to the column number.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107

Example:
Input:
1
51
Output:
AY
*/

class ExcelSheet1
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	        String ans = "";
	        
	        while(N>0)
	        {
	            int rem = N%26;
	            
	            if(rem==0)
	            {
	                ans = "Z" + ans;
	                
	                N = (N/26) - 1;
	            }
	            else
	            {
	                int k = 64 + rem;
	                ans = Character.toString((char)k) + ans;
	                
	                N = (N/26);
	            }
	        }
	        System.out.println(ans);
	    }
	}
}