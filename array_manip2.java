import java.util.*;
import java.io.*;

public class array_manip2 
{
   public static void main(String[] args) throws IOException 
     {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        //This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
        long[] arr = new long[n];

        int lower;
        int upper;
        long sum;

        for(int i=0;i<n;i++) arr[i]=0;

        for(int i=0;i<m;i++){
            lower=scan.nextInt();
            upper=scan.nextInt();
            sum=scan.nextInt();
            arr[lower-1]+=sum;
            if(upper<n) arr[upper]-=sum; 
        }

        long max=0;
        long temp=0;

        for(int i=0;i<n;i++){
            temp += arr[i];
            if(temp> max) max=temp;
        }

        System.out.println(max);
    }
}
