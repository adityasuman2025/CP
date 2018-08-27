import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) 
    {
    //storing Anagrams of string in hashmap
        HashMap<String, Integer> sub_string_map = new HashMap<>();

    //finding anagram
        int count =0;

        for(int i=0; i<s.length(); i++) 
        {
            for(int j= i+1; j<=s.length(); j++) 
            {
            //getting the formed substring    
                String formed_sub_string = s.substring(i,j);

            //sorting the substring into acsending order    
                char sub_string_array[] = formed_sub_string.toCharArray();
                Arrays.sort(sub_string_array);
                formed_sub_string = String.valueOf(sub_string_array);

            //checking this sub_string is present in the hashmap or not
                if(sub_string_map.containsKey(formed_sub_string))
                {
                    int value = sub_string_map.get(formed_sub_string);
                    sub_string_map.put(formed_sub_string, (value+1));

                //increasing the anagram count    
                    count += value;                    
                }
                else
                {
                    sub_string_map.put(formed_sub_string, 1);
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            //sherlockAndAnagrams(s);

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

            // bufferedWriter.write(String.valueOf(result));
            // bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
