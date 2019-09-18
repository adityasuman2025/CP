class MaxSumForNonAdjacentElements
{
	public static void main(String[] args) 
	{	
		int arr[] = {5, 5, 10, 100, 10, 5};

		int inc = arr[0]; //max sum possible including that (ith) element
		int exc = 0; //max sum possible excluding that (ith) element

		for(int i=1; i<N; i++)
		{
			int temp = inc;
			inc = Math.max(inc, exc+arr[i]);

			exc = temp;
		}
		System.out.println(inc);
	}
}