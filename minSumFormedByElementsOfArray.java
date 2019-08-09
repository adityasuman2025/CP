import java.util.*;
import java.lang.*;
import java.io.*;

class minSumFormedByElementsOfArray
{
	static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        int n = scanner.nextInt();
	        
	        int arr[]= new int[n];
            for(int x=0; x<n; x++)
            { 
                arr[x]=scanner.nextInt();
            }
            Arrays.sort(arr);
            
            String first = "";
            String second = "";
            for(int x=0; x<n; x++)
            { 
                if(x%2==0)//even
                {
                    first += Integer.toString(arr[x]);
                }
                else
                {
                     second += Integer.toString(arr[x]);
                }
            }
            
            // System.out.println(Arrays.toString(arr));
            // System.out.println(first);
            int ans = Integer.parseInt(first) + Integer.parseInt(second);
            System.out.println(ans);
	    }
	}
}