import java.util.Scanner;
class patterns {
    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter step of pattern");
        int turn = scan.nextInt();
       
        leftLadder(turn);
        rightLadder(turn); 
    }

    public static void leftLadder(int step) {
        System.out.println("Your pattern is");
         int a = 1;
        for( ; a <= step; a++) {
            for(int b = 1; b <= a; b++) {
               System.out.print("*"); 
            }
            System.out.println(" ");
        }
    }   

    public static void rightLadder(int step) {
        System.out.println("Your pattern is");
        int a = 1;
        for( ; a <= step; a++) {
            for(int b = step-a; b>0; b--) {
               System.out.print(" "); 
            }
            for(int b = 1; b <= a; b++) {
               System.out.print("*"); 
            }
            System.out.println(" ");
        }
    }
}