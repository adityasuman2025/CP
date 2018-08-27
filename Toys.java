import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Toys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) 
    {
    //failing some of the testcases
        // HashMap<Integer, Integer> map = new HashMap<>();
        
        // Arrays.sort(prices);
        // for(int i=prices.length-1; i>=0; i--)
        // {
        //     int counter = i+1;
        //     int cost = 0;

        //     for(int j=0 ; j<=i; j++)
        //     {
        //        cost += prices[j];
        //     }
            
        //     map.put(counter, cost);
        // }
        
        // int result =0;

        // int max = Collections.max(map.keySet());

        // boolean flag = true;

        // while(flag)
        // {
        //     int key = max;
        //     int value = map.get(max);

        //     if(value <= k)
        //     {
        //         result = key;
        //         flag = false;
        //         break;
        //     }
        //     else
        //     {
        //         max --;                
        //     }
        // }
    
        // return result;


    //trying a simple and sucessful solution
        Arrays.sort(prices);  
        int count=0,sum=0;  

        for(int i=0; i<prices.length; i++)
        {
            if(sum <= k)
            {
                sum=sum+prices[i];
                count++;
            }
        }

        return count-1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        System.out.println(maximumToys(prices, k));

        //maximumToys(prices, k);

        //int result = maximumToys(prices, k);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
