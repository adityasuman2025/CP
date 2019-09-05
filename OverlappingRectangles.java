import java.util.*;
import java.io.*;

/*
https://practice.geeksforgeeks.org/problems/overlapping-rectangles/0/?ref=self

Overlapping rectangles
Given two rectangles, find if the given two rectangles overlap or not. A rectangle is denoted by providing the x and y co-ordinates of two points: the left top corner and the right bottom corner of the rectangle. Two rectangles sharing a side are considered overlapping.

Note : It may be assumed that the rectangles are parallel to the coordinate axis.

rectanglesOverlap

Input:
The first integer T denotes the number of testcases. For every test case, there are 2 lines of input. The first line consists of 4 integers: denoting the co-ordinates of the 2 points of the first rectangle. The first integer denotes the x co-ordinate and the second integer denotes the y co-ordinate of the left topmost corner of the first rectangle. The next two integers are the x and y co-ordinates of right bottom corner. Similarly, the second line denotes the cordinates of the two points of the second rectangle in similar fashion.

Output:
For each testcase, output (either 1 or 0) denoting whether the 2 rectangles are overlapping. 1 denotes the rectangles overlap whereas 0 denotes the rectangles do not overlap.

Constraints:
1 <= T <= 10
-104 <= x, y <= 104

Example:
Input:
2
0 10 10 0
5 5 15 0
0 2 1 1
-2 -3 0 2

Output:
1
0

Explanation:
Testcase 1: Given two rectangles overlap each other thus answer returns 1.
*/

class Point 
{
    int x, y; 
} 

class OverlappingRectangles
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point(); 
                
	        String str1[] = bf.readLine().split(" ");
	        String str2[] = bf.readLine().split(" ");
	        
	        l1.x = Integer.parseInt(str1[0]);
	        l1.y = Integer.parseInt(str1[1]);
	        
	        r1.x = Integer.parseInt(str1[2]);
	        r1.y = Integer.parseInt(str1[3]);
            
            l2.x = Integer.parseInt(str2[0]);
	        l2.y = Integer.parseInt(str2[1]);
	        
	        r2.x = Integer.parseInt(str2[2]);
	        r2.y = Integer.parseInt(str2[3]);
            
            if(doOverlap(l1, r1, l2, r2))
                System.out.println(1);
            else
                System.out.println(0);
	    }
	}
  
    static boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
    {
    //if one rectangle is in left of another
        if(l2.x>r1.x || l1.x>r2.x)
            return false;
    
    //if one rectangle is in bottom of another
        if(r1.y>l2.y || r2.y>l1.y)
            return false;
        
        return true; 
    } 
}