import java.util.Scanner;
class bhemu_jee {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = a;
        for(; b<=a*10; b+=a) {
        System.out.println(b);
        }
    }
}