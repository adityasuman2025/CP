import java.util.*;
import java.io.*;

/*
Angle between hour and minute hand
Calculate the angle between hour hand and minute hand.

There can be two angles between hands, we need to print minimum of two. Also, we need to print floor of final result angle. For example, if the final angle is 10.61, we need to print 10.

 

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of one line conatining two space separated numbers h and m where h is hour and m is minute.

Output:
Coresponding to each test case, print the angle b/w hour and min hand in a separate line.

Constraints:

1 ≤ T ≤ 100
1 ≤ h ≤ 12
1 ≤ m ≤ 60

Example:

Input
2
9 60
3 30

Output
90
75
*/

class AngleBWHourMinHand
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        String input[] = bf.readLine().split(" ");
	        double h = Double.parseDouble(input[0]);
	        double m = Double.parseDouble(input[1]);
	        
	        if (h == 12.0) 
                h = 0; 
            if (m == 60.0)  
                m = 0; 
            
	        double hour_angle = (0.5 * (h*60 + m)); 
            double minute_angle = (6*m); 
            
            double angle = Math.abs(hour_angle - minute_angle); 
            angle = Math.min(360-angle, angle);
            System.out.println((int)angle);
	    }
	}
}