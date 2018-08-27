import java.util.*;
import java.io.*;

class Student extends Person
{    
	private int testScores[];
    String firstName;
    String lastName;
    int id;


    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */

// Write your constructor here
    public Student( String firstName, String lastName, int id, int testScores[])
    {
        super(firstName, lastName, id);

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.testScores = testScores;
    }

    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */

// Write your method here
    public char calculate()
    {
        int marks[] = this.testScores;
        int n =  marks.length;

        int total_marks = 0;
        int a;

        for(int k=0; k<n; k++)
        {
            total_marks += marks[k];
        }

        a  = total_marks/n;

    //deciding grade
        if(a>=90 && a<=100)
        {
            return 'O';
        }   
        else if(a>=80 && a<=90)
        {
            return 'E';
        }
        else if(a>=70 && a<=80)
        {
            return 'A';
        }
        else if(a>=55 && a<=70)
        {
            return 'P';
        }
        else if(a>=40 && a<=55)
        {
            return 'D';
        }
        else if(a<40)
        {
            return 'T';
        }
        else
        {
            return 'M';
        }
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        int id;
       
    //student info
        String arrRowItems[] = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        firstName = arrRowItems[0];
        lastName = arrRowItems[1];
        id = Integer.parseInt(arrRowItems[2]);

    //student marks
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int student_marks[] = new int[n];

        String student_marks_string[] = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < n; j++) 
        {
            int arrItem = Integer.parseInt(student_marks_string[j]);
            student_marks[j] = arrItem;

            //System.out.println(arrItem);
        }

    //creating objects
        Student s  = new Student(firstName, lastName, id, student_marks);
        
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
   
    }
}