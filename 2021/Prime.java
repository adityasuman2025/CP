import java.util.Scanner;

class Prime {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number: ");
        int no = scan.nextInt();

        boolean primeOrNot = isPrime(no);
        System.out.println(no + " is prime? " + primeOrNot);
    }

    private static boolean isPrime(int no) {
        if (no<=1) {
            return false;
        }

        if (no<=3) {
            return true;
        }

        if (no%2 == 0 || no%3 == 0) {
            return false;
        }

        for (int i=5; i*i<=no; i+=6) {
            if ((no%i == 0) || (no%(i+2) == 0)) {
                return false;
            }
        }

        return true;
    }
}