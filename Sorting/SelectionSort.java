public class SelectionSort
{
	public static void main(String args[])
	{
	//creating and printing the initial array
		int arr[] = {1,9,5,1000,4,8,11,89,6,7,2,3,10};

		for(int k: arr)
		{
			System.out.print(k + ", ");
		}

	//sorting the array
		for(int i=0; i<arr.length-1; i++)
		{
			int min = arr[i];
			int index = i;

			for(int j=i+1;j<arr.length; j++)
			{
				if(arr[j]<min)
				{
					index = j;
					min = arr[j];
				}
			}

		//swaping min with that
			int temp = arr[i];
			arr[i] = min;
			arr[index] = temp;
		}

	//printing the sorted array
		System.out.println("");
		for(int k: arr)
		{
			System.out.print(k + ", ");
		}
	}
}