/*
Swap all odd and even bits
Given an unsigned integer N. The task is to swap all odd bits with even bits. For example, if the given number is 23 (00010111), it should be converted to 43(00101011). Here, every even position bit is swapped with adjacent bit on right side(even position bits are highlighted in binary representation of 23), and every odd position bit is swapped with adjacent on left side.

Input:
The first line of input contains T, denoting the number of testcases. Each testcase contains single line.

Output:
For each testcase in new line, print the converted number.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100

Example:
Input:
2
23
2

Output:
43
1

Explanation:
Testcase 1: BInary representation of the given number; 00010111 after swapping 00101011.
*/

import java.util.*;
import java.io.*;
class SwapBits
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine().trim());
	    for(int t=0; t<T; t++)
	    {
	        int N = Integer.parseInt(bf.readLine().trim());
	        
	    //convering int into binary string    
	        //String binary = Integer.toBinaryString(N)

	        StringBuilder binary = new StringBuilder();
	        while(N>0)
	        {
	            int digit = N%2;
	            binary.append(digit);
	            
	            N = N/2;
	        }
	        binary.reverse();	        
	        String b = binary.toString();
	        
	    //making the binary string of length 8    
	        int n = binary.length(); 
	        for(int i=0; i<8-n; i++)
	            b = "0" + b;
	         
	    //swapping the even & odd positions     
	        char bin[] = b.toCharArray();
            for(int i=0; i<8; i++)
            {
                if(i%2==0)
                {
                    char c = bin[i];
                    bin[i] = bin[i+1];
                    bin[i+1] = c;
                }
            }
	          
	    //converting binary into int
	    	//int foo = Integer.parseInt("1001", 2);

	        int res =0;
	        for(int i=0; i<8; i++)
	        {
	            int digit = bin[i] - '0';
	            res += digit * (Math.pow(2, (8-1-i)));
	        }
	        
	        //System.out.println(Arrays.toString(bin));
	        System.out.println(res);
	    }
	}
}