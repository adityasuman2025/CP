import java.util.*;

public class minCoinChange 
{
	static void coin(int arr[], int V)
	{
	//for min count of coins
		int table[] = new int[V+1];

		table[0] = 0;
		for(int i =1; i<=V; i++)
		{
			table[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1; i<=V; i++)
		{
			for(int j = 0; j<arr.length; j++)
			{
				if(arr[j] <= i) //if that coin can contribute in making change of the required money (i)
				{
					int sub_res = table[i-arr[j]]; //search in table array to find the no of coins required to make the left amount of change
					if(sub_res != Integer.MAX_VALUE && sub_res +1 <table[i])
					{
						table[i] = sub_res +1; //if the sub_res value is smalller than the value already stored in the table[i] then replacing table[i]
						//value with the sub_res value
					}
				}
			}
		}

		System.out.println(Arrays.toString(table));
		System.out.println(table[V]);

	//for printing the required coins
		int j = 0;
        for(j=0; j<N; j++)
        {
            if(arr[j]>=V)  
            {
                break;
            }
        }
        j--;
        
        int temp = V;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=j; i>=0; i--)
        {
            int coin = arr[i];
            
            if(temp>=coin)   
            {
                int count = temp/coin;
                for(int k=0; k<count; k++)
                    list.add(coin);
                    
                temp -= (coin*count); 
            }
        }
       
        StringBuilder sb = new StringBuilder();
        for(int item: list)
        {
            sb.append(item + " ");
        }
        System.out.println(sb.toString());	
	}
	
	public static void main(String[] args) 
	{
		int arr[]  = {8,3,16,6};
		coin(arr, 10);
	}	
}