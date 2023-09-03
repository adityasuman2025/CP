import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static long getMinimumCost(int k, int[] c) 
    {
        int n = c.length;

    //sorting array in reverse order
        List<Integer> list = new ArrayList<>();
        for (int i : c) {
            list.add(i);
        }

        Collections.sort(list);
        Collections.reverse(list);

        // for(int e : list)
        // {
        //     System.out.println(e);
        // }

    //solving given prblm
        long min_price =0;
        if(k<=n)
        {
        //solving for first customer bought flowers
            for(int i =0; i<k; i++)
            {
                //System.out.println(list.get(i));
                min_price += list.get(i);
            }

        //solving for repiteted flowers
            int last_index = k;

            int foo =2; //the term which is multiplied with the original price
            for(int j=k; j<=n-k; j +=k)
            {                
                int temp =0;
                for(int a=0; a<k; a++)
                {
                    //System.out.println(list.get(j+a));
                    temp += list.get(j+a);
                }

                int sell_price = foo*temp;
                min_price += sell_price;

                foo++; //increaing the multiplication term
                last_index +=k;
            }
            
            System.out.println(min_price);
            System.out.println(foo);
            System.out.println(last_index);

        //solving for the remainder flowers    
            int remainder = n%k;
            if(remainder !=0)
            {
                for(int i=0; i<remainder; i++)
                {
                    int sell_price2 = foo*list.get(last_index+i);
                    System.out.println(list.get(last_index+i));
                    min_price += sell_price2;
                }
            }
        }

        return min_price;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        long minimumCost = getMinimumCost(k, c);

        System.out.println(minimumCost);

        // bufferedWriter.write(String.valueOf(minimumCost));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
