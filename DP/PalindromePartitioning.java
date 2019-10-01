import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/palindromic-patitioning/0

Palindromic patitioning
Given a string, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome. For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for palindrome partitioning of a given string. For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of every Test Case consists of S, denoting a String.

Output:
For each test case in a new line print an integer, denoting the number cuts in the String to make it palindromic.

Constraints:
1<=T<=100
1<=|Length of String|<=1000

Example:
Input:
2
ababbbabbababa
aaabba

Output:
3
1
*/

class PalindromePartitioning
{
	 static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String s = bf.readLine().trim();
            int N = s.length();
            
            boolean isPal[][] = new boolean[N][N];
            
        //creating palindrome table // longest palindromic subsequence    
            for(int i = 0; i <N; ++i) 
            {
                isPal[i][i] = true;
                if(i + 1 < N && s.charAt(i) == s.charAt(i+1)) 
                    isPal[i][i+1] = true;
            }
            
            for(int len = 3; len <= N; ++len) 
            {
                for(int i = 0; i + len-1 < N; ++i) 
                {
                    int j = i + len-1;
                    if(s.charAt(i) == s.charAt(j) && isPal[i+1][j-1])
                        isPal[i][j] = true;
                }
            }
            
            // for(boolean arr[]: isPal)
            // {
            //     System.out.println(Arrays.toString(arr));
            // }

        //checking cuts required //C[i] store minimum cut required to make splits of string[0..i] a palindrome
            int C[] = new int[N];
            for (int i = 0; i < N; i++) 
            { 
                if(isPal[0][i] == true) //if string[0..i] is already a palindrom then no cut is required
                    C[i] = 0; 
                else //cuts are required
                { 
                    C[i] = Integer.MAX_VALUE; 
                    for (int j = 0; j < i; j++) //cutting at jth position i.e string[0...j], string[j+1....i]
                    { 
                        if(isPal[j + 1][i] && C[i] > 1 + C[j]) 
                            C[i] = 1 + C[j]; 
                    } 
                } 
            } 
            System.out.println(C[N-1]);
	    }
	}
}