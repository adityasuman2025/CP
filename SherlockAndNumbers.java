//imports for BufferedReader
import java.io.*;
import java.util.*;

class SherlockAndNumbers 
{
    public static void main(String args[] ) throws Exception 
    {
    //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();                // Reading input from STDIN
        int T = Integer.parseInt(t);
        
        for(int i=0; i<T; i++)
        {
			String input = br.readLine();
			String input_array[] = input.split(" ");

			int N = Integer.parseInt(input_array[0]);
			int K = Integer.parseInt(input_array[1]);
			int P = Integer.parseInt(input_array[2]);

			String to_remove = br.readLine();
			String remove_from_array[] = to_remove.split(" ");

			for(int j=0; j<remove_from_array.length; j++)
			{
				if(P>=Integer.parseInt(remove_from_array[j]))
				{
					P++;
				}
				else
				{
					break;
				}				
			}

			if(P-1<N)
			{
				System.out.println(P);	
			}
			else
			{
				System.out.println(-1);
			}		
        }
    }
}
