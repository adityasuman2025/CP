import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) 
    {
    //storing array value and its index in hashmap #key = array value #value = index
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<cost.length; i++)
        {
            map.put(cost[i], i);
        }

    //solving the problem
        for(int j=0; j<cost.length; j++)
        {
            int index = j;
            int target = money - cost[j];

            if(map.containsKey(target))
            {
                int map_index = map.get(target);
                if(index != map_index)
                {
                    System.out.println((j+1) + " " + (map_index+1));
                    break;
                }               
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
