import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class array_left_rot {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) 
    {
        int arr[] = a;
        
    //terminated due to timeout    
        // int effective_shift = (d) % arr.length;

        // for(int i=0; i<effective_shift; i++)
        // {         
        //     int first = arr[0];
                            
        //     for(int j=0; j<arr.length; j++)
        //     {                
        //         if(j != 0)
        //         {
        //             int temp = arr[j];
        //             arr[j-1] = temp;                   
        //         }             
        //     }          
             
        //     arr[arr.length -1] = first;
        // }


    //trying a different solution
        int eff = (d) % arr.length;

        int arr2[] = new int[a.length];
        arr2 = arr.clone();

        for(int j=0; j<arr.length; j++)
        {                            
            if(j - eff >= 0)
            {
                int temp = arr[j];
                arr2[j-eff] = temp;                   
            }
            else
            {
                int temp = arr[j];
                arr2[arr.length-eff+j] = temp;
            }             
        }     

        return arr2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            // bufferedWriter.write(String.valueOf(result[i]));

            // if (i != result.length - 1) {
            //     bufferedWriter.write(" ");
            // }
            System.out.println(result[i]);
        }

        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
