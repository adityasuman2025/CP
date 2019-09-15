class PreOrderToBSTNew 
{
	static boolean isBST(int preOrder[])
	{
		int N = preOrder.length;

		Stack<Integer> st = new Stack<>();

		int root = Integer.MIN_VALUE;
		for(int i=0; i<N; i++)
		{
			if(pre[i]>root)
				return false;

			while(!st.isEmpty() && pre[i]>st.peek())
			{
				root = st.pop();
			}

			st.push(pre[i]);
		}

		return true;
	}
}