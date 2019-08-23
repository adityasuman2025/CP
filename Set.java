import java.util.*;
public class Set
{
	public static void main(String args[])
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(500);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(8);
		list.add(1);
		list.add(9);
		list.add(1);

		Set<Integer> hash_set = new HashSet<Integer>(list);
		Set<Integer> tree_set = new TreeSet<Integer>(hash_set);
		System.out.println(list);
		System.out.println(hash_set);
		System.out.println(tree_set);
	}
}