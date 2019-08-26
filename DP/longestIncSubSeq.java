import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class longestIncSubSeq 
{
	static void LIS(int arr[])
	{
	//making and intializing the count array with 1
		int count[] = new int[arr.length];
		for(int i =0; i<arr.length; i++)
		{
			count[i] =1;
		}
		
	//searching for longest subsequence
		for(int i=0; i<arr.length; i++)
		{	
			int val = arr[i];			
			for(int j=0; j<i; j++)
			{
				if(arr[i]>arr[j])
				{
					if(count[j]+1>count[i])
					{
						count[i] = count[j] +1;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(count));		

		Arrays.sort(count);
		int max_count = count[count.length -1];

		System.out.println("Maximum length of increasing subsequence: " + max_count);		

	//for finding the longest increasing subsequence		
		int max=0;
		int max_index = 0;
		for(int i =  count.length -1; i>=0; i--)
		{
			if(count[i] == max_count)
			{
				max = count[i];
				max_index = i;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = max_index; i>=0; i--)
		{
			if(arr[i]<=max)
			{
				list.add(arr[i]);
			}

			if(i == count.length-max_count-1)
			{
				break;
			}
		}
		Collections.reverse(list);

		System.out.println(list);
	}

	public static void main(String[] args) 
	{
		int arr[] = {3,4,-1,0,6,2,3};
		System.out.println(Arrays.toString(arr));

		LIS(arr);		
	}	
}