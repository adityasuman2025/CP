import java.util.*;
import java.io.*;

/*
Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is n,n is the number.

Output:

Print the greater number than n with same set of digits and if not possible then print "not possible" without double quote.

Constraints:

1 ≤ T ≤ 100
1 ≤ n ≤ 100000

Example:

Input
2
143
431

Output
314
not possible
*/

class NextGreatestNumber
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        int str= Integer.parseInt(bf.readLine());
	        
            nextHighestNumber(str);
	    }
	}
	
	static void nextHighestNumber(int num)
	{
    //for converting no into digits
	    ArrayList<Integer> digits = new ArrayList<>();
	    
	    int temp = num;
	    while(temp>0)
	    {
	        int digit = temp%10;
	        digits.add(digit);
	        
	        temp = temp/10;
	    }
	    int N = digits.size();
	    
	    if(N<2)
	    {
	        System.out.println("not possible");
	        return;   
	    }
	    
    //for getting D1
	    int i=0;
	    for(i=0; i<N-1; i++)
	    {
	        if(digits.get(i+1)<digits.get(i))
	            break;
	    }
	    i++;
	    
	    if(i>=N)
	    {
	        System.out.println("not possible");
	        return;   
	    }
	    
	//for getting D2   
	    int j=0;
	    while(j<i)
	    {
	        if(digits.get(j)>digits.get(i))
	            break;
	        j++;
	    }
	    
    //swapping D1 & D2
        int t = digits.get(i);
        digits.set(i, digits.get(j));
        digits.set(j,t);
        
    //sorting elemets after D1
        List<Integer> subList = digits.subList(0, i);
	    Collections.sort(subList);
	    
    //printing the new number
        StringBuilder str = new StringBuilder();
        
        int m = digits.size() - 1;
        for(m = N-1; m>=i; m--)
        {
            str.append(digits.get(m));
        }
        
        for(m=0; m<subList.size(); m++)
        {
            str.append(subList.get(m));
        }
        
        System.out.println(str.toString());
	}
}