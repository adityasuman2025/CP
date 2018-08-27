import java.io.*;
import java.math.*;
import java.util.*;

public class MinAbsDif 
{
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) 
    {   
    //terminated due to time out
        // List<Integer> min_dif = new ArrayList<>();

        // for(int i=0; i<arr.length; i++)
        // {
        //     for(int j=i+1; j<arr.length; j++)
        //     {
        //         int diff = Math.abs(arr[i]- arr[j]);
        //         min_dif.add(diff);
        //     }
        // }

        // int min = Collections.min(min_dif);
        // return min;

    //trying something else      
        Arrays.sort(arr);
        List<Integer> min_dif = new ArrayList<>();

        for(int j=1; j<arr.length; j++)
        {
            int diff = arr[j]- arr[j-1];
            min_dif.add(diff);
        }

        int min = Collections.min(min_dif);
        return min;
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

        int result = minimumAbsoluteDifference(arr);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
