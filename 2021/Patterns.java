import java.util.Scanner;

class Patterns {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter height of the ladder");
        int height = Integer.parseInt(scan.nextLine());

        System.out.println("\nChoose Pattern Type: \n 1. Left Ladder \n 2. Right Ladder \n 3. Pyramid \n 4. Odd No. Pyramid");
        int patternType = Integer.parseInt(scan.nextLine());
        System.out.println("\n\nPattern:");

        if(patternType == 1) {
            leftLadder(height);
        } else if(patternType == 2) {
            rightLadder(height);
        } else if(patternType == 3) {
            pyramid(height);
        } else if(patternType == 4) {
            oddNoPyramid(height);
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void leftLadder(int height) {
        for(int i = 1; i<=height; i++) {
            for(int j = 1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
    private static void rightLadder(int height) {
        for(int i = 1; i<=height; i++) {
            for(int j = height-i; j>=1; j--) {
                System.out.print(" ");
            }

            for(int j = 1; j<=i; j++) {
                System.out.print("*");
            }
           
            System.out.println("");
        }
    }

    private static void pyramid(int height) {
        int virtualHeight = 2*height;
        for(int i = 1; i<=virtualHeight; i += 2) {
            for(int j = (virtualHeight-i)/2; j>=1; j--) {
                System.out.print(" ");
            }

            for(int j = 1; j<=i; j++) {
                System.out.print("*");
            }
           
            System.out.println("");
        }
    }

    private static void oddNoPyramid(int height) {
        int virtualHeight = 2*height;
        for(int i = 1; i<=virtualHeight; i += 2) {
            for(int j = (virtualHeight-i)/2; j>=1; j--) {
                System.out.print(" ");
            }

            int k = 1;
            double center = (double)i/2;
            for(int j = 1; j<=i; j++) {
                System.out.print(k);

                if((double)j < center) {
                    k+=2;
                } else {
                    k-=2;
                }
            }
           
            System.out.println("");
        }
    }
}