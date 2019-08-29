import java.util.*;
import java.io.*;

/*
Distinct occurrences
Given two strings S and T, find count of distinct occurrences of T in S as a sub-sequence. Your task is to complete the function subsequenceCount which takes two strings as argument S and T and returns the count of the sub-sequences.

Input:
The first line of input contains an integer t denoting the no of test cases . Then t test cases follow. The first line of each test case contains 2 strings S and T.

Output:
For each test case in a new line print the count of distinct occurrences of T in S as a sub-sequence.

Constraints:
1<=t<=100
1<=length of (S,T)<=100

Example(To be used only for expected output):
Input
2
banana ban
geeksforgeeks ge

Output
3
6

Explanation:
(i) For first test case  S = banana, T = ban there are 3 sub-sequences which are [ban], [ba n], [b an].
(ii) For second test case S = geeksforgeeks, T=ge there are 6 sub-sequences which are  [ge], [ ge], [g e], [g e] [g e] and [ g e].
*/

class CountOfSubStringInString
{
    static int c = 0;
    int subsequenceCount(String a, String b)
    {
        int m = a.length(); 
        int n = b.length(); 
      
        int lookup[][] = new int[m + 1][n + 1]; 
      
        // If second string is empty 
        for (int i = 0; i <= m; ++i) 
            lookup[i][0] = 1; 
      
        // If first string is empty 
        for (int i = 0; i <= n; ++i) 
            lookup[0][i] = 0; 
          
        for (int i = 1; i <= m; i++) 
        { 
            for (int j = 1; j <= n; j++) 
            { 
                // If last characters are  
                // same, we have two options - 
                // 1. consider last characters  
                //    of both strings in solution 
                // 2. ignore last character 
                //    of first string 
                if (a.charAt(i - 1) == b.charAt(j - 1)) 
                    lookup[i][j] = lookup[i - 1][j - 1] + lookup[i - 1][j]; 
                      
                else
                    // If last character are  
                    // different, ignore last 
                    // character of first string 
                    lookup[i][j] = lookup[i - 1][j]; 
            } 
        } 
      
        return lookup[m][n]; 
    }
}