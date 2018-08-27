import java.io.*;
import java.math.*;
import java.util.*;

public class AltChar {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) 
    {
        char arr[] = s.toCharArray();

        int count = 0;
        for(int i=0; i<arr.length - 1; i++)
        {  
            if(arr[i] == arr[i+1])
            {
                count++;
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

            int result = alternatingCharacters(s);

            System.out.println(result);

            // bufferedWriter.write(String.valueOf(result));
            // bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
