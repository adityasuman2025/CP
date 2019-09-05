/*

https://www.interviewbit.com/problems/single-number-ii/

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4
*/

public class FindingSingleInTriplets 
{
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> list) 
    {
        int dp[] = new int[32];
        
        for(int item: list)
        {
            String bit = Integer.toBinaryString(item);
            //System.out.println(item + ": " + bit);
            int j=0;
            for(int i =bit.length() -1 ; i>=0; i--)
            {
                char c = bit.charAt(i);
                
                if(c== '1')
                    dp[j]++;
                    
                j++;
            }
        }
        
        String ans = "";
        for(int i = 31; i>=0; i--)
        {
            int rem = dp[i]%3;
            ans += rem;
        }
        
        int charCode = Integer.parseInt(ans, 2);
       // System.out.println(charCode);
        
        //System.out.println(Arrays.toString(dp));
        
        return charCode;
    }
}
