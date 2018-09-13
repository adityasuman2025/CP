import java.util.*;

class countBinaryStrings
{
	static void count(int n)
	{
		int a[] = new int[n];
		int b[] = new int[n];

	//base condition
		a[0] = 1;
		b[0] = 1;

	//solving problem
		for(int i =1; i<n; i++)
		{
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}

		System.out.println(a[n-1] + b[n-1]);
	}

	public static void main(String[] args) {
		count(5);
	}	
}