import java.io.*;
import java.util.*;

public class Palindrome {

// Complete the substrCount function below.
    // static long substrCount(int n, String s) 
    // {   
    //     List<String> str_array = new ArrayList<>();

    //     long str_len = s.length();

    //     long count = str_len;
    //     for(long i=2; i<=str_len; i++)
    //     {
    //         for(long j=0; j<=str_len-i; j++)
    //         {
    //             String new_str = s.substring((int)j, (int)(j+i));     
    //             str_array.add(new_str);           
    //         }
    //     }

    //     for(String e : str_array)
    //     {
    //         //System.out.println(e);

    //         if(isPalindrome(e))
    //         {
    //             count++;
    //         }
    //     }
       
    //     return count;
    // }

    // public static boolean isPalindrome(String string)
    // {
    //     HashMap<Character, Long> arr_list = new HashMap<>();
    //     for(char a : string.toCharArray())
    //     {
    //         if(arr_list.containsKey(a))
    //         {
    //             long value = arr_list.get(a);
    //             arr_list.put(a, value+1);
    //         }
    //         else
    //         {
    //             arr_list.put(a, (long)1);
    //         }
    //     }

    //     if(arr_list.size() == 1)
    //     {
    //         return true;
    //     }
    //     else if(arr_list.size() > 2)
    //     {
    //         return false;
    //     }
    //     else // size ==2
    //     {
    //         long str_len = string.length();

    //         if(str_len%2 ==0)
    //         {
    //             return false;
    //         }
    //         else
    //         {
    //             long mid = str_len/2;

    //             if(string.charAt((int)mid) != string.charAt(0) && string.charAt(0) == string.charAt((int)str_len-1))
    //             {
    //                 return true;
    //             }
    //             else
    //             {
    //                 return false;
    //             }
    //         }
    //     }       
    // }

     public static long substrCount(int n,String s) 
     {
        long count = 0;

        for(int i=0;i<n;i++) 
        {
            char ch = s.charAt(i);
            int j = i+1;

            while(j<n && s.charAt(j)==ch) 
            { //loop until you identify a different character or end of string
                count++; j++;
            }

            if(j<n) 
            {        //means we did not reach at the end and encountered a different character
                int mid = j;    //index j was the mismatch
                j++;
                int equals = mid-i; //number of equal characters(+1) from i

                while(j<n && j<=mid+equals && s.charAt(j) == ch) 
                { //loop till equals till characters match
                    j++;
                }

                if(j-1-mid==mid-i) 
                {
                    count++;
                }
            }
        }
        return count+n;
    }

//main function
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
