/*
https://leetcode.com/problems/permutation-in-string

567. Permutation in String
Medium

786

42

Favorite

Share
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
*/

class PermutationInString 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int N = s2.length();
        int M = s1.length();
        
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(int i=0; i<M; i++)
        {
            char c = s1.charAt(i);            
            if(hashmap.containsKey(c))
            {
                int val = hashmap.get(c);
                hashmap.put(c, val+1);
            }
            else
                hashmap.put(c, 1);
        }
        //System.out.println(hashmap);
        
        for(int i=0; i<=N-M; i++)
        {    
            HashMap<Character, Integer> map = (HashMap) hashmap.clone();
            
            char c = s2.charAt(i);            
            if(map.containsKey(c))
            {        
                int val = map.get(c);                        
                if(val<2)
                {
                    map.remove(c);
                }
                else
                    map.put(c, val-1);
                
                boolean left = true;
                boolean right = true;
        
                int k = i+1;
                               
                while(k<N && right)
                {
                    char a = s2.charAt(k);
                    
                    if(map.containsKey(a))
                    {
                        val = map.get(a);
                        
                        if(val<2)
                        {
                            map.remove(a);
                        }
                        else
                            map.put(a, val-1);
                        
                        k++;                        
                    }
                    else
                        right = false;
                }
                
                if(map.size()==0)
                    return true;
            }
        }
        
        return false;
    }   
}