import java.util.*;
import java.io.*;

class CountOccurance
{
	static void mapSolution(String str)
	{
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);

			if(map.containsKey(c))
			{
				int val = map.get(c);
				map.put(c, val+1);
			}
			else
			{
				map.put(c,1);
			}
		}

		for(char key: map.keySet())
		{
			int val = map.get(key);
			System.out.print(key + "" + val + " ");
		}
		System.out.println();
	}

	static void arraySolution(String str)
	{
		int count[] = new int[26];
		boolean visited[] = new boolean[26];

		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);

			count[c-'a']++;
		}	

		for(int i=0; i<str.length(); i++)
		{
			char c = str.charAt(i);
			if(count[c-'a'] != 0)
			{				
				System.out.print(c + "" + count[c-'a'] + " ");

				count[c-'a'] = 0;
			}
		}		
		System.out.println();
	}

	public static void main(String[] args) {
		arraySolution("geeksforgeeks");
		mapSolution("elephant");
	}
}