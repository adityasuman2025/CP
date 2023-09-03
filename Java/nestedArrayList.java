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

public class Solution {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) 
    {
        int size = arr.size();
      
    //initailing the nested arraylist
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<100; i++)
        {
            res.add(new ArrayList<String>());
        }
        
    //adding "-"
        int max_index=0;
       
        for(int i=0; i<size/2; i++)
        {
            int index = Integer.parseInt(arr.get(i).get(0));
            if(index> max_index)
            {
                max_index = index;
            }
            
            res.get(index).add("-");
        }
      
        for(int i=size/2; i<size; i++)
        {
            int index = Integer.parseInt(arr.get(i).get(0));
            String data = arr.get(i).get(1);
            res.get(index).add(data);
        }
        
        //System.out.println(res);
        
        for(int i=0; i<=max_index; i++)
        {
            for(String k : res.get(i))
            {
                System.out.print(k+ " ");
            }
        }   
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr);

        bufferedReader.close();
    }
}
