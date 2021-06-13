import java.util.*;
class Recursion {
    public static void main(String args[]) {
        int a = 3;
        int ans = recc(a);
        int ans2 = fect(a);
        // System.out.println(ans);
        System.out.println(ans2);
    }

    public static void fibb() {
        int series[] = new int[20];
        series[0] = 1;
        series[1] = 1;
        for(int a = 2; a<series.length; a++) {
            series[a]= series[a-1]+series[a-2];
        }
        System.out.println(Arrays.toString(series));
        System.out.println(series[18]);
    }

    public static int recc(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }

        return recc(n-1) + recc(n-2);
    }
    public static int fect(int n) {
         if(n == 0 || n == 1) {
            return 1;
        }
        return n * fect(n-1);
    }
}