class SqrtRoot
{
	public static void main(String[] args) 
	{
		System.out.println(sqrt(2147483647));	
	}

	static long sqrt(long num)
	{
		if (num == 0 || num == 1)  
       		return num; 

		long start = 0;
		long end = num;

		long ans = -1;

		while(start<=end)
		{
			long mid = start + (end-start)/2;

			if(mid*mid == num)
			{
				return mid;
			}
			else if(mid*mid < num)
			{
				start = mid+1;
				ans = mid;
			}
			else
				end = mid-1;
		}

		return ans;
	}
}