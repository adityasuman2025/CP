/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class mergeArr {
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
        
        for(int n =0; n<T; n++)
        {
            String lenn = scanner.nextLine();
            String str_arr1[] = scanner.nextLine().split(" ");
            String str_arr2[] = scanner.nextLine().split(" ");
            
            ArrayList<Integer> arr1 = new ArrayList<>();
            for(int a=0; a<str_arr1.length; a++)
            {
                arr1.add(Integer.parseInt(str_arr1[a]));
            }  
            
            ArrayList<Integer> arr2 = new ArrayList<>();
            for(int a=0; a<str_arr2.length; a++)
            {
                arr2.add(Integer.parseInt(str_arr2[a]));
            }
            
            Collections.sort(arr1);
            Collections.sort(arr2);
            Collections.reverse(arr1);
            Collections.reverse(arr2);

            System.out.println(arr1);
            System.out.println(arr2);
            
            int i=0;
            int j=0;
            ArrayList<Integer> list = new ArrayList<>();
            while(i< arr1.size() && j<arr2.size())
            {
                if(arr1.get(i)> arr2.get(j))
                {
                    list.add(arr1.get(i));
                    i++;
                }
                else
                {
                    list.add(arr2.get(j));
                    j++;
                }
            }
            
            while(i< arr1.size())
            {
                list.add(arr1.get(i));
                i++;
            }
            
            while(j< arr2.size())
            {
                list.add(arr2.get(j));
                j++;
            }
            
            // System.out.println(list);

            // for(int q : list)
            // {
            //     System.out.print(q + " ");
            // }
           
            for(int w=0; w<arr1.size()+arr2.size(); w++)
            {
                System.out.print(list.get(w) + " ");
            }

            System.out.println();
        }
	}
}