import java.util.*;
import java.io.*;

class Test
{
	static int a;
	Test()
	{
		System.out.println(a++);
	}

	public static void main(String[] args) 
	{
		a = 1;
		Test a[] = new Test[100];
		a[0] = new Test();

		int arr[] = {1,2,3,5,7,9,11};

		System.out.println(Arrays.binarySearch(arr, 10));
	}
}