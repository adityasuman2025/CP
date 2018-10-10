import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sherlockValidStr {

    // Complete the isValid function below.
    static String isValid(String s) {
         HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
            max=Math.max(max,map.get(s.charAt(i)));
        }
 
        int count1=0,count2=0;
         for (Map.Entry m:map.entrySet())
             min=Math.min(min,(int)m.getValue());
        
           for (Map.Entry m:map.entrySet())
         {
             int val=(int)m.getValue();
            if(val==max)
                 count1++; // max_count
             else if(val==min)
                 count2++; //min_count
         }
        
        if(max-min==0 || (count1==map.size()-1 && min==1) || (count2==map.size()-1 && max-min==1))
            return "YES";
        
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
