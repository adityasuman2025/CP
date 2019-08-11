import java.io.File; 
import java.util.*;


public class sort
{
//function to sort array using bubble sort	
	static ArrayList<Integer> bubble(ArrayList<Integer> arr2)
	{
		ArrayList<Integer> arr = new ArrayList<>(arr2);
		int n = arr.size();
		int count = 0;

		for(int i=0; i<n-1; i++)
		{
			int flag = 0;
			for(int j=0; j<n-i-1; j++)
			{
				if(arr.get(j)> arr.get(j+1))
				{
				//swap(arr.get(j), arr.get(j+1));
					int temp = arr.get(j);
					arr.set(j, arr.get(j+1));
					arr.set(j+1, temp);

					flag = 1;
					count++;
				}
			}

			if(flag ==0)
				break;
		}

		System.out.println("No of comparisions done: " + count);
		return arr;
	}

//function to sort array using insertion sort
	static ArrayList<Integer> insert(ArrayList<Integer> arr2)
	{
		ArrayList<Integer> arr = new ArrayList<>(arr2);
		int n = arr.size();
		int count = 0;

		for(int i=1; i<n; i++)
		{
			int value = arr.get(i);
			int hole = i;

			while(hole>0 && arr.get(hole-1)>value)
			{
			//swap(arr.get(hole), arr.get(hole-1))
				int temp = arr.get(hole-1);
				arr.set(hole-1, value);
				arr.set(hole, temp);

				hole--;
				count++;
			}
		}

		System.out.println("No of comparisions done: " + count);
		return arr;
	}

//function to sort array using selection sort
	static ArrayList<Integer> selection(ArrayList<Integer> arr2)
	{
		ArrayList<Integer> arr = new ArrayList<>(arr2);
		int n = arr.size();
		int count = 0;

		for(int i=0; i<n; i++)
		{
			int min = arr.get(i);
			int min_index = i;

			for(int j = i+1; j<n; j++)
			{
				if(arr.get(j) < min)
				{
					min = arr.get(j);
					min_index = j;
					count++;
				}
			}

		//swap(arr.get(min_index), arr.get(i))
			int temp = arr.get(i);
			arr.set(i, min);
			arr.set(min_index, temp);
			//count++;
		}

		System.out.println("No of comparisions done: " + count);
		return arr;
	}

//function to sort array using merge sort
	static int c_merge = 0;

	static ArrayList<Integer> merge(ArrayList<Integer> arr2)
	{
		ArrayList<Integer> arr = new ArrayList<>(arr2);
		
		mergesort(arr);
		System.out.println("No of comparisions done: " + c_merge);
		return arr;
	}

	static void mergesort(ArrayList<Integer> arr)
	{
		int n = arr.size();
		if(n<2)
		{
			return;
		}

		int mid = n/2;

		ArrayList<Integer> left = new ArrayList<>();
		for(int i=0; i<mid; i++)
		{
			left.add(arr.get(i));
		}

		ArrayList<Integer> right = new ArrayList<>();
		for(int i =mid; i<n; i++)
		{
			right.add(arr.get(i));
		}

		mergesort(left);
		mergesort(right);

		merge_arr(left, right, arr);
	}

	static void merge_arr(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> arr)
	{
		int i=0, j=0, k=0;

		while(i<left.size() && j<right.size())
		{
			if(left.get(i)<=right.get(j))
			{
				c_merge++;
				arr.set(k, left.get(i));
				i++;
			}
			else if(right.get(j) < left.get(i))
			{
				c_merge++;
				arr.set(k, right.get(j));
				j++;
			}
			k++;
		}

		while(i<left.size())
		{
			arr.set(k, left.get(i));
			i++;
			k++;
			//c_merge++;
		}

		while(j<right.size())
		{
			arr.set(k, right.get(j));
			j++;
			k++;
			//c_merge++;
		}
	}

//function to sort array using heap sort
	static int c_heap = 0;
	static ArrayList<Integer> heap(ArrayList<Integer> arr2)
	{
		ArrayList<Integer> arr = new ArrayList<>(arr2);
		int n = arr.size();

	//building heap
		for(int i = n/2-1; i>=0; i--)
		{
			heapify(arr, n, i);
		}	

	// One by one extract an element from heap 
		for(int i=n-1; i>=0; i--) 
		{
		//Move current root to end 
			int temp = arr.get(0);
			arr.set(0, arr.get(i));
			arr.set(i, temp);

			c_heap++;

		//call max heapify on the reduced heap 
			heapify(arr, i, 0); 
		}

		System.out.println("No of comparisions done: " + c_heap);
		return arr;
	}

	static void heapify(ArrayList<Integer> arr, int n, int i)
	{
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;

	//if left child is smallest than root
		if(l<n && arr.get(l)>arr.get(largest))
		{
			largest = l;
		}

	//if right child is smallest than root
		if(r<n && arr.get(r)>arr.get(largest))
		{
			largest = r;
		}

	//if smallest is not root then swapping it with the minimum
		if(largest !=i)
		{
			int temp = arr.get(i);
			arr.set(i, arr.get(largest));
			arr.set(largest, temp);

			c_heap++;
		
		//recursively heapifying the affected sub trees
			heapify(arr, n, largest);
		}
	}

//main function	
	public static void main(String[] args) throws Exception 
	{
		File file = new File("test.txt"); 
		Scanner sc = new Scanner(file); 

		ArrayList<Integer> list = new ArrayList<>();
		while (sc.hasNextLine()) 
			list.add(Integer.parseInt(sc.nextLine()));

		System.out.println("Input array is: ");
		System.out.println(list);
		System.out.println();

	//bubble sort	
		System.out.println("Sorting by Bubble Sort");
		System.out.println(bubble(list));
		System.out.println();

	//insertion sort	
		System.out.println("Sorting by Insertion Sort");
		System.out.println(insert(list));
		System.out.println();

	//selection sort	
		System.out.println("Sorting by Selection Sort");
		System.out.println(selection(list));
		System.out.println();

	//merge sort	
		System.out.println("Sorting by Merge Sort");
		System.out.println(merge(list));
		System.out.println();

	//heap sort	
		System.out.println("Sorting by Heap Sort");
		System.out.println(heap(list));
		System.out.println();
	}
}