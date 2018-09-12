public class longestPalindSubString
{
	static void longest(String arr)
	{
		int n = arr.length();

		boolean table[][] = new boolean[n][n];
		int max_len = 1;
		int start = 0;

	//palindrome of length of 1 character
		for(int i=0; i<n; i++)
		{
			table[i][i] = true;
		}

	//checking for palindrome of length of 2 characters
		for(int i=0; i<n-1; i++)
		{
			table[i][i+1] = false;
			if(arr.charAt(i) == arr.charAt(i+1))
			{
				table[i][i+1] = true;
				start = i;
				max_len = 2;
			}
		}

	//checking for palindrome of length greater than 2
		for(int k=3; k<=n; k++)
		{
			for(int i=0; i<n-k+1; i++)
			{
				int j = i+k-1; // getting index of the last character in that check

				if(arr.charAt(i) == arr.charAt(j) && table[i+1][j-1]) //if first character and last character matches then it wll a palindrome
				{
					table[i][j] = true;

					if(k>max_len) //this length is greater than the previous palindrome length
					{
						max_len = k;
						start = i;
					}
				}
			}
		}

		System.out.println("length of maximum palindrome substring is: " + max_len);
		System.out.println("The sub string is: " + arr.substring(start, start+max_len));
	}

	public static void main(String[] args) {
		longest("GEEKEG");
	}
}