import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BubbleSort {

    public static void main(String args[])
    {
    //creating and printing the initial array
        int arr[] = {1,9,5,1000,4,8,11,89,6,7,2,3,10};

        for(int k: arr)
        {
            System.out.print(k + ", ");
        }
        System.out.println("");

    //sorting the array
        for(int i=0; i<arr.length-1; i++)
        {
            int flag =0;
            for(int j=0; j<arr.length-i-1; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flag=1;
                }
            }

            if(flag ==0)
            {
                break;
            }
        }

    //printing the sorted array
        for(int k: arr)
        {
            System.out.print(k + ", ");
        }
    }
}