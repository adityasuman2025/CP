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

//function to sort array using bubble sort
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
	static ArrayList<Integer> merge(ArrayList<Integer> arr2)
	{
		ArrayList<Integer> arr = new ArrayList<>(arr2);
		int count = 0;

		mergesort(arr, count);

		System.out.println("No of comparisions done: " + count);
		return arr;
	}

	static void mergesort(ArrayList<Integer> arr, int count)
	{
		int mid = arr.size()/2;

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

		mergearr(arr, left, right);
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
	}
}