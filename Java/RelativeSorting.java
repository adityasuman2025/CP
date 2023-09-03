import java.util.*;
import java.io.*;
class RelativeSorting
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        String input[] = (bf.readLine().split(" "));
	        int N = Integer.parseInt(input[0]);
	        int M = Integer.parseInt(input[1]);
	        
	        String str[] = bf.readLine().split(" ");
	        String str2[] = bf.readLine().split(" ");
	        
	        TreeMap<Integer, Integer> list = new TreeMap<>();
	        for(int i=0; i<N; i++)
	        {
	            int tmp = (Integer.parseInt(str[i]));
	            
	            if(list.containsKey(tmp))
	            {
	                int val = list.get(tmp);
	                list.put(tmp, val+1);
	            }
	            else
	            {
	                list.put(tmp, 1);
	            }
            }
            
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0; i<M; i++)
            {
                int temp = Integer.parseInt(str2[i]);
                if(list.containsKey(temp))
                {
                    int count = list.get(temp);
                    
                    for(int j=0; j<count; j++)
                        ans.add(temp);
                        
                    list.remove(new Integer(temp));
                }
            }
            
            for(int key: list.keySet())
            {
                int count = list.get(key); 
                for(int j=0; j<count; j++)
                        ans.add(key);
            }
            
            StringBuilder strB = new StringBuilder();
            for(int item: ans)
            {
                strB.append(item + " ");
            }
            System.out.println(strB.toString());
	    }
	}
}