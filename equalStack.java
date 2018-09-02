import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class equalStack {

    static boolean checkSum(int arr[], int sum_to_make)
    {
        int temp_sum = 0;
        for(int i=arr.length-1; i>=0; i--)
        {
            temp_sum += arr[i];
            
            if(temp_sum == sum_to_make)
            {
                return true;
            }
        }
        
        return false;
    }
    
    static int equalStacks(int[] h1, int[] h2, int[] h3) 
    {   
        HashMap<Integer, String> map = new HashMap<>();
    
    //getting the sum of all elements of the arrays
        int sum1 = 0;
        for(int i : h1)
        {
            sum1 +=i;
        }
        map.put(sum1, "h1");
        
        int sum2 = 0;
        for(int i : h2)
        {
            sum2 +=i;
        }
        map.put(sum2, "h2");
        
        int sum3 = 0;
        for(int i : h3)
        {
            sum3 +=i;
        }
        map.put(sum3, "h3");
        
    //performing the operation
        if(sum1 == sum2 && sum2 == sum3)
        {
            return sum1;
        }
        else
        {
            int max = Collections.max(map.keySet());
            
            String str = map.get(max);
            
            if(str == "h1")
            {
                System.out.println("this is h1");
                int temp = 0;
                for(int i=0; i<h1.length; i++)
                {
                    temp += h1[i];
                    int temp_sum = sum1 - temp;
                    
                //checking that sum in h2
                    boolean for_h2 = checkSum(h2, temp_sum);
                    
                //checking that sum in h3
                    boolean for_h3 = checkSum(h3, temp_sum);
                    
                    if(for_h2 && for_h3)
                    {
                        return temp_sum;
                    }
                }
            }
            else if(str == "h2")
            {
                System.out.println("this is h2");
                
                int temp = 0;
                for(int i=0; i<h2.length; i++)
                {
                    temp += h2[i];
                    int temp_sum = sum2 - temp;
                    
                //checking that sum in h2
                    boolean for_h1 = checkSum(h1, temp_sum);
                    
                //checking that sum in h3
                    boolean for_h3 = checkSum(h3, temp_sum);
                    
                    if(for_h1 && for_h3)
                    {
                        return temp_sum;
                    }
                }
            }
            else if(str == "h3")
            {
                System.out.println("this is h3");
                
                int temp = 0;
                for(int i=0; i<h3.length; i++)
                {
                    temp += h3[i];
                    int temp_sum = sum3 - temp;
                    
                //checking that sum in h2
                    boolean for_h1 = checkSum(h1, temp_sum);
                    
                //checking that sum in h3
                    boolean for_h2 = checkSum(h2, temp_sum);
                    
                    if(for_h2 && for_h1)
                    {
                        return temp_sum;
                    }
                }
            }
            
            
            return 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(result);
    }
}
