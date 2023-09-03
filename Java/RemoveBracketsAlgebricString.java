import java.util.*;

class RemoveBracketsAlgebricString
{
	public static void main(String[] args) 
	{
		String str = "a-(b+c)";
		int N = str.length();

		char arr[] = str.toCharArray();

		int change = 0; //0: no change, 1: change is required
		for(int i=0; i<N; i++)
		{
			if(arr[i] == '(' && i-1>=0 && arr[i-1] == '-')
			{
				System.out.println("bracket & - detected at index " + i);
				change++;

				arr[i-1] = '~';				

				if(change%2 != 0)//no change required				
					arr[i] = '-';				
				else				
					arr[i] = '+';	

				continue;			
			}
			else if(arr[i] == '(' && i-1>=0 && arr[i-1]=='+')
			{
				arr[i-1] = '~';
				arr[i] = '+';
			}
			
			if(arr[i] == ')')
			{
				System.out.println("bracket close detected at index " + i);
				change--;
				arr[i] = '~';
			}

			if((arr[i] == '-' || arr[i] == '+') && arr[i+1] != '(' && change>=0)
			{
				if(change%2 != 0)//change required
				{
					System.out.println("sign change requirement detected at index " + i);

					if(arr[i] == '-')
						arr[i] = '+';
					else if(arr[i] == '+')
						arr[i] = '-';
				}
			}
		}

		System.out.println(str);
		str = "";
		for(int i=0; i<N; i++)
		{
			if(arr[i] != '~')
				str+=arr[i];
		}

		System.out.println(str);
		//System.out.println(Arrays.toString(arr));
	}
}