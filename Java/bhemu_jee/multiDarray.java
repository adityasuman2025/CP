import java.util.*;

class multiDarray {
    public static void main(String args[]) {
        int arr[][] = new int[2][10];
        arr[0][2]=3;
        arr[1][9]=50;
        arr[0][0]=1;

        // System.out.println(arr[0][2]);

        for(int i=0; i<arr.length; i++) {
            // System.out.println(Arrays.toString(arr[i]));
            for(int j=0; j< arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}