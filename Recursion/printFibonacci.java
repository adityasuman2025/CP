class printFibonacci
{
	public static void print(int n)
	{	
		int f0 = 0;
		int f1 = 1;
		System.out.print(f0 + " ");
		System.out.print(f1 + " ");

		for(int i=0; i<n-2; i++)
		{
			int new_f = f0+f1;
			System.out.print(new_f + " ");

			f0 = f1;
			f1 = new_f;
		}	
		System.out.println();
	}

	public static void main(String[] args) {
		print(10);
		
	}
}