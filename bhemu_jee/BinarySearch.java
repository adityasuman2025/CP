class BinarySearch {
    public static void main(String args[]) {
        int arr [] = {5,7,8,11,13,16,20,22};
        boolean tf = obs(arr, 12);
        System.out.print(tf);
        

    }

    public static boolean search(int arr[], int toFind) {
        for (int a = 0; a < arr.length; a++) {
            int b = arr[a];
            if (b == toFind) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean bs(int arr[], int toFind) {
        int mid = arr.length / 2; 
        if (toFind == arr[mid]) {
            return true;
        } else if (toFind < arr[mid]) {
            for (int a = mid; a >= 0; a--) {
                int value = arr[a];
                if (value == toFind) {
                    return true;
                }
            }
        } else {
            for (int a = mid; a < arr.length; a++) {
                int value = arr[a];
                if (value == toFind) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean obs(int arr[], int toFind) {
        int start = 0;
        int end = arr.length-1;
        int mid = (start + end) / 2;
        while(start<end) {
            if (toFind == arr[mid]) {
                return true;
            } else if (toFind < arr[mid]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return false;
    }
}