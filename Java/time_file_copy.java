import java.io.*; 
import java.util.*;

class time_file_copy
{
	public static void main(String args[]) throws Exception
	{
		long startTime = System.nanoTime();

	//file from which content is read		
		File f = new File("test.txt");
		Scanner sc = new Scanner(f);
	
	//file to copy content into	
		File f2 = new File("backup.txt");
		FileWriter fr = new FileWriter(f2);
	
	//copying the content	
		while(sc.hasNextLine())
		{
			fr.write(sc.nextLine());
		}
		
		fr.close();
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(Math.floor((float)totalTime/1000000000.0*100)/100 + " seconds");
	}
}
