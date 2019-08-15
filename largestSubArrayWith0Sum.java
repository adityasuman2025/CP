class largestSubArrayWith0Sum
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>(); //<sum, sum upto index>
        int sum =0;
        int max = 0;
        for(int i=0; i<n; i++)
        {
            sum +=arr[i];
           
            if(map.containsKey(sum))
            {
                int oldIndex = map.get(sum);
                
                if(sum == 0)
                    max = i+1;
                else if((i-oldIndex)>max)
                    max = (i-oldIndex); //i = new index
            }
            else
            {
                map.put(sum, i);
            }
        }
        
        return (max);
    }
}