import java.util.Scanner;

class maths {
    public static void main(String args[]){
        Scanner scanBhemu = new Scanner(System.in);
        
        // boolean bhe = true;
        // while(bhe)
        for(;;) {
            System.out.println("Enter first number: ");
            int a = Integer.parseInt(scanBhemu.nextLine());

            System.out.println("Enter second number: ");
            int b = Integer.parseInt(scanBhemu.nextLine());
            
            System.out.println("choose \n 1 for plus \n 2 for subtract \n 3 for divide \n 4 for multiply \n 5 For remainder \n 10 to exit");
            int choice = Integer.parseInt(scanBhemu.nextLine());
            System.out.println("your choice is: " + choice);
            if(choice == 1) {
                int add = jod(a, b);
                System.out.println("addition of "+ a + " and "+ b + " = " + add);
            } else if(choice == 2) {
                int sub = ghatao(a, b);
                System.out.println("subtract of " + a + " and " + b + " = " + sub);
            } else if(choice == 4) {
                int multi = guna(a,  b);
                System.out.println("multiply of " + a + " and " + b + " = " + multi);
            } else if(choice == 3) {
                double divide = bhaga(a, b);
                System.out.println("division of " + a + " and " + b + " = " + divide); 
            } else if(choice == 5) {
                int remainder = bakaya(a, b);
                System.out.println("remainder of " + a + " and " + b + " = " + remainder);
            } else if(choice == 10){
                // bhe = false;
                break;
            } else {
                System.out.println("wrong choice");
            }  
        }     
    }
    
    public static int jod(int c, int d){
        return c + d;
    }
    public static int ghatao(int c, int d){
        return c - d;
    }

    public static int guna(int e, int f){
        return e * f;
    }
    public static double bhaga(double c, double d){
        return c / d;
    }
    public static int bakaya(int c, int d){
        return c % d;
    }
}