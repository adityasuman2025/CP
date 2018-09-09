import java.util.*;
import java.lang.*;
import java.io.*;
class WaveArray
 {
	 static Scanner scanner = new Scanner(System.in);
	 public static void main (String[] args)
	 {
	    int T = Integer.parseInt(scanner.nextLine());
	    
	    for(int n = 0; n<T; n++)
	    {
	        String size = scanner.nextLine();
	        String str_arr[] = scanner.nextLine().split(" ");
	        
	        ArrayList<Integer> stack = new ArrayList<>();
	        
	        for(String i : str_arr)
	        {
	            stack.add(Integer.parseInt(i));
	        }
	        
	        Collections.sort(stack);
	        
	        ArrayList<Integer> arr = new ArrayList<>();
	        
	        int big;
	        int small;
	        while(!stack.isEmpty())
	        {
	            if(stack.size() == 1)
	            {
	                 big = stack.get(0); 
	                 arr.add(big);
	                 stack.remove(0);
	            }
	            else
	            {
	                big = stack.get(1);
	                small = stack.get(0);
    	            
    	            arr.add(big);
    	            arr.add(small);
    	            
    	            stack.remove(0);
    	            stack.remove(0);
	            }
	            
	        }
	        
	        for(int i : arr)
	        {
	           System.out.print(i + " ");
	        }
	        System.out.println();
	    }
	    
	 }
}