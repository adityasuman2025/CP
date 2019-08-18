import java.util.*;

public class Assignment_3_9_1601me01
{
    public static void print_spiral(String arr[])
    {
        int m = arr.length; //end length of the row
        int n = arr[0].length(); //end length of the column
        int k = 0; //starting row index
        int l = 0; //starting column index
        int i = 0; // iterator

        // System.out.println("row: " + m);
        // System.out.println("column: " + n);

        while(k<m && l<n)
        {
        //printing the first row
            for(i=l; i<n; i++)
            {
                System.out.print(arr[k].charAt(i));
            }
            k++;

        //printing the last column
            for (i = k; i < m; ++i)
            {
                System.out.print(arr[i].charAt(n-1));
            }
            n--;
  
        //Printing the last row from the remaining rows
            if ( k < m)
            {
                for (i = n-1; i >=l; --i)
                {
                    System.out.print(arr[m-1].charAt(i));
                }
                m--;
            }
  
        //Printing the first column from the remaining columns
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.print(arr[i].charAt(l));
                }
                l++;    
            }        
        }
    }

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

    //finding the length of greatest string in the array
        int max = input_arr[0].length();
        for(int i=0; i<n; i++)
        {
            int length = input_arr[i].length();
            if(length> max)
            {
                max = length;
            }
        }

        //System.out.println(max);

    //appending the padding 'J' to the left length
        for(int i=0; i<n; i++)
        {
            String data = input_arr[i];

            int length = input_arr[i].length();
            int padd_length = max- length;

            for(int j=0; j<padd_length; j++)
            {
                input_arr[i] = input_arr[i] + "J";
            }
        }

    //printing the desired string
        // for(String e : input_arr)
        // {
        //     System.out.print(e);
        // }

    //printing in the spiral form
        print_spiral(input_arr);
	}
}