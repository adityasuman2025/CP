import java.util.Scanner;
class counting {
    public static void main(String args[]) {
        // int a = 3;
        // int b = 15;
        // if(b%a == 0) {
        //     System.out.println("no is divisible by 3");
        // } else {
        //     System.out.println("no is not divisible by 3");
        // }

        Scanner no = new Scanner(System.in);
        System.out.println("enter ur number");
        int a = no.nextInt();
        System.out.println("Your table is ");
        for(int i = 1; i <=20; i++) {
            // if(i%2==0) {
            //     continue;
            // }
            int kauaa = a*i;
            if(kauaa>50){
                break;
            }
            System.out.println(kauaa);
        }
    }
}