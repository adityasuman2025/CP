import java.util.*;

class PrimeFactors {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number: ");
        int no = scan.nextInt();
        getPrimeFactors(no);
    }

    private static void getPrimeFactors(int no) {
        TreeMap<Integer, Integer> map = new TreeMap<>(); //in TreeMap keys are in sorted format

        //getting factor 2
        while (no%2 == 0) {
            if (map.containsKey(2)) {
                int val = map.get(2);
                map.put(2, val+1);
            } else {
                map.put(2, 1);
            }

            no = no/2;
        }

	    // n must be odd at this point.  So we can 
        // skip one element because prime nos can't be even (Note i = i +2) 
        for (int i=3; i*1<=no; i+=2) {
            while (no%i == 0) {
                if (map.containsKey(i)) {
                    int val = map.get(i);
                    map.put(i, val+1);
                } else {
                    map.put(i, 1);
                }

                no = no/i;
            }
        }

        if (no>2) {
            map.put(no, 1);
        }

        for (int key: map.keySet()) {
            int val = map.get(key);
            
            System.out.println(key + ": " + val);
        }
    }
}