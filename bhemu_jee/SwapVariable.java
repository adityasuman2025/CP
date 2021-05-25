class SwapVariable {
    public static void main(String args[]) {
        int a = 420;
        int b = 746;
        
        // int tempA = a;
        // int tempB = b;
        // a = tempB;
        // b = tempA;

        int cloneB = b; //746
        b = a; //420
        a = cloneB;
        System.out.println("the number a = " + a);
        System.out.println("the number b = " + b);
    }
}