import java.util.*;
import java.io.*;
class exitFromMatrix
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
    {
        int T = Integer.parseInt(bf.readLine());
        for(int a=0; a<T; a++)
        {
            String input[] = (bf.readLine().split(" "));
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            
            String str[] = bf.readLine().split(" ");
            int direc = 1; //1: East, 2: West, 3: North, 4: South

            int i=0, j=0;
            while(i>=0 && j>=0 && i<N && j<M)
            {
                if(str[i*M+j].equals("1"))
                {
                    str[i*M+j] = "0";
                    
                    if(direc == 1)//going towrds east
                    {
                    //making to south
                        direc = 4;
                        i++;
                    }
                    else if(direc == 2)//going towrds west
                    {
                    //making to north
                        direc = 3;
                        i--;
                    }
                    else if(direc == 3)//going towrds north
                    {
                    //making to east
                        direc = 1;
                        j++;
                    }
                    else if(direc == 4)//going towrds south
                    {
                    //making to west
                        direc = 2;
                        j--;
                    }
                }
                else //0
                { 
                    if(direc == 1)//going towrds east
                    {
                        j++;
                    }
                    else if(direc == 2)//going towrds west
                    {
                        j--;
                    }
                    else if(direc == 4)//going towrds south
                    {
                        i++;
                    }
                    else if(direc == 3)//going towrds north
                    {
                        i--;
                    }
                }
            }   
            if(i<0)
                i++;
                
            if(i>=N)
                i--;
            
            if(j<0)
                j++;
                
            if(j>=M)
                j--;
                
            System.out.println(i + " " + j);
        }
    }
}