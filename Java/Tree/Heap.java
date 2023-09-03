import java.util.*;

//this is a min-heap
public class Heap
{
	ArrayList<Integer> heap = new ArrayList<>();

	public void shiftUp()
	{
		int k = heap.size() -1; //child/item index

		while(k>0)
		{
			int p = (k-1)/2; //parent index

			int item = heap.get(k);
			int parent = heap.get(p);

			if(parent>item) // becoz in heap (min-heap) parent is smaller than its child
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

			k = p;
		}
	}

	public void shiftDown()
	{
		int k = 0; //parent index
		int left = 2*k +1; //left-child index

		while(left < heap.size())
		{
			int max = left;
			right = left +1; //right-child index

			if(right<heap.size() && right>max) //if right child is greater than left child then making max index equal to right child index
			{
				max = right;
			}

			if(heap.get(k)<item.get(max)) //if parent < child then heap is all gud // nothing is required
			{
				break;
			}
			else //parent>child
			{
				int temp = heap.get(k);
				heap.set(k, heap.get(max));
				heap.set(max,temp);
			}

			k = max;
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