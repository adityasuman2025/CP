import java.util.*;

public class Assignment_3_11_1601me01
{
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String args[])
	{
		String text = scanner.nextLine();
		char arr[] = text.toCharArray();

		for(int i=0; i< arr.length; i++)
		{
			char ch = arr[i];

			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
			{
				arr[i] = '$';
			}
		}

		//System.out.println(Arrays.toString(arr));

	//printing the desired string
        for(char e : arr)
        {
            System.out.print(e);
        }
	}
}