//imports for BufferedReader
import java.io.*;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class ChanduGF 
{
    public static int[] bubbleSort(int arr[])
    {
        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            int flag = 0;

            for(int j=0; j<n-1-i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flag = 1;
                }
            }

            if(flag == 0)
                break;
        }

        return arr;
    }

    public static void main(String args[] ) throws Exception {
      
        //BufferedReader
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test_case = br.readLine();                // Reading input from STDIN
        int t = Integer.parseInt(test_case);
        
        String arrays[] = new String[t];
        for(int i=0; i<t; i++)
        {
            String size = br.readLine();
            int s = Integer.parseInt(size);
            
            arrays[i] = br.readLine();
        }
        
        for(int i=0; i<t; i++)
        {
            System.out.println("Array " + i + " is: " + arrays[i]);

            String arr[] = arrays[i].split(" ");
            int n = arr.length;

            int temp_arr[] = new int[n];

            for(int j=0; j<n; j++)
            {
                temp_arr[j] = Integer.parseInt(arr[j]);
            }

            System.out.println(Arrays.toString(bubbleSort(temp_arr)));
        }

    }
}
