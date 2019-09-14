class LRUCache 
{
    Queue<Integer> q = new LinkedList<>();
    
    HashMap<Integer,Integer> map;
    int capacity;
    
    public LRUCache(int N) 
    {
       map = new HashMap<>();
       capacity = N;
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x)
    {
        if(map.containsKey(x))
        {
            q.remove(new Integer(x));
            q.add(x); 
            
            return map.get(x);
        }    
        return -1;
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) 
    {
        if (!q.contains(x)) 
        { 
            if(q.size() == capacity)
            {
                int oldest = q.poll(); 
                map.remove(oldest); 
            } 
        } 
        else 
        { 
            q.remove(new Integer(x)); 
        } 
        q.add(x); 
        map.put(x, y); 
        
        //System.out.println(q);
    }
}