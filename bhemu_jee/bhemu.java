import java.util.Scanner;

class bhemu {
    public static void main(String args[]) {
        Scanner kauaa = new Scanner(System.in);

        for(boolean bh = true; bh == true; ) {
            System.out.println("Choose a number among 1 and 2 and 3(to exit) ");
            int no = kauaa.nextInt();
            if(no == 1) {
                System.out.println("You are a gud boi");
            } else if(no == 2) {
                System.out.println("You are a bad boi");
            } else if(no == 3) {
                bh = false;
            } else {
                System.out.println("wrong no");
            }
        }

    //     boolean isTrue = true;
    //     while(isTrue) {
    //         System.out.println("Choose a number among 1 and 2 and 3(to exit) ");
    //         int no = kauaa.nextInt();
    //         if(no == 1) {
    //             System.out.println("You are a gud boi");
    //         } else if(no == 2) {
    //             System.out.println("You are a bad boi");
    //         } else if(no == 3) {
    //            isTrue = false;
    //         } else {
    //             System.out.println("wrong no");
    //         }
    //     }
    }
}