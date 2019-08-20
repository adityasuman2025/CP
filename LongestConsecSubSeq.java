class LongestConsecSubSeq
{
    // Function to find Longest Consecutive Subsequence
    int findLongestConseqSubseq(int arr[], int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int item: arr)
        {
            if(!list.contains(item))
                list.add(item);
        }
        Collections.sort(list);
        int N = list.size();
        
        //System.out.println(list);
        
        int max = 1;
        int c=1;
        for(int i=0; i<N-1; i++)
        {
            if(list.get(i+1) == list.get(i)+1)
            {
                c++;
            }
            else
            {
                c=1;
            }
            max = Math.max(max, c);
        }
        
        return max;
    }
}