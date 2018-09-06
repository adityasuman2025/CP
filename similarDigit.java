import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class similarDigit 
{
	public static int findSimilar(int a, int b, int c)
	{
		String s_a = Integer.toString(a);
		String s_b = Integer.toString(b);
		String s_c = Integer.toString(c);

		HashMap<String, Integer> map = new HashMap<>();

		for(int i =0; i<s_a.length(); i++)
		{
			String key = s_a.substring(i, i+1);
			if(map.containsKey(key))
			{
				int val = map.get(key);
				map.put(key , val+1);
			}
			else
			{
				map.put(key ,1);
			}
		}

		for(int i =0; i<s_b.length(); i++)
		{
			String key = s_b.substring(i, i+1);
			if(map.containsKey(key))
			{
				int val = map.get(key);
				map.put(key , val+1);
			}
			else
			{
				map.put(key ,1);
			}
		}

		for(int i =0; i<s_c.length(); i++)
		{
			String key = s_c.substring(i, i+1);
			if(map.containsKey(key))
			{
				int val = map.get(key);
				map.put(key , val+1);
			}
			else
			{
				map.put(key ,1);
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String i : map.keySet())
		{
			int val = map.get(i);

			if(val == 3)
			{
				list.add(i);
			}			
		}
	
		return Integer.parseInt(list.get(0));
	}

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		System.out.println(findSimilar(a,b,c));
	}	
}