import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArray 
{
    // Returns XOR of x and y
    static int myXOR(int x, int y)
    {
        return (x | y) & 
               (~x | ~y);
    }
    
    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) 
    {
    //defining and intializing a 2D arraylist
        ArrayList<Integer> arr[] = new ArrayList[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = new ArrayList<Integer>();
        }
     
    //performing the action    
        List<Integer> list = new ArrayList<Integer>();   
        int lastAnswer = 0;
        
        for(List<Integer> temp : queries)
        {
            int type = temp.get(0);
            int x = temp.get(1);
            int y = temp.get(2);
            
            if(type == 1)
            {
                int index = (myXOR(x, lastAnswer)) % n;
                List<Integer> world = arr[index];
                arr[index].add(y);
                System.out.println(world);
            }
            else if(type ==2)
            {
                int index = (myXOR(x, lastAnswer)) % n;
                int size = arr[index].size();
                int value = arr[index].get(y%size);
                lastAnswer = value;
                list.add(value);
            }
        }
        
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
