import java.util.Scanner;
class oddNumber {
    public static void main(String ags[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("print 1st n-time odd numbers");
        int n = scan.nextInt();
        int count = 1;
        for( ; count<=2*n; count++) { 
            if(count%2 == 0){
                continue;
            }
            System.out.println(count);

        }

    }
}