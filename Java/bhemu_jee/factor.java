import java.util.Scanner;
class factor {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number");
        int no = scan.nextInt();
        System.out.println("choose factor ");
        int kaka= scan.nextInt();
        System.out.print("factor of " + kaka +" in " + no + " is ");
        int count = 0;
        
        for( ;no%kaka == 0; count++) {
            no = no / kaka;
        }
       
        // while(no%2 == 0) { 
        //     count++;
        //     no = no / 2;
        // }

        System.out.println(count);
    }
}