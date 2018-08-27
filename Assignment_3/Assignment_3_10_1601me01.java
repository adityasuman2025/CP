import java.util.*;

public class Assignment_3_10_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
	//taking input from user and stoting it into a string array
        System.out.print("Number of strings: ");
		int n = Integer.parseInt(scanner.nextLine());

        String input_arr[] = new String[n];
		for(int i=0; i<n; i++)
        {
            input_arr[i] = scanner.nextLine();
        }

        //System.out.println(Arrays.toString(input_arr));

    //arranging in the order of increaing length
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<n-i-1; j++)
        	{
        		int temp_length1 = input_arr[j].length();
        		int temp_length2 = input_arr[j+1].length();

        		if(temp_length1>temp_length2)
        		{
        			String temp = input_arr[j+1];
        			input_arr[j+1] = input_arr[j];
        			input_arr[j] = temp;
        		}
        	}
        }

        //System.out.println(Arrays.toString(input_arr));

 	//appending the padding '' to the left length
        int max = input_arr[n-1].length();

        for(int i=0; i<n; i++)
        {
            String data = input_arr[i];

            int length = input_arr[i].length();
            int padd_length = max- length;

            for(int j=0; j<padd_length; j++)
            {
                input_arr[i] = "_"  +  input_arr[i];
            }

            //System.out.println(input_arr[i].length());
        }

        //System.out.println(Arrays.toString(input_arr));

    //printing in gravity form
        for(int i=0; i<input_arr[0].length(); i++)
        {
        	for(int j=input_arr.length-1; j>=0 ; j--)
        	{
        		char temp = input_arr[j].charAt(i);
        		if(temp != '_')
        		{
        			System.out.print(temp);
        		}
        	}

        	System.out.print(",");
        }
	}
}