/*

https://practice.geeksforgeeks.org/problems/interleaved-strings/1

https://leetcode.com/problems/interleaving-string/

Interleaved Strings
Given three strings A, B and C your task is to complete the function isInterleave which returns true if C is an interleaving of A and B else returns false. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.

Input:
The first line of input contains an input T denoting the no of test cases. Then T test cases follow. Each test case contains three space separated strings A, B, C.

Output:
For each test case output will be 1 if C is interleaving of string A and B else 0.

Constraints:
1<=T<=100
1<=length of A, B, C <=100

Example(To be used only for expected output):
Input:
2
YX  X  XXY
XY X XXY

Output
0
1

Explanation:
1. For first test case XXY is not interleaving of YX and X
2. For the sec test case XXY is interleaving of XY and X.
*/

class InterleavedStrings
{
	public boolean isInterLeave(String s1,String s2,String s3)
	{
        int a=s1.length(),b=s2.length(),c=s3.length();
        
        if(a + b != c)
            return false;
              
        boolean dp[][] = new boolean[a+1][b+1];
        
        for(int i=0; i<=a; i++)
        {
            for(int j=0; j<=b; j++)
            {
                int len = i+j-1;
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(i==0)
                {
                    if(s2.charAt(j-1) == s3.charAt(len))
                        dp[i][j] = dp[i][j-1];
                }
                else if(j==0)
                {
                    if(s1.charAt(i-1) == s3.charAt(len))
                        dp[i][j] = dp[i-1][j];
                }
                else
                {
                    boolean A = false;
                    boolean B = false;
                    if(s2.charAt(j-1) == s3.charAt(len))                    
                        A = dp[i][j-1];
                    
                    if(s1.charAt(i-1) == s3.charAt(len))
                        B = dp[i-1][j];
                    
                    if(A || B)
                        dp[i][j] = true;
                }
            }
        }
        
        // for(boolean arr[]: dp)
        // {
        //     System.out.println(Arrays.toString(arr));
        // }
        
        return dp[a][b];
	}
}
