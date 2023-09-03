import java.util.*;
import java.io.*;

class firstNonRepeatingChar
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int N = Integer.parseInt(bf.readLine());
	        String str[] = bf.readLine().split(" ");
	        
	        HashMap<Character, Integer> map = new HashMap<>();
	        LinkedList<Character> q = new LinkedList<>();
	        for(int i=0; i<str.length; i++)
	        {
	           char c = str[i].charAt(0);
	           if(map.containsKey(c))
	           {
	                if(q.contains(c))
                    {
                        q.remove(new Character(c));
                    }
                    
                    if(q.isEmpty())
                    {
                        System.out.print("-1 ");  
                    }
                    else
                    {
                        System.out.print(q.peek() + " ");
                    }
	           }
	           else
	           {
	               map.put(c,1);
	               q.add(c);
	               System.out.print(q.peek() + " ");
	           }
	        }
	        
	        System.out.println();
	    }
	}
}