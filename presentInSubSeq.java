public class presentInSubSeq
{
	// Complete the hackerrankInString function below.
    static String presentInString(String s, String to_find) 
    {
        String str = to_find;
        if (s.length() < str.length()) {
            return "NO";
        }
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            if (j < str.length() && s.charAt(i) == str.charAt(j)) 
            {
                    j++;
            }
        }
        
        return (j == str.length() ? "YES" : "NO");
    }

	public static void main(String[] args) 
	{
		System.out.println(presentInString("hereiamstackerrank", "hackerrank"));
	}
}