import java.io.*;
import java.util.*;

public class Solution {
    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        if(n == 2){
            return true;
        }
        for (int i = 2; i*i<=n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        int n[] = new int[T];

        for(int i =0; i<T; i++)
        {
            n[i] = scanner.nextInt();
        }

        for(int e: n)
        {
            if(isPrime(e))
            {
                System.out.println("Prime");
            }
            else
            {
                System.out.println("Not prime");
            }
        }
    }
}