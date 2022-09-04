/*
https://practice.geeksforgeeks.org/problems/maximum-intervals-overlap5708/1

Maximum Intervals Overlap
MediumAccuracy: 62.14%Submissions: 6263Points: 4
Consider a big party where N guests came to it and a log register for guest’s entry and exit times was maintained. Find the minimum time at which there were maximum guests at the party. Note that entries in the register are not in any order.

Note: Guests are leaving after the exit times.

Example 1:
Input:
N = 5
Entry= {1, 2,10, 5, 5}
Exit = {4, 5, 12, 9, 12}
Output: 3 5
Explanation: At time 5 there were 
             guest number 2, 4 and 5 present.

             Example 2:
Input:
N = 7
Entry= {13, 28, 29, 14, 40, 17, 3}
Exit = {107, 95, 111, 105, 70, 127, 74}
Output: 7 40
Explanation: At time 40 there were 
             all 7 guests present in the party.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxGuests() which takes 3 arguments(Entry array, Exit array, N) and returns the maximum number of guests present at a particular time and that time as a pair.

Expected Time Complexity: O(N*Log(N) ).
Expected Auxiliary Space: O(1).
*/

function findMaxGuests(entry, exit, n) {
    entry = entry.sort((a,b)=>a-b); // [1,2,5,5,10]
    exit = exit.sort((a,b)=>a-b); // [4,5,9,12,12]
    let guestsInCount = 1, maxGuestsCount = 1, timeAtMaxGuests = entry[0];
    
    let i = 1, j = 0;
    while (i<n && j<n) {
        if (entry[i] <= exit[j]) {
            //one new guest comes
            guestsInCount++;
            if (guestsInCount > maxGuestsCount) {
                maxGuestsCount = guestsInCount;
                timeAtMaxGuests = entry[i]
            }
            i++;
        } else {
            //one guest leaves
            guestsInCount--;
            j++
        }
    }
    
    return [maxGuestsCount, timeAtMaxGuests];
}