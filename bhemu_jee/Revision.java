import java.util.Scanner;
class Revision {
    public static void main(String [] args) {
        // int a = 1;
        // int b= 5;
        // int cloneA = a;
        // a = b;
        // b = cloneA;
        // System.out.println(a);
        // System.out.println(b);
        /////////////////////////////////////////////

        // Revision ka = new Revision();
        // int ans=ka.multi(a,b);
        // System.out.println(ans);
        ////////////////////////////////////////////

        // int a[] = new int [10];
        // for (int i = 0; i <= a.length; i++) {
        //     a[i]=i;
        //     System.out.println(a[i]);
        // }
        ////////////////////////////////////////////

        // int arr[][] = new int[3][3];
        // for (int i = 0; i < arr.length; i++) {
        //     int a = 0;
        //     for( ; a < arr.length; a++) {
        //         arr[i][a] = (3*i + 1)+a;
        //         System.out.print(arr[i][a] + " ");
        //     }
        //     System.out.println();
        // }
        ////////////////////////////////////////////
        // for (int a = 1; a <= 10; a++) {
        //     for(int i = 1; i<= 10 - a; i++) {
        //         System.out.print(" ");
        //     }

        //     for (int i = 1; i <= a; i++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        ////////////////////////////////////////////
        // int i = 1;
        // for (int a = 1; ; a++) {
        //     if (a % 2 == 0 ) {
        //         continue;//even no.
        //     } else if (i == 31){
        //         break;
        //     }

        //     System.out.println(i + " is " + a);
        //     i++;
        // }
        ////////////////////////////////////////////
        // int i = 1;
        // for (int a = 2; i<=30; a = a+2) {
        //     System.out.println(i + " is " + a);
        //     i++;
        // }
        Scanner scan = new Scanner(System.in);
        for ( ; ; ) {
            int ka = scan.nextInt();
            if (ka == 10) {
                break;
            }
            System.out.println("im bot");
        }
    }
    

    // public int multi(int a, int b){
    //     int guna = 1;
    //     for ( ; a<=b; a++) {
    //         guna = guna * a;
    //     }
    //     return guna;
    // }
}