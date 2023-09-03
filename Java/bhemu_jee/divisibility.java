import java.util.Scanner;
class divisibility {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("write 1st number");
        int no1 = scan.nextInt();
        System.out.println("write 2nd number");
        int no2 = scan.nextInt();
        int b = no1 + no2;
        int c = b % 5;
         System.out.println("Sum of these 2 number is " + b);
        if(c==0) {
            System.out.println("no. is divisible by 5");
        } else {
            System.out.println("no. is not divisible by 5");
        }
    }
    
}