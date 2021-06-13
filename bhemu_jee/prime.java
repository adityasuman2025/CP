import java.util.Scanner;

class prime {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int no = scan.nextInt();
        boolean ans = optimisedIsprime(no);
        System.out.println("the no " + no + " is prime number? " + ans);
    }

    public static boolean isprime(int no) {
        for(int a = 2; a < no; a++) {
            if(no%a == 0) { 
                return false;
            }
        }

        return true;
    }
  
    public static boolean optimisedIsprime(int no) {
        if(no <= 1) {
           return false;
        }

        if(no < 4) {
            return true;
        }

        if(no%2 == 0 || no%3 == 0) {
            return false;
        }

        for(int a = 5; a*a< no; a = a+6) {
            if(no%a == 0 || no%(a+2) == 0) { 
                return false;
            }
        }

        return true;
    }
}