import java.util.Scanner;
class Revision2 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter ur 1st no");
        int a = scan.nextInt();
        // System.out.println("enter ur 2nd no");
        // int b = scan.nextInt(); 
        // System.out.println("Press 1 for add \n 2 for remainder \n 3 for Multiply");
        // int c = scan.nextInt();
        // sm(a,b);

        // int arr [] = new int[b-a+1];
        // int count = 0;
        // for( ; a <= b; a++) {
        //     arr[count] = a; 
        //     System.out.println(arr[count]);
        //     count++;
        // }

        // int arr[][] = new int[3][3];  //{{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; 
        // int counting = 3;
        // for (int count = 0; count < arr.length; count++) {
        //     for (int count2 = 0; count2 < arr[count].length; count2++) {
        //         arr[count][count2] = count+3-count2;
        //         System.out.print(arr[count][count2] + ", ");
    
        //     }
        //     System.out.println(" ");
        // }
        // /-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/---
        // int arr[] = new int[10];
        // int count = 1;
        // arr[0] =1;
        // arr[1] =1;
        // System.out.println(arr[0] + "\n" +arr[1]);
        // for (int a = 2; a <arr.length; a++) {
        //     arr[a] = arr[a-1] + arr[a-2];
        //     System.out.println(arr[a]);
        // }
        
        System.out.println(fact((long)a));

    }
    public static long fact(long n) {
        if (n == 0) {
            return 1;
        }
        return n*fact(n-1);
    }

    public static int remain(int a , int b) {
        return a % b;
    }

    public static void pattern(int a) {
        for(; a >= 1; a--) {
            for(int b = 1; b <=a ; b++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    public static void pattern2(int a) {
        try {
            int c = a;
            for ( ; a>=1; a--) {
                int b = 1; 
                for ( ; b < a; b++) {
                    System.out.print(" ");
                }
                for (int d = 1; d <= c-b+1; d++) {
                    System.out.print("*");
                    Thread.sleep(100);
                }
                System.out.println("");
            }
        } catch (InterruptedException ex) {}  
    }

    public static void pyramid(int a) {
        int c = a;
        for ( ; a >= 1 ; a--) {
            int b = 1;
            for ( ; b < a; b++) {
                System.out.print(" ");
            }
            for (int d = 1 ; d <= 2*(c-b+1); d++) {
                System.out.print("*");
            }            
            System.out.println("");
        }
    }
    public static void swap(int a, int b) {
        int c = b;
        b = a;
        a = c;
        System.out.println(a + "," + b);
    }
    public static void sm(int a, int b) {
        int jor = 0;
        int guna = 1;
        for ( ; a<=b; a++) {
            jor = jor + a;
            guna = guna*a;
        }

        System.out.println(jor + "," + guna);
    }
}