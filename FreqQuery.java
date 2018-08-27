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

public class freqQuery {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) 
    {
        HashMap<Integer, Long> arr = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(List<Integer> a : queries)
        {
            int operation = a.get(0);
            int data_elem = a.get(1);

            if(operation ==1)
            {
                if(arr.containsKey(data_elem))
                {
                    long value = arr.get(data_elem);
                    arr.put(data_elem, value+1);
                }
                else
                {
                    arr.put(data_elem, 1);
                }
            }
            else if(operation ==2)
            {
                if(arr.containsKey(data_elem))
                {
                    long value = arr.get(data_elem);
                    arr.put(data_elem, value-1);
                }
            }
            else if(operation ==3)
            {
                if(arr.containsValue(data_elem))
                {
                    result.add(1);
                }
                else
                {
                   result.add(0);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

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

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        System.out.println(freqQuery(queries));

        //freqQuery(queries);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
