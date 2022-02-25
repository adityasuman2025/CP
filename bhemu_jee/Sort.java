import java.util.Arrays;

class Sort {
    public static void main(String args[]) {
        int arr[] = {10, 3, 0, 13, 1, 5, 2, 15, 4, 6, 11, 8, 7, 19, 10};
        boubbleSort(arr);
    }

    public static void boubbleSort(int ka[]) {
        for (int a = 0; a < ka.length-1; a++) {
            boolean flag = false;
            for (int i = 0; i < ka.length-a-1; i++) {
                if (ka[i]>ka[i+1]) {
                    int temp1 = ka[i];
                    ka[i] = ka[i+1];
                    ka[i+1] = temp1;
                    // flag = true;
                }
            }

            System.out.println(a+1 + "th loop: " + Arrays.toString(ka));
            // if(flag == false) {
            //     break;
            // }
        }
        System.out.println(Arrays.toString(ka));
    }
}