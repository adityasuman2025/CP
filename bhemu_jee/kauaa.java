import java.util.Scanner;
class kauaa{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("enter number:");
        int no1 = scan.nextInt();
        System.out.println("enter power:");
        int no2 = scan.nextInt();
        long ans = power(no1, no2);
        System.out.println(no1 + "^" + no2 + " = " +ans);
    }

    public static long power(int no, int pow) {
        if(pow == 0) {
            return 1;
        }

        int ans = no;
        for(; pow>1; pow--) {
            ans = ans*no;
        }

        return ans;
    }
}