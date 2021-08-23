class Scanner {
    private int a;
    private int b;

    //constructor
    Scanner(int no1, int no2) {
        a = no1; //5
        b = no2; //6
    }

    int sum() {
        return a + b;
    }

    int sub() {
        return a - b;
    }
}

class Oop {
    class JuniorOOP {

    }

    public static void main(String[] args) {
        Oop ka = new Oop();
        int b = ka.hru(ka.a);
        System.out.println(b);

        Scanner ki = new Scanner(10, 6);
        int add = ki.sum();
        int minus = ki.sub();
        System.out.println(add);
        System.out.println(minus);

        // System.out.println(ki.a);
    }

    int a = 4;

    static int hru(int no1){
        int k = no1;
        return k;
    }
}