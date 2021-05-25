import java.util.Scanner;

class hello{
    public static void main(String args[]){
        Scanner scaname = new Scanner(System.in);
        System.out.println("enter your name ");
        String name = scaname.nextLine();

        String text = new String();
        text = " and I am a good boi.";
        System.out.println("My name is " + name + text );

        String a = "2";
        String b = "3";
        String kauaa = jorDo(a, b);
        System.out.println("no. is " + kauaa);
    }

    public static String jorDo(String c, String d){
        return c + d;
    }

}