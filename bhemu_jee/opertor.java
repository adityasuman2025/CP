import java.util.*;
class opertor {
    public static void main(String args[]) {
         int arr[]= new int[100];

        long guna = 1;
        int count = 0;
        for(int a = 1; a <= 100; a++) {
            if(a % 5 == 0 && a % 2 != 0) {
                arr[count]=a;
                count++;
                guna = guna*a; 
           //   System.out.println(a);
            }
        }
        System.out.println(guna);
        System.out.println(Arrays.toString(arr));
    }
}