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

public class TripletCounter {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) 
    {        
    //counting all the elements of the list 
        HashMap<Long, Integer> triplet_map = new HashMap<>();
        for(int i=0; i<arr.size(); i++)
        {
            long key = arr.get(i);
                    
            if(triplet_map.containsKey(key))
            {
                int key_value = triplet_map.get(key);
                key_value ++;
                triplet_map.put(key, key_value);
            }
            else
            {
                triplet_map.put(key, 1);
            }
        }
        
        long count =0;

        for(long first_key : triplet_map.keySet())
        {
            if(triplet_map.containsKey(first_key*r))
            {
                if(triplet_map.containsKey(first_key*r*r))
                {
                    long first_value = triplet_map.get(first_key);
                    long second_value = triplet_map.get(first_key*r);
                    long third_value = triplet_map.get(first_key*r*r);

                    long new_count = first_value*second_value*third_value;

                    count += new_count;
                }
            }  
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        // bufferedWriter.write(String.valueOf(ans));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
