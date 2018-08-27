//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution8
{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);

        Map<String, String> book = new HashMap<String, String>(); 
        int n = in.nextInt();

        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
        
            String phone_str =  Integer.toString(phone);
        // Write code here
            book.put(name, phone_str);
        }

        int l =0;
        String queries[] = new String[100000];

        while(in.hasNext())
        {
            String s = in.next();
        
        // Write code here  
             queries[l] = s;
             l++;
        }

        for(int k =0; k<l; k++)
        {
            String key = queries[k];

            if(book.containsKey(key))
            {
                System.out.println(key + "=" + book.get(key));
            }
            else
            {
                System.out.println("Not found");
            }
        }

        in.close();
    }
}