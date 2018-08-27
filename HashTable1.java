import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HashTable1 {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) 
    {
    //initializing the hashmap database for note array
        HashMap<String, Integer> map_note = new HashMap<>();

        for(String note_element : note)
        {
           if(map_note.containsKey(note_element))
            {
                int value = map_note.get(note_element);
                value ++;
                map_note.put(note_element, value);
            }
            else
            {
                map_note.put(note_element, 1);
            }
        }

    //initializing the hashmap database for magazine array
        HashMap<String, Integer> map_magazine = new HashMap<>();

        for(String magazine_element : magazine)
        {
           if(map_magazine.containsKey(magazine_element))
            {
                int value = map_magazine.get(magazine_element);
                value ++;
                map_magazine.put(magazine_element, value);
            }
            else
            {
                map_magazine.put(magazine_element, 1);
            }
        }


    //checking ranson note
        int count =0;

        for(String note_key : map_note.keySet())
        {
            int note_value = map_note.get(note_key);

            if(map_magazine.containsKey(note_key))
            {
                int magazine_value = map_magazine.get(note_key);
                                
                else if(note_value > magazine_value)
                {
                    count ++;
                }
            }
            else
            {
                count ++;
            }
        }


        if(count ==0)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }

}
