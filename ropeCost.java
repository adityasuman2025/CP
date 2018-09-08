/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class ropeCost {
	 
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i=0; i<T; i++)
		{
		    int lenn = Integer.parseInt(scanner.nextLine());
                  String str_arr[] = scanner.nextLine().split(" ");
                  
                  int arr[] = new int[str_arr.length];            
                  for(int a=0; a<str_arr.length; a++)
                  {
                      arr[a] = Integer.parseInt(str_arr[a]);
                  }            
                  
                  ArrayList<Integer> stack = new ArrayList<>();
                  for(int b = 0; b<arr.length; b++)
                  {
                  	stack.add(arr[b]);
                  }
                  Collections.sort(stack);
      			
                  ArrayList<Integer> sum = new ArrayList<>();
                  while(!stack.isEmpty())
                  {
                  	int f = stack.get(0);
                  	int s = stack.get(1);

                  	stack.remove(0);
                  	stack.remove(0);

                  	int add = f+s;
      	            sum.add(add);

                  	if(!stack.isEmpty())
                  	{
                  		stack.add(add);
                  	}   
                  	Collections.sort(stack);      	
                  }
      			//System.out.println(sum);

                  int res =0;
                  for(int ab : sum)
                  {
                  	res +=ab;
                  }

                  System.out.println(res);
		}
       
	}
}