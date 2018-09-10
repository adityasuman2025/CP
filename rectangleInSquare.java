import java.util.*;
import java.lang.*;
import java.io.*;

class rectangleInSquare
 {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i;
        long j, n, k, ans=0, a=0;
        for(i=0;i<t;i++){
            ans = 0;
            n = sc.nextInt();
            
            for(j=2;j<=n;j++){
                a=0;
                if(j%2 ==0){
                    a = j/2;
                    a = a*(j-1);
                }else{
                    a = (j-1)/2;
                    a = a*j;
                }
                ans += (a*j);
                System.out.println(ans);
            }
            ans *= 2;
            
            System.out.println(ans);
        }
    }
}