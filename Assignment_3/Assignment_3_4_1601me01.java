import java.util.*;

public class Assignment_3_4_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String text1 = scanner.nextLine();
		String text2 = scanner.nextLine();

		text1 = text1.toLowerCase().trim();
		text2 = text2.toLowerCase().trim();
		
	//string string 1 in hashmap
		HashMap<Character, Integer> map_text1 = new HashMap<>();
		for(char e : text1.toCharArray())
		{
			if(e != ' ')
			{
				if(map_text1.containsKey(e))
				{
					int value = map_text1.get(e);
					map_text1.put(e, value+1);
				}
				else
				{
					map_text1.put(e, 1);
				}
			}			
		}

	//checking for anagram
		boolean is_anagram = true;
		for(int i=0; i<text2.length(); i++)
		{
			char letter = text2.charAt(i);

			if(letter != ' ')
			{
				if(map_text1.containsKey(letter))
				{
					//System.out.println(letter + " is found");

					int value = map_text1.get(letter);
					if(value ==1)
					{
						map_text1.remove(letter);
					}
					else
					{
						map_text1.put(letter, value-1);
					}
				}
				else
				{
					//System.out.println(letter + " is not found");
					is_anagram = false;
					break;
				}
			}		
		}

		// for(char e: map_text1.keySet())
		// {
		// 	System.out.println(e+ ": " + map_text1.get(e));
		// }

	//showing result anagram or not
		if(map_text1.isEmpty() && is_anagram == true)
		{
			System.out.println("The input strings are Anagram");
		}
		else
		{
			System.out.println("Input strings are not Anagram");
		}

	}
}