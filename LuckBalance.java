import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LuckBalance 
{
    static int luckBalance(int k, int[][] contests) 
    {
        List<Integer> list = new ArrayList<>();

        int max_luck = 0;
        for(int i =0; i<contests.length; i++)
        {
            int luck_points = contests[i][0];

            if(contests[i][1] == 0)
            {
                max_luck += luck_points;
            }
            else if(contests[i][1] == 1)
            {
                list.add(luck_points);
            }
        }


        Collections.sort(list);
        Collections.reverse(list);

        // for(int e : list)
        // {
        //     System.out.println(e);
        // }

        if(list.size() >k)
        {
            for(int j=0; j<k; j++)
            {
                int luck_points = list.get(j);
                list.set(j, -1000);

                max_luck += luck_points;
            }

            for(int e : list)
            {
                if(e != -1000)
                {
                    max_luck -=e;
                }
            }
        }   
        else
        {
            for(int e : list)
            {
                max_luck +=e;
            }
        }    
        
        return max_luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        System.out.println(result);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
