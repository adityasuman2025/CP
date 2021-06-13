import java.util.*;

class arrays {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        // int numbers[] = new int[2];
        // numbers[0]= 10;
        // numbers[1]=2;
        
        // int numbers[] = {1,2,32,4,3,54,6,4};
        // System.out.println("size of array is: " + numbers.length);
      
        // int sum = jor(numbers);
        // String line = "sum is ";
        // System.out.println(line + sum);

        String text = scan.nextLine();
        String arr[] = text.split(" ");
        
        int sum = jor(arr);
        String line = "sum is ";
        System.out.println(line + sum);
    }

    public static int jor(String nos[]) {
        // return nos[0] + nos[1] +nos[3];

        int sum = 0;
        for(int a = 0; a<nos.length; a++ ){
            sum = sum + Integer.parseInt(nos[a]);
        }
        return sum;
    }
}