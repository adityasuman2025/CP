import java.io.*;
import java.util.*;

public class array 
{	
	public static <E, T> void printArray(E array[], T b)
	{
		for(E element : array)
		{
			System.out.print(element + ", ");
		}

		System.out.println("Hello friends: " + b);
	}
	
	public static void main(String args[])
	{
		String array2[] = {"Hello ", " World", "! I am", " here"};

		Integer array[] = {5,1,2,3};
		String hello = "gud";
		int ok = 9;

		printArray(array2, ok);
		//System.out.println("");
		//printArray(array);
	}
}