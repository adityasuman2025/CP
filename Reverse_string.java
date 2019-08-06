//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class Reverse_string {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String c = br.readLine();                // Reading input from STDIN
        int count = Integer.parseInt(c);
        
        String inputs[] = new String[count];
        
        for(int i=0; i<count; i++)
        {
            inputs[i] = br.readLine();
        }
        
        for(int i=0; i<count; i++)
        {
            StringBuilder input1 = new StringBuilder(); 
            input1.append(inputs[i]);

            System.out.println(input1.reverse());
        }
        
        //Scanner
        // Scanner s = new Scanner(System.in);
        // String name = s.nextLine();                 // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        

        // Write your code here


    }
}
