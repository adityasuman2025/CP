import java.util.*;
import java.io.*;

/*
Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Constraints:
1 ≤ T ≤ 70
30 ≤ N ≤ 130
1 ≤ Ai ≤ 60 

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.

Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first.
The output is 9 9 9 2 5.
*/

class SortByFreq
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
    {
        int T = Integer.parseInt(bf.readLine());
        for(int a=0; a<T; a++)
        {
            int N = Integer.parseInt(bf.readLine());
            String str[] = bf.readLine().split(" ");
            
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            int arr[] = new int[N];
            int maxVal = 1;
            
            for(int i=0; i<N; i++)
            {
                int key = Integer.parseInt(str[i]);
                if(map.containsKey(key))
                {
                    int val = map.get(key);
                    map.put(key, val+1);
                    
                    maxVal = Math.max(maxVal, val+1);
                }
                else
                {
                    map.put(key, 1);
                }
            }
            
            StringBuilder s = new StringBuilder();
            for(int i=maxVal; i>=1; i--)
            {
                for(int key: map.keySet())
                {
                    int val = map.get(key);
                    if(val == i)
                    {
                        for(int j=0; j<val; j++)
                        {
                            s.append(key + " ");
                        }
                    }
                }
            }
            
            System.out.println(s);
        }
    }
}