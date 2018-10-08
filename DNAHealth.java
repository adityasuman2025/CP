import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static int result(String[] genes, int[] health, int first, int last, String d)
    {
        int count = 0;
       
        for(int i=first; i<=last; i++)
        {
            String gene = genes[i];
            int point = health[i];
            
            if(d.contains(gene))
            {
                int idx =0;
                int no =0;
                 while ((idx = d.indexOf(gene, idx)) != -1)
                 {
                    idx++;
                    no++;
                 }
                
                //System.out.println(no);
                count+= no*point;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int count[] = new int[s];
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];
            
            count[sItr] = result(genes, health, first, last, d);
        }
        
    //printing the answer
        Arrays.sort(count);        
        //System.out.println(Arrays.toString(count));
        System.out.println(count[0] + " " + count[s-1]);

        scanner.close();
    }
}
