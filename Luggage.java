//imports for BufferedReader
import java.io.*;

//import for Scanner and other utility classes
import java.util.*;

class Luggage
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		int n = Integer.parseInt(t);

		ArrayList<int[]> arrays = new ArrayList<>();

		for(int i=0; i<n; i++)
		{
			String size_str = br.readLine();
			int size = Integer.parseInt(size_str);

			int temp_arr[] = new int[size];
			for(int j = 0; j< size; j++)
			{
				String val_str = br.readLine();
				int val = Integer.parseInt(val_str);

				temp_arr[j] = val;
			}
			arrays.add(temp_arr);
		}

		for(int i=0; i<arrays.size(); i++)
		{
			int array[] = arrays.get(i);
			int l = array.length;
			//System.out.println(Arrays.toString(array));

			String ans = "";
			for(int j =0; j<l; j++)
			{				
				int val = array[j];
				int count = 0;

				for(int k=j+1; k<l; k++)
				{
					if(array[k] < val)
					{
						count++;
					}
				}
				
				ans = ans + (count + " ");			
			}
			System.out.println(ans);
		}
	}
}