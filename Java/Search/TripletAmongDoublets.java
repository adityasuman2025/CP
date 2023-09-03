import java.util.*;
import java.io.*;

class TripletAmongDoublets
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	   	int N = Integer.parseInt(bf.readLine().trim());
        String str[] = bf.readLine().split(" ");

        int arr[] = new int[N];
        for(int i=0; i<N; i++)
        {
        	arr[i] = Integer.parseInt(str[i]);
        }

        System.out.println(Arrays.toString(arr));

		System.out.println(findTriplet(arr));
	}

	static int findTriplet(int arr[])
	{
		int n = arr.length;

		int start = 0;
		int end = arr.length;

		while(start<=end)
		{
			int i = start + (end-start)/2;

		//case 1 // i = even // even no of elements behind that element
			if(i%2==0)//even
			{				
				//System.out.println(i + " is even");

				if(i-1>=0 && arr[i-1] != arr[i])
				{
					start = i+1;

					//System.out.println(arr[i-1] + " != " + arr[i]);
				}
				else
				{
					//System.out.println(arr[i-1] + " == " + arr[i]);

					if(i+1<n && arr[i+1] == arr[i])
					{
						//System.out.println(arr[i+1] + " == " + arr[i]);

						start = i+1;
					}
					else
					{
						//System.out.println(arr[i+1] + " != " + arr[i]);

						end = i-1;
					}
				}
			}	
			else //odd
			{
				// System.out.println(i + " is odd");

				if(i-1>=0 && arr[i-1] == arr[i])
				{
					//System.out.println(arr[i-1] + " == " + arr[i]);

					if(i+1<n && arr[i+1] == arr[i]) // triplet found
					{
						// System.out.println(arr[i+1] + " == " + arr[i]);
						// System.out.println("triplet found");
						return arr[i];
					}
					else
					{
						//System.out.println(arr[i+1] + " != " + arr[i]);

						start = i+1;
					}
				}
				else //triplet found
				{
					//System.out.println(arr[i-1] + " != " + arr[i]);

					//System.out.println("triplet found");

					return arr[i-1];
				}
			}
		}

		return -1;
	}
}