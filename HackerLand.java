import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HackerLand {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) 
    {
    //storing array as arraylist
        List<Integer> expi_array = Arrays.stream(expenditure)     // IntStream
                                    .boxed()        // Stream<Integer>
                                    .collect(Collectors.toList());

    //doing operation of the question
        int froud_count =0;
       
        for(int i=0; i < expenditure.length -d; i++)
        {
        //storing d expenditure in a temporary arraylist
            List<Integer> temp_expi = expi_array.subList(i, i+d);               
            Collections.sort(temp_expi);

            //System.out.println(temp_expi);

        //finding the median of the temporary expenditure
            int median = temp_expi.get(d/2);

            if(d%2 ==0)
            {
                median = temp_expi.get(d/2) + temp_expi.get((d/2)+1);                
            }

        //finding if this is froud or not
            int latest_expi = expenditure[i+d];

            if(latest_expi >= 2*median)
            {
                froud_count++;
            }
        }

        return froud_count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
