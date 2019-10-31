import java.util.*;
import java.io.*;

/*
Smallest window in a string containing all the characters of another string
Given a string S and text T. Output the smallest window in the string S having all characters of the text T. Both the string S and text T contains lowercase english alphabets.

Input:
First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. Each test contains 2 lines having a string S and next line contains text T.

Output:
Output the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.

Constraints:
1 <= T <= 100
1 <= |N|, |X| <= 1000

Example:
Input:
2
timetopractice
toc
zoomlazapzo
oza

Output:
toprac
apzo

Explanation:
Testcase 1: "toprac" is the smallest substring in the given string S which contains every characters of T.
*/

class MinimumWindowSubString
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int L = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<L; t++)
	    {
	        String S = bf.readLine();
	        String T = bf.readLine();
	        
	        String ans = solve(S, T);
	        System.out.println(ans);
	    }
	}
	
	static String solve(String S, String T)
	{
	     if(T.length()>S.length() || T.length()==0)
	         return "-1";
	    
	  //creating map for loopkup of required character of string T in S
	     HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
	     for(int i=0;i<T.length();i++)
	     {
	         if(hm.containsKey(T.charAt(i)))
	         {
	             hm.put(T.charAt(i),hm.get(T.charAt(i))+1);
	         }
	         else
	         {
	             hm.put(T.charAt(i),1);
	         }
	     }
	     
	     int ml=0;
	     int right=0;
	     int left=0;
	     int min=S.length()+1;
	     int count=0;
	     
	     for(right=0; right<S.length(); right++)
	     {
            if(hm.containsKey(S.charAt(right)))
            {
                hm.put(S.charAt(right), hm.get(S.charAt(right))-1);
                if(hm.get(S.charAt(right))>=0)
                    count++;
            }
            
            while(count==T.length())
            {
                if(right-left+1 < min)
                {
                    ml = left;
                    min = right-left+1;
                }
                if(hm.containsKey(S.charAt(left)))
                {
                    hm.put(S.charAt(left), hm.get(S.charAt(left))+1); 
                    if(hm.get(S.charAt(left))>0)
                        count--;
                }
                left++;
            }
	    }
	    
	    if(min>S.length())
	         return "-1";
	    
	    return S.substring(ml,ml+min);
	}
}