import java.util.*;
import java.io.*;
import java.lang.*;

/*
Rat in a Maze Problem
Consider a rat placed at (0, 0) in a square matrix m[][] of order n and has to reach the destination at (n-1, n-1). Your task is to complete the function printPath() which returns a sorted array of strings denoting all the possible directions which the rat can take to reach the destination at (n-1, n-1). The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line contains an integer n denoting the size of the square matrix. The next line contains n*n space separated values of the matrix m where 0's represents blocked paths and 1 represent valid paths.

Output:
For each test case output will be space separated sorted strings denoting all directions, which the rat could take to reach the destination.

User Task:
Since this is functional problem you don't have to worry about input, you just have to complete the function printPath()

Constraints:
1 <= T <= 10
2 <= n <= 10
0 <= m[][] <= 1

Example
Input:
2
4
1 0 0 0 1 1 0 1 0 1 0 0 0 1 1 1
4
1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1

Output:
DRDDRR
DDRDRR DRDDRR

Explanation:
Testcase 2: The given input is in the form
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
For the above matrix the rat can reach the destination at (3, 3) from (0, 0) by two paths ie DRDDRR and DDRDRR when printed in sorted order we get DDRDRR DRDDRR.
*/

class RatInMaze
{
    static ArrayList<String> ans = new ArrayList<>();
        
    public static ArrayList<String> printPath(int[][] m, int n)
    {
        ans.clear();
        
        m[0][0]=0;
        printPathUtil(m, n, 0, 0, "");
        
        Collections.sort(ans);
        return ans;
    }
     
    static void printPathUtil(int arr[][], int n, int i, int j, String hi)
    {
        if(i == n-1 && j == n-1)
        {
            ans.add(hi);
            return;
        }
        
        if(i-1>=0 && arr[i-1][j] == 1)
        {
            arr[i-1][j] = 0;
            printPathUtil(arr, n, i-1, j, hi+"U");
            arr[i-1][j] = 1;
        }
        
        if(i+1<n && arr[i+1][j] == 1)
        {
            arr[i+1][j] = 0;
            printPathUtil(arr, n, i+1, j, hi+"D");
            arr[i+1][j] = 1;
        }
        
        if(j-1>=0 && arr[i][j-1] == 1)
        {
            arr[i][j-1] = 0;
            printPathUtil(arr, n, i, j-1, hi+"L");
            arr[i][j-1] = 1;
        }
        
        if(j+1<n && arr[i][j+1] == 1)
        {
            arr[i][j+1] = 0;
            printPathUtil(arr, n, i, j+1, hi+"R");
            arr[i][j+1] = 1;
        }
    }
}