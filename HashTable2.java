import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HashTable2 {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) 
    {
    //initializing the hashmap database for s1
        HashMap<Character, Integer> map_s1 = new HashMap<>();

        for(char s1_ele : s1.toCharArray())
        {
           if(map_s1.containsKey(s1_ele))
            {
                int value = map_s1.get(s1_ele);
                value ++;
                map_s1.put(s1_ele, value);
            }
            else
            {
                map_s1.put(s1_ele, 1);
            }
        }

    //initializing the hashmap database for s2
        HashMap<Character, Integer> map_s2 = new HashMap<>();

        for(char s2_ele : s2.toCharArray())
        {
           if(map_s2.containsKey(s2_ele))
            {
                int value = map_s2.get(s2_ele);
                value ++;
                map_s2.put(s2_ele, value);
            }
            else
            {
                map_s2.put(s2_ele, 1);
            }
        }

    //checking presence        
        int count=0;

        for(char s1_key : map_s1.keySet())
        {
            if(map_s2.containsKey(s1_key))
            {
                count ++;
            }
        }

        if(count ==0)
        {
          return "NO";
        }
        else
        {
            return "YES";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
