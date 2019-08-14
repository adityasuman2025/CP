import java.util.*;
import java.lang.*;
import java.io.*;

class rearrangeString
{
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
	{
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int a=0; a<T; a++)
	    {
	        String str= scanner.nextLine();
	        
            int max=1;
            
            HashMap<Character,Integer> tr = new HashMap<>();
            for(int i=0; i<str.length(); i++)
            {
                char c = str.charAt(i);
                if(!tr.containsKey(c))
                {
                    tr.put(c,1); 
                }
                else
                {
                    int v=tr.get(c);
                    int new_v = v+1;
                    
                    tr.put(c, new_v);
                    
                    if(new_v > max)
                        max = new_v;
                }
            }
           
           // System.out.println(max);
             
            if(max>(str.length() +1)/2) 
                System.out.println(0);
            else
                System.out.println(1);
	    }
	}
}