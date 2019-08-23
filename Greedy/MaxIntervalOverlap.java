// Java Program to find maximum guest 
// at any time in a party 
import java.util.*; 

/*
Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
Example :

Input: arrl[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
First guest in array arrives at 1 and leaves at 4, 
second guest arrives at 2 and leaves at 5, and so on.

Output: 5
There are maximum 3 guests at time 5.  
*/

class MaxIntervalOverlap { 

	static void findMaxGuests(int arrl[], int exit[], int n)	 
	{ 
	// Sort arrival and exit arrays 
	Arrays.sort(arrl); 
	Arrays.sort(exit); 

	// guests_in indicates number of guests at a time 
	int guests_in = 1, max_guests = 1, time = arrl[0]; 
	int i = 1, j = 0; 

	// Similar to merge in merge sort to process 
	// all events in sorted order 
	while (i < n && j < n) 
	{ 
		// If next event in sorted order is arrival, 
		// increment count of guests 
		if (arrl[i] <= exit[j]) 
		{ 
			guests_in++; 

			// Update max_guests if needed 
			if (guests_in > max_guests) 
			{ 
				max_guests = guests_in; 
				time = arrl[i]; 
			} 
			i++; //increment index of arrival array 
		} 
		else // If event is exit, decrement count 
		{ // of guests. 
			guests_in--; 
			j++; 
		} 
	} 

	System.out.println("Maximum Number of Guests = "+ 
					max_guests + " at time " + time); 
	} 

	// Driver program to test above function 
	public static void main(String[] args) 
	{ 
		int arrl[] = {1, 2, 10, 5, 5}; 
		int exit[] = {4, 5, 12, 9, 12}; 
		int n = arrl.length; 
		findMaxGuests(arrl, exit, n); 
	} 
} 
// This code is contributed by Prerna Saini 
