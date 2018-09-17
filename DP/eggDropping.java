class eggDropping
{
	static void eggDrop(int f, int e)
	{
		int table[][] = new int[f+1][e+1];

	//base conditions
		//if he has only 1 egg and i floors then he need i attempts
		for(int i =1; i<=f; i++)
		{
			table[i][1] = i;
		}

		//if he has i eggs and only 0 or 1 floor
		for(int i=1; i<=e; i++)
		{
			table[1][i] = 1;
			table[0][i] = 0;
		}

	//main operation
		int res;
		for(int i=2; i<=e; i++) // i for egg
		{
			for(int j=2; j<=f; j++) // j for floor 
			{
				table[j][i] = Integer.MAX_VALUE;
				for(int x=1; x<=j; x++)
				{
					res = 1 + Math.max(table[x-1][i-1], table[j-x][i]); //max(when egg breaks, when it does not break)

					if(res<table[j][i])
					{
						table[j][i] = res;
					}
				}
			}
		}

		System.out.println(table[f][e]);
	}

	public static void main(String[] args) {
		eggDrop(15,3);
	}
}