import java.util.*;
import java.io.*;

class twin_java
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//function to remove duplcate characters from a string
	static String removeDuplicatesFromString(String string)  
    {  
        int[] table = new int[256]; 
        char[] chars = string.toCharArray(); 
  
        int endIndex = 0; 
      
        for(int i = 0; i < chars.length; i++) 
        { 
            if(table[chars[i]] == 0) 
            { 
                table[chars[i]] = -1; 
                chars[endIndex++] = chars[i];  
            } 
        } 
      
        char res[] =  Arrays.copyOfRange(chars, 0, endIndex); 
        return new String(res);
    }

//function to check if two words are twin words
    static boolean checkTwin(String s1, String s2)
    {
    	String arr[] = new String[2];
    	arr[0] = s1;
    	arr[1] = s2;

    	HashMap<Character, Integer> map = new HashMap<>(); // to store consonants

		for(int i=0; i<2; i++)
		{
			arr[i] = arr[i].toUpperCase();	
			arr[i] = removeDuplicatesFromString(arr[i]);

			int len = arr[i].length();
			for(int k=0; k< len; k++) //iterating through characters of the words
			{
				char c = arr[i].charAt(k);
				if(c!='A' && c!='E' && c!='I' && c!='O' && c!='U') // checking for consonant
				{
					if(map.containsKey(c))
					{
						int val = map.get(c);
						map.put(c, val+1);						
					}
					else
					{
						map.put(c, 1);
					}
				}					
			}
		}
		
	//checking if words are twin or not	
		for(char c: map.keySet())
		{
			int val = map.get(c);
			if(val!=2)
			{				
				return false;
			}
		}

		return true;		
    }

//main function
	public static void main(String[] args) throws Exception
	{
		System.out.println("\nChoose your case");
		System.out.println("1. Check if two words are \"Twin words\" of each other\n2. Print sets of \"Twin Words\" from test.txt file\n3. Print \"Twin Phrases\" from test2.txt");
		int opt = Integer.parseInt(bf.readLine());
		
		if(opt == 1) // to check for twin words
		{
			System.out.println("\n\nChecking for if two words are Twin words");
			System.out.println("Enter two words seperated by space");
			String arr[] = bf.readLine().split(" ");

			boolean res = checkTwin(arr[0], arr[1]); //checking twin words
			if(res)
				System.out.println("They are Twin Words");
			else
				System.out.println("Not Twin Words");
		}
		else if(opt == 2) // to print set of twin words
		{
			System.out.println("\n\nPrinting sets of Twin Words from test.txt file");

			File file = new File("test.txt"); //reading input from external file
			BufferedReader br = new BufferedReader(new FileReader(file)); 

			ArrayList<String> words = new ArrayList<>();			
			String st;
			while((st = br.readLine()) != null) 
				words.add(st); //storing words from external file into array

			int len = words.size();

			ArrayList<String> ans = new ArrayList<>();
			for(int i=0; i<len; i++)
			{
				String s1 = words.get(i);

				for(int j=0; j<len; j++)
				{
					if(j!=i)
					{
						String s2 = words.get(j);

						boolean res = checkTwin(s1, s2); //checking twin words
						if(res)
						{
							ans.add(s1 + ", " + s2);
							break;
						}
					}
				}
			}
			
			for(String str: ans) //printing the twin word set
				System.out.println(str);
		}
		else if(opt == 3) //printing twin phrases
		{
			System.out.println("\n\nPrinting sets of Twin Phrases from test2.txt file");

			File file = new File("test2.txt"); //reading input from external file
			BufferedReader br = new BufferedReader(new FileReader(file)); 

			ArrayList<String> phrases = new ArrayList<>();			
			String st;
			while((st = br.readLine()) != null) 
				phrases.add(st); //storing phrases from external file into array

			int len = phrases.size();
			for(int q=0; q<len; q++)
			{
				String arr[] = phrases.get(q).split(" ");
				int size = arr.length;

				boolean isTwin[] = new boolean[size]; // to maintain boolean if twin of that word exist or not

			//storing all words of other phrases in words array
				ArrayList<String> words = new ArrayList<>();
				for(int j=0; j<len; j++)
				{
					if(j!=q)
					{
						String temp[] = phrases.get(j).split(" ");						
						for(String str: temp)
							words.add(str);
					}
				}
				int n = words.size();

			//checking twin phrases	
				for(int i=0; i<size; i++)
				{
					String s1 = arr[i];

					for(int j=0; j<n; j++)
					{
						String s2 = words.get(j);

						boolean res = checkTwin(s1, s2); //checking twin words
						if(res)
						{
							isTwin[i] = true;
							break;
						}
					}
				}
			
				int flag = 0;
				for(boolean b: isTwin)
				{
					if(b==false) // twin not found for that word
					{
						flag =1;
						break;
					}
				}

				if(flag == 0) //all words of that phrase contains a twin in other phrases
					System.out.println(phrases.get(q));
			}
		}
		else
		{
			System.out.println("Wrong input choosen");		
		}
	}
}