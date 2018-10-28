import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DFS_matrix {

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) 
    {
        int n = matrix.length;
        int m = matrix[0].length();
        
    //getting the start index and end index from the matrix
        int start_index[] = new int[2];
        int end_index[] = new int[2];
        
        int flag1 = 0;
        int flag2 =0;
        for(int i = 0; i<n; i++)
        {
            if(flag1 ==1 && flag2 ==1)
            {
                break;
            }
            
            for(int j=0; j<m; j++)
            {
                if(flag1 ==1 && flag2 ==1)
                {
                    break;
                }
                if(matrix[i].charAt(j) == 'M')
                {
                    start_index[0] = i;
                    start_index[1] = j;
                    flag1 = 1;
                }
                
                if(matrix[i].charAt(j) == '*')
                {
                    end_index[0] = i;
                    end_index[1] = j;
                    flag2 = 1;
                }
            }
        }
        
    //using DFS
        boolean visited[][] = new boolean[n][m];
        Stack<int[]> q = new Stack<>();
        q.add(start_index);
        
        int count = 0;
        while(!q.empty())
        {
            int temp_index[] = q.pop();
            int x = temp_index[0];
            int y = temp_index[1];
            
            if(x == end_index[0] && y == end_index[1])
            {
                break;
            }
            if(!visited[x][y])
            {
                visited[x][y] = true;
                //System.out.println(Arrays.toString(temp_index));            
                
                int flag = 0;
                if(x+1<n && y<m && !visited[x+1][y] && (matrix[x+1].charAt(y) == '.' || matrix[x+1].charAt(y) == '*'))
                {
                    int a[] = {x+1,y};
                    q.add(a);
                    flag++;
                }
                
                if(x<n && y+1<m && !visited[x][y+1] && (matrix[x].charAt(y+1) == '.' || matrix[x].charAt(y+1) == '*'))
                {
                    int a[] = {x,y+1};
                    q.add(a);
                    flag++;
                }
                
                if(x-1>=0 && y<m && !visited[x-1][y] && (matrix[x-1].charAt(y) == '.' || matrix[x-1].charAt(y) == '*'))
                {
                    int a[] = {x-1,y};
                    q.add(a);
                    flag++;
                }
                
                if(x<n && y-1>=0 && !visited[x][y-1] && (matrix[x].charAt(y-1) == '.' || matrix[x].charAt(y-1) == '*'))
                {
                    int a[] = {x,y-1};
                    q.add(a);
                    flag++;
                }
                
                if(flag >1)
                {
                    count++;
                    //System.out.println("got two paths at: (" + x + ", " + y + ")");
                }
            }
        }   
        System.out.println(count);
        
        if(count == k)
            return "Impressed";
        else
            return "Oops!";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
