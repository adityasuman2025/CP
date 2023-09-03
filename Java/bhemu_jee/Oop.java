//ecapsulation
class Calc{
    //global variable
    private int no1;
    private int no2;

    //constructor
    Calc(int a, int b){
        no1 = a;
        no2 = b;
    }

    int remainder() {
        return no1 % no2;
    }

    //abstraction
    void setValue(int a, int b) {
        no1 = a;
        no2 = b;
    }
}

class Oop {
    public static void main(String[] args) {
        Calc calc = new Calc(46, 8);
        System.out.println(calc.remainder());
        calc.setValue(50, 5); 
        System.out.println(calc.remainder());

        // // polymorphism
        // Oop ka = new Oop();
        // ka.print(100); //will run second function
        // ka.print("aditya"); //will run first function
    }

    public void print(String name) {
        System.out.println("My name is " + name);
    }

    public void print(int age) {
        System.out.println("My age is " + age);
    }
}