import java.util.*;

public class Assignment_3_7_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String text1 = scanner.nextLine();

	//string string in hashmap
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

	//printing 
		for(char e: map_text1.keySet())
		{
			System.out.println(e+ ": " + map_text1.get(e));
		}
	}
}