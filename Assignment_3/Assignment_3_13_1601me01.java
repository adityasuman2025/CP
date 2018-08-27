import java.util.*;

public class Assignment_3_13_1601me01
{
//function to reverse characters of the string
	public static String reverse(String text)
	{
		char rev_arr[] = new char[text.length()];
		for(int i= text.length()-1, j=0; i>=0; i--, j++)
		{
			rev_arr[j] = text.charAt(i);
		}

		return new String(rev_arr);
	}

//main fucntion
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
	//taking input string and splitting it
		String text = scanner.nextLine();
		String data[]= text.split("\\ ");

		//System.out.println(Arrays.toString(data));

	//doing operation as asked in the qstn
		int arr_len = data.length;
		int mid = arr_len/2;

		for(int i =0; i<=mid; i++)
		{
			if(i==0)
			{
				String temp = data[i];
				data[i] = data[arr_len-1-i];
				data[arr_len-1-i] = temp;
			}
			else //needed to reverse characters of the string for the middles one
			{
				if(mid %2 ==0 && i ==mid)
				{

				}
				else
				{
					String temp = reverse(data[i]);
					data[i] = reverse(data[arr_len-1-i]);
					data[arr_len-1-i] = temp;
				}				
			}
		}

	//printing the output
		//System.out.println(Arrays.toString(data));
		for(String e : data)
		{
			System.out.print(e+ " ");
		}
	}
}