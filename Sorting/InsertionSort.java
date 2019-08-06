public class InsertionSort
{
	public static void main(String args[])
	{
	//creating and printing the initial array
		int arr[] = {1,9,5,0,4,8,11,89,6,7,500,3,10};

        for(int k: arr)
        {
            System.out.print(k + ", ");
        }
        System.out.println("");

    //sorting the array
        for(int i=1; i<arr.length; i++)
        {
        	int value= arr[i];
        	int hole =i;

        	// for(int j=i; j>0; j--)
        	// {
        	// 	if(value<arr[j-1])
        	// 	{
        	// 		int temp = arr[j-1];
        	// 		arr[j-1] = value;
        	// 		arr[j] = temp;
        	// 	}
        	// }

            while(hole>0 && value<arr[hole-1])
            {
            	int temp = arr[hole-1];
            	arr[hole-1] = value;
            	arr[hole] = temp;

            	hole--;
            }
        }

    //printing the sorted array
        for(int k: arr)
        {
            System.out.print(k + ", ");
        }
        System.out.println("");
	}
}