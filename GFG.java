import java.util.*;
import java.io.*;
class GFG
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = Integer.parseInt(bf.readLine());
	        String str[] = bf.readLine().split(" ");
	        
	        int arr[] = new int[N];
	        ArrayList<Integer> listArray = new ArrayList<>();
	        for(int i=0; i<N; i++)
	        {
	            arr[i] = Integer.parseInt(str[i]);
	            listArray.add(arr[i]);
            }
            
            int arr2[] = new int[N];
            arr2 = arr.clone();
            Arrays.sort(arr2);
            
            ArrayList<Integer> list = new ArrayList<>();            
            for(int i=0; i<N; i++)
            {
                int temp = arr2[i];               
                int index = listArray.indexOf(temp); 
                
                list.add(index);
            }
            
            // System.out.println(Arrays.toString(arr));
            // System.out.println(Arrays.toString(arr2));
            System.out.println(list);
	    }
	}
	
	static int binarySearch(int array[], int to_find)
	{
	    int left =0;
		int right = array.length-1;

		while(left <=right)
		{
			int mid = left+ ((right-left)/2);

			if(array[mid] == to_find)
			{
				return mid;
			}
			else if(to_find < array[mid])
			{
				right = mid -1;
			}	
			else
			{
				left = mid +1;
			}
		}

		return -1;
	}
}