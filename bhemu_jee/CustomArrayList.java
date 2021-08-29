import java.util.ArrayList;

// class ArrayList {
//     private int array[] = new int[1000000];
//     private int position = 0;

//     void add(int value) {
//         array[position] = value;
//         position++;
//     }

//     int get(int position) {
//         return array[position];
//     }

//     void set(int position, int value) {
//         array[position] = value;
//     }

//     void remove(int position) {
//         array[position] = 0;
//     }
// }

class CustomArrayList {
    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // arr.add(10);
        // arr.add(3456789);

        // System.out.println(arr.get(0));
        // arr.set(0, 42);
        // System.out.println(arr.get(0));

        // String str = new String();
        // int arr[] = {3, ,42, 42,4 };
        // arr[0] = 42;
    
        for (int i = 1; i<=10; i++) {
            arr.add(i);
            System.out.println(arr.get(i-1));
        }
        

    }
}