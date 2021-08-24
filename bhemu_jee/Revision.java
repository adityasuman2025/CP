class Revision {
    public static void main(String [] args) {
        int a = 1;
        int b = 10;

        int sum = 0;
        for ( ; a<=b; a++) {
            sum = sum + a;
            // sum += a;
        }

        System.out.println(sum);
    }
}