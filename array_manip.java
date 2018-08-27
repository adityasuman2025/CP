import java.io.*;
import java.util.*;

public class array_manip {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) 
    {
    //initalizing a array with all 0 elements
        long arr[] = new long[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = 0;
        }

        HasMap<Integer, Integer> map = new HasMap<>();

    //doing operation
        for(int row =0; row<queries.length; row++)
        {
            int left_index = queries[row][0];
            int right_index = queries[row][1];
            long to_add = queries[row][2];


            for(int i=left_index-1; i<right_index; i++)
            {
                arr[i] = arr[i] + to_add;
            }
        }

        Arrays.sort(arr);

        long max = arr[n-1];
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]); //size of array

        int m = Integer.parseInt(nm[1]); //number of manipulation

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) 
        {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);
        scanner.close();
    }
}
