class matchPattern
{
    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    String givenPattern = stringToPattern(pattern);
	    //System.out.println("given pattern:" + givenPattern);
	    
	    ArrayList<String> ans = new ArrayList<>(); 
	    for(String str: dict)
	    {
	        String tempPattern = stringToPattern(str); 
	        //System.out.println(tempPattern);
	        
	        if(tempPattern.equals(givenPattern))
	            ans.add(str);
	    }
	     
	    return ans;
	}
	
	static String stringToPattern(String pattern)
	{
	    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
	    LinkedHashMap<Character, Integer> charToIndex = new LinkedHashMap<>();
	    
	    for(int i=0; i<pattern.length(); i++)
	    {
	        char c= pattern.charAt(i);
	        if(charToIndex.containsKey(c))
	        {
	            int orgIndex = charToIndex.get(c);
	            
	            map.put(i, orgIndex);
	        }
	        else
	        {
	            charToIndex.put(c, i);
	            map.put(i,-1);
	        }
	    }
	    
	    String ans ="";
	    for(int key: map.keySet())
	    {
	        int val = map.get(key);
	        
	        ans += Integer.toString(val);
	    }
	    
	    return ans;
	}
}