import java.util.*;
import java.io.*;

class RemoveAlternate
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<>();
		//list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);		
		//list.add(10);

		System.out.println(list);

		int start = 1;
		while(list.size()>1)
		{			
			list.remove(start);
		
			int N = list.size();
			System.out.println(list);

			start = (start+1)%N;
		}

		System.out.println(list);
	}
}