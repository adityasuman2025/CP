import java.util.Arrays;
class kauaa {
    int leg;
    int mouth;

    kauaa(int a, int b) {
        leg = a;
        mouth = b;
    }
    
    public void getLn() {
        System.out.println(leg + " " + mouth);
    }
}
class bhemu {
    public static void main(String[] args) {
        int arr[] = {8,11,21,16,14,3,4,5,15,9,6,7,1,2,10,};
        // int b = (int)Math.sqrt(arr.length);
        // int arr2[][] = new int [b][b];
        // table(arr, b, arr2);
        // fac+ tor();
        kauaa kaka = new kauaa(2,1);
        kauaa chacha = new kauaa(4,2);
        kaka.getLn();
        chacha.getLn();
    }

    public static void table(int arr[], int b, int arr2[][]){
        for (int i = 0; i < b; i++) {
             
            for (int j = 0; j < b; j++) {                
                if (i == j) {
                    arr2[i][j] = 0;
                } else {
                    arr2[i][j] = arr[b*i+j];
                }
                System.out.print(arr2[i][j] + ", ");
            }
            System.out.println(" ");
        }
    }        

    public static void sort(int arr[]) {
        for (int a = 0; a < arr.length - 1; a++ ) {
            int flag = 0;
            for (int b = 0; b < arr.length-a-1; b++) {
                if (arr[b] > arr[b+1]) {
                    int temp = arr[b];
                    arr[b] = arr[b+1];
                    arr[b+1] = temp;
                    flag = 1;
                }
            }
            System.out.println((a+1) + "th loop: " + Arrays.toString(arr));
            if (flag == 0) {
                break;
            }
        }
    }

    public static void factor() {
        int chhota = 2;
        int bara = 1;
        int a = 0;
        for ( ; ; a++) {
            if (bara % chhota == 0){
                bara = bara / chhota;
            } else {
                break;
            } 
        } 
        System.out.println(a);
    }

    public static void binary() {
        int no = 61, no2 = no;

        String bin = "";
        for ( ; no >= 1 ;) {
            if (no % 2 != 0) {
                bin = "1" + bin;
            } else {
                bin = "0" + bin;
            }
            no = no / 2;
        }

        System.out.println("binary of " + no2 + " is " + bin);
    }
}