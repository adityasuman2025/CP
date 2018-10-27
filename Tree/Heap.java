import java.util.*;

//this is a min-heap
public class Heap
{
	ArrayList<Integer> heap = new ArrayList<>();

	public void shiftUp()
	{
		int k = heap.size() -1;

		while(k>0)
		{
			int p = (k-1)/2;

			int item = heap.get(k);
			int parent = heap.get(p);

			if(item<parent)
			{
			//swap that item with the parent
				int temp = heap.get(k);
				heap.set(k, heap.get(p));
				heap.set(p, temp);
			}
			else
			{
				break;
			}
		}
	}

	public void shiftDown()
	{
		int k = 0;
		int left = 2*k +1;

		while(left< heap.size())
		{
			int max = left;
			right = left +1;

			if(right<heap.size() && right>max)
			{
				max = right;
			}

			IF(heap.get(k))
		}
	}

	public static void main(String[] args) 
	{
		Heap h = new Heap();

		h.heap.add(1);
		h.heap.add(2);
		h.heap.add(3);
		h.heap.add(4);

		System.out.println(h.heap.get(0));
		//System.out.println(h.heap.get(5));
	}
}