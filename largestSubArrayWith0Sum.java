class largestSubArrayWith0Sum
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>(); //<sum, sum upto index>
        int sum =0;
        int max = 0;
        for(int i=0; i<n; i++)
        {
            sum+=arr[i];
            
            if(sum==0)
            {
                max = Math.max(max,i+1);
            }
            
            if(map.containsKey(sum))
            {
                int oldIndex = map.get(sum);
                max = Math.max(max, i-oldIndex);
            }
            else
            {
                map.put(sum, i);
            }
        }
        
        return (max);
    }
}