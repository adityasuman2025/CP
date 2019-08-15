import java.util.*;
import java.io.*;

class smallestDistinctWindow
{
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws Exception
	{
	    int T = Integer.parseInt(bf.readLine());
	    for(int a=0; a<T; a++)
	    {
	        String s = bf.readLine();
	        String t=new String();
	        
	       Set<String> set=new HashSet<>();
    	    for(int i=0;i<s.length();i++)
    	    set.add(Character.toString(s.charAt(i)));
    	    t=String.join("",set);
    	    
    	    
    	    
    	    String res="";
    	    int letterCount[]=new int[256];
    	    int left=0,count=0,minLen=Integer.MAX_VALUE;
    	    
    	    for(char c:t.toCharArray()){
    	        ++letterCount[c];
    	    }
    	    
    	    for(int right=0;right<s.length();right++){
    	        if(--letterCount[s.charAt(right)]>=0)
    	        count++;
    	        
    	        while(count==t.length()){
    	            if(minLen>right-left+1){
    	            minLen=right-left+1;
    	            res=s.substring(left,right+1);
    	            }
    	            if(++letterCount[s.charAt(left)]>0)
    	            count--;
    	            
    	            left++;
    	            
    	            
    	        }
    	    }
    	    System.out.println(minLen);
	    }
	}
}