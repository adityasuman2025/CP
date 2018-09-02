import java.util.*;

public class Hash
{
	public static void main(String[] args) {
		Map<Integer, List> map = new HashMap<>();

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		map.put(0, list);

		System.out.println(map.get(0));
	}
}