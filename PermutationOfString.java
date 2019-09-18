import java.util.*;

class PermutationOfString
{
	static TreeSet<String> set = new TreeSet<String>();

	public static void main(String[] args) 
	{
		String str = "ABC";
		
		permute(str, 0);

		System.out.println(set);
	}

	static void permute(String str, int indexToSwap)
	{
		int N = str.length();	
		if(indexToSwap>=N)
			return;		

		for(int i=indexToSwap; i<N; i++)
		{			
			String str1 = swap(str, indexToSwap, i);		
			set.add(new String(str1));

			if(indexToSwap+1<N-1) //to avoid swap b/w last same elements
				permute(str1, indexToSwap+1);
		}
	}

	static String swap(String str, int indexToSwap, int i)
	{
		char arr[] = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[indexToSwap];
		arr[indexToSwap] = temp;

		return new String(arr);
	}
}