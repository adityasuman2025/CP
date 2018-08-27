import java.io.*;
import java.util.*;

public class MakeAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) 
    {
        HashMap<Character, Integer> string1 = new HashMap<>();
        HashMap<Character, Integer> string2 = new HashMap<>();

    //creting hashmap of the first string
        for(char char1 : a.toCharArray())
        {
            if(string1.containsKey(char1))
            {
                int value = string1.get(char1);
                string1.put(char1, value+1);
            }
            else
            {   
                string1.put(char1, 1);
            }
        }

    //creting hashmap of the second string
        for(char char2 : b.toCharArray())
        {
            if(string2.containsKey(char2))
            {
                int value = string2.get(char2);
                string2.put(char2, value+1);
            }
            else
            {   
                string2.put(char2, 1);
            }
        }

    //removing same key and values from the hashmaps
        for(char key: string1.keySet()) 
        {
            int str1_val = string1.get(key);

            if(string2.containsKey(key))
            {
                int str2_val = string2.get(key);

                if(str1_val == str2_val)
                {
                    string1.remove(key);
                    string2.remove(key);
                }
                else if(str1_val > str2_val)
                {
                    string1.put(key, (str1_val - str2_val));
                    string2.remove(key);
                }
                else if(str1_val < str2_val)
                {
                    string2.put(key, (str2_val - str1_val));
                    string1.remove(key);
                }
            }
        }   

        //counting the number of left characters that is needed to delete
            int count =0;

            for(int value : string1.values())
            {
                count +=value;
            }

            for(int value : string2.values())
            {
                count +=value;
            }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();
        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

        // bufferedWriter.write(String.valueOf(res));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
