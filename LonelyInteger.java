public class LonelyInteger
{
	public static void main(String args[])
	{
		int arr[] = {1,2,3,3,1, 2, 5};

		int result =0;

		for(int value: arr)
		{
			result ^= value; //perform XOR Bitwise operation and find the lonely integer present in the array
			//System.out.println(result);
		}

		System.out.println(result);
	}
}