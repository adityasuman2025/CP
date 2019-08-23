import java.util.*;
import java.io.*;
import java.lang.*;

/*
Solve the Sudoku
Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (mat[][]). The task to print a solved Sudoku. For simplicity you may assume that there will be only one unique solution.

Sample Sudoku for you to get the logic for its solution:



Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case, in a new line, print the space separated values of the solution of the the sudoku.

Constraints:
1 <= T <= 10
0 <= mat[] <= 9

Example:
Input:
1
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1 
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

Output:
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9

Explanation:
Testcase 1: Not needed, I guess. Sp;ved sudoku is already given in output.
*/

class SolveSudoku
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            if(new Sudoku().SolveSudoku(grid) == true)
                new Sudoku().printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java

class Sudoku
{
    static boolean SolveSudoku(int grid[][])
    {
        int row = 0,column = 0;
        Location location  = findLocation(grid) ;
        if(location == null){
            return true;
        }
      //  System.out.println("row = "+location.getRow()+" column = "+location.column);
        for(int i=1;i<=9;i++){
            if(isSafe(grid,location.row,location.column,i)){
                grid[location.row][location.column] = i;
                if(SolveSudoku(grid)){
                    return true;
                }
                //backtrack
                grid[location.row][location.column] =0;
            }
        }
        
        return false;
    }
    
    static Location findLocation(int[][] grid){
        Location location = null;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j]==0){
                    location  = new Location(i,j);
                    return location;
                }
            }
        }
        return location;
    }
    
    static boolean isSafe(int[][] grid,int row,int column,int num){
        return isRowSafe(grid,row,num) && isColumnSafe(grid,column,num)
            && isBoxSafe(grid,row-row%3,column-column%3,num) && (grid[row][column]==0);
    }
    
    static boolean isRowSafe(int[][] grid,int row,int num){
        for(int j=0;j<9;j++){
            if(grid[row][j] == num){
                return false;
            }
        }
        return true;
    }
    static boolean isColumnSafe(int[][] grid,int column,int num){
        for(int i=0;i<9;i++){
            if(grid[i][column] == num){
                return false;
            }
        }
        return true;
    }
    static boolean isBoxSafe(int[][] grid,int row,int column,int num){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i+row][j+column] == num){
                    return false;
                }
            }
        }
        return true;
    }
    static void printGrid(int[][] grid){
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
    
}

class Location{
    int row;
    int column;
    public Location(int row,int column){
        this.row = row;
        this.column = column;
    }
    
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
}