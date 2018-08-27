import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference 
{
  	private int[] elements;
  	public int maximumDifference;

  // Add your code here
    Difference(int[] ok)
    {
    	int ok_size = ok.length;
        this.elements = new int[ok_size];
    }

    void computeDifference()
    {
    	int new_elements[] = this.elements;
    	int elements_length = new_elements.length;

    	Arrays.sort(new_elements);

    	int max_val = new_elements[elements_length -1];
    	int min_val = new_elements[0];
    	int difference = max_val - min_val;

    	this.maximumDifference = difference;
    }

} 
// End of Difference class

public class Solution14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}