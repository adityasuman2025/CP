import java.util.*;
import java.lang.*;
import java.io.*;

class noFollowPattern 
{
	static Scanner scanner = new Scanner(System.in);
	public static void main (String[] args) 
	{
		int T = Integer.parseInt(scanner.nextLine());
        for(int a =0; a<T; a++)
        {
            String pattern = scanner.nextLine();
            
            Stack<Integer> stk=new Stack<Integer>();
            String res=new String();
            for(int i=0;i<=pattern.length();++i)
            {
                stk.push(i+1);
                if(i==pattern.length() || pattern.charAt(i)=='I')
                {
                    System.out.println(stk);
                    while(!stk.isEmpty())
                    {
                        res+=Integer.toString(stk.pop());
                    }
                }
            }
            
            System.out.println(res);
        }
	}
}