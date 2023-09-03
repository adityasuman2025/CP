import java.util.*;
import java.io.*;

class KMP
{
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

	static boolean kmp(String str, String pattern)
	{
		int lps[] = lps(pattern);

		int i = 0; //for text
		int j = 0; //for pattern
		while(i<str.length() && j<pattern.length())
		{
			if(str.charAt(i) == pattern.charAt(j))
			{				
				i++;
				j++;
			}
			else
			{
				if(j!=0)
				{
					j = lps[j-1];
				}
				else
				{
					i++;
				}
			}
		 	
		 	if(j == pattern.length())
          		return true;
        }
        return false;
	}

	public static void main(String[] args) 
	{
		String str = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";

        //int lps[] = lps(pattern);
        System.out.println(kmp(str, pattern));
	}
}