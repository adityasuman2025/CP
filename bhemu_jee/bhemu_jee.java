class Scanner {
    // Scanner() {
    //     System.out.println("Scanner");
    // }

    public void nextInt(int no) {
        System.out.println("int is " + no);
    }

    public void nextFloat(int no) {
        System.out.println("float is " + no);
    }
}

class bhemu_jee {
    public static void main(String args[]) {
        bhemu_jee bheBhe = new bhemu_jee();
        bheBhe.anything();

        Scanner scan = new Scanner();
        scan.nextInt(40);
        scan.nextFloat(42);
    }

    public void anything() {
        System.out.println("anything");
    }
}