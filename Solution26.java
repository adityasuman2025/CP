import java.util.Scanner;

public class Solution26	 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

    //getting actual date
        String actual_date[] = scanner.nextLine().split(" ");
        int actual_d = Integer.parseInt(actual_date[0]);
        int actual_m = Integer.parseInt(actual_date[1]);
        int actual_y = Integer.parseInt(actual_date[2]);

    //getting expected date
        String expected_date[] = scanner.nextLine().split(" ");
        int expected_d = Integer.parseInt(expected_date[0]);
        int expected_m = Integer.parseInt(expected_date[1]);
        int expected_y = Integer.parseInt(expected_date[2]);

    //due date    
        int due_date = actual_d - expected_d;
        int due_month = actual_m - expected_m;
        int due_year= actual_y - expected_y;

        int fine = 0;

		if(due_year <0)
		{
			fine = 0;
		}
		else
		{
			if(due_year >0)
			{
				fine = 10000;
			}
			else if(due_month >0)
			{
				fine = 500 * due_month;
			}
			else if(due_date >0)
			{
				fine = 15 * due_date;
			}
		}
       
        System.out.println(fine);
    }
}