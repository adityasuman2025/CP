import java.io.*;
import java.math.*;
import java.util.*;

public class ValidString {

    // Complete the isValid function below.
    static String isValid(String s) 
    {
    //storing string's charaters in hashmap
        HashMap<Character, Long> arr_list = new HashMap<>();
        for(char a : s.toCharArray())
        {
            if(arr_list.containsKey(a))
            {
                long value = arr_list.get(a);
                arr_list.put(a, value+1);
            }
            else
            {
                arr_list.put(a, (long)1);
            }
        }

    //finding minimum value in the value set of the hashmap
        long min = Collections.min(arr_list.values());
        long max = Collections.max(arr_list.values());

        if(max -min ==0)
        {
            return "YES";
        }

    //varifying the valid string
        HashMap<Long,Long> count_map = new HashMap<>();

        for(char key : arr_list.keySet())
        {
            long key_value = arr_list.get(key);

            if(count_map.containsKey(key_value))
            {
                long value = count_map.get(key_value);

                count_map.put(key_value, value+1);
            }
            else
            {
                count_map.put(key_value, (long)1);
            }
        }

        for(long e: count_map.keySet())
        {
            System.out.println(e + ": " + count_map.get(e));
        }

        long count_key_max = Collections.max(count_map.keySet());
        long count_key_min = Collections.min(count_map.keySet());

        long count_value_min = Collections.min(count_map.values());


    //deciding yes or no
        String min_str = new String();
        if(count_map.size()>2)
        {
            min_str = "NO";
        }
        else
        {
            if(count_value_min ==1)
            {
                min_str = "YES";
            }
            else
            {
                min_str = "NO";
            }
        }

        
        return min_str;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
