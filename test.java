import java.util.*;
import java.lang.*;
import java.io.*;
class test
 {
    static void ways(int n)
    {
        int table[] = new int[n+1];
        
    //base condition
        table[0] = 1;
        
    //performing our required operations
        for(int i =1; i<=n; i++)
        {
            table[i] += table[i-1];
        }

        for(int i =3; i<=n; i++)
        {
            table[i] += 2*table[i-3];
        }

        for(int i =4; i<=n; i++)
        {
            table[i] += table[i-4];
        }

        System.out.println(table[n]);
    }
    
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
    {
        int T = Integer.parseInt(scanner.nextLine());
        for(int a= 0; a<T; a++)
        {
            int O = Integer.parseInt(scanner.nextLine());
            
            ways(O);
        }
        
     }
}