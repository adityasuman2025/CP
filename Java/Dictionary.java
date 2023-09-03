import java.util.*;
import java.io.*;

public class Dictionary
{
	public static void main(String args[])
	{
		Map<Character, String> engSpan = new HashMap<>();

		engSpan.put('N', "Aditya Suman");
		engSpan.put('s', "1601ME01");
		engSpan.put('w', "World");
		engSpan.put('h', "Coding");

		System.out.println(engSpan.get('N'));

		// System.out.println(engSpan.keySet());
		// System.out.println(engSpan.values());

		for(char a : engSpan.keySet())
		{
			System.out.println(a + ": " + engSpan.get(a));
		}
	}
}