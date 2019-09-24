class DayOfADate //tomohiko_sakamoto 
{ 
    // function to implement tomohiko sakamoto algorithm 
    public static int day_of_the_week(int y, int m, int d) 
    { 
        // array with leading number of days values 
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 }; 
          
        // if month is less than 3 reduce year by 1 
        if (m < 3) 
            y -= 1; 
          
        return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7; 
    } 
    // Driver Code 
    public static void main(String args[]) 
    { 
        int day = 13, month = 7, year = 2017; 
        System.out.println(day_of_the_week(year, month, day)); 
    } 
} 