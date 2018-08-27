import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution_array_swap {
 // Complete the minimumSwaps function below.
    static void minimumSwaps(int[] arr) 
    {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        for (int i : arr)
        {
            list.add(i);
            list2.add(i);
        }           

        int count = 0;
        for(int i=0; i<list2.size()-1; i++)
        {           
        //removing that element form the hash map
            list.remove(new Integer(arr[i]));

            int min = Collections.min(list);
            int minIndex = list2.indexOf(min);
                
            // System.out.println(min);
            
            if(min<arr[i])
            {
                int temp = arr[i];
                list2.set(i, min);
                list2.set(minIndex, temp);

                //list2.get(i) = min;
                //list2.get(minIndex) = temp;       

                System.out.println(list2);        
                count ++;
            }
        }

        System.out.println(count);    
        //return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        //int res = 
        minimumSwaps(arr);
        //System.out.println(res);

        // bufferedWriter.write(String.valueOf(res));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
