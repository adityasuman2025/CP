import java.util.*;

class SumOfNumbers {
    public static void main(String args []) {
        // int arr[] = new int[10];

        // for(int i = 0; i<20; i++) {
        //     if(i%2 == 0) {
        //        arr[i/2] = i+1;
        //     }
        // }
        // System.out.println(Arrays.toString(arr));
        
        int start = 11;
        int end = 25;
        int sum = 0;
        for( ; start<=end; start++) {
            sum = start+sum;         
        }
        System.out.println(sum);

        // int sum = 0;
        // for(int a = 1; a<=10; a++) {
        //     // sum = sum+a;
        //     sum +=a;
        // }  
        // System.out.println(sum); 
    }
}