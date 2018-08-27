import java.util.*;

public class Assignment_3_8_1601me01
{
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String args[])
	{
	//taking input string and splitting it
		String text = scanner.nextLine();
		String data[]= text.split("\\ ");

	//reversing each part
        String rev_data[]= new String[data.length];
        for(int k=0, i=(data.length -1); k<data.length; k++, i--)
        {
        	String temp_str = data[k];			
			rev_data[i] = temp_str;
        }

    //printing the reverse string
        //System.out.println(Arrays.toString(rev_data));

        for(String e : rev_data)
        {
        	System.out.print(e+ " ");
        }
	}
}