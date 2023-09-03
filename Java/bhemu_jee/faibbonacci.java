import java.util.*;
class faibbonacci {
    public static void main(String args[]) {
        int arr[] = new int[20];
        for(int a = 0; a < arr.length; a++) {
            if(a==0) {
                arr[a]=0; 
            } else if(a==1 || a ==2) {
                arr[a]=1;
            } else {
                arr[a]=(arr[a-1]) + (arr[a-2]);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}