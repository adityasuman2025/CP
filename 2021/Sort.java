import java.util.Arrays;

class Sort {
    public static void main(String args[]) {
        int arr[] = {4,1,4567, 43, 3245664, 13, 0};
        System.out.println("original array: " + Arrays.toString(arr)); 
        SelectionSort(arr);
      
        System.out.println("sorted array: " + Arrays.toString(arr)); 
    }

    public static void BubbleSort(int arr[]) {
        for (int i=0; i<arr.length-1; i++) {
            int flag = 0;
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            System.out.println(i + 1 + " loop: " + Arrays.toString(arr)); 

            if(flag == 0) {
                break;
            }
        }   
    }

     public static void SelectionSort(int arr[]) {
        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j]<arr[minIndex]) {
                   minIndex = j;
                }
            }

            if(minIndex == i) {
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            System.out.println(i + 1 + " loop: " + Arrays.toString(arr)); 
        }   
    }
}