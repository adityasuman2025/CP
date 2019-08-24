import java.util.*;
import java.io.*;

/*
Permutation with Spaces
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted increasing order of strings.

Input:  str[] = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Input:
First line contains the test cases T.  1<=T<=10
Each test case have one line string S of characters of length  N.  1<=N<=10

Output:
One line per test case, every string enclosed in ().(See example). Output should be printed in sorted order.

Example:
Input:
2
AB
ABC

Output:
(A B)(AB)
(A B C)(A BC)(AB C)(ABC)
*/

class PermutationWithSpaces
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        while(t-->0)
        {
            String s = in.next();
            find(s,0);
            System.out.println();
        }
    }
    
    public static void find(String s,int i)
    {
        //System.out.println(s);
        
        if(i==s.length()-1)
        {
            System.out.print("("+s+")");
            return;
        }
        
        find(s.substring(0,i+1)+" "+s.substring(i+1),i+2);
        find(s,i+1);
        return;
    }
}