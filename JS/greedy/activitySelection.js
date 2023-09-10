/*
https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1

Activity Selection
Join the most popular course on DSA. Master Skills & Become Employable by enrolling today! 
Given N activities with their start and finish day given in array start[ ] and end[ ]. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.
Note : Duration of the activity includes both starting and ending day.


Example 1:

Input:
N = 2
start[] = {2, 1}
end[] = {2, 2}
Output: 
1
Explanation:
A person can perform only one of the
given activities.
Example 2:

Input:
N = 4
start[] = {1, 3, 2, 5}
end[] = {2, 4, 3, 6}
Output: 
3
Explanation:
A person can perform activities 1, 2
and 4.

Your Task :
You don't need to read input or print anything. Your task is to complete the function activityselection() which takes array start[ ], array end[ ] and integer N as input parameters and returns the maximum number of activities that can be done.


Expected Time Complexity : O(N * Log(N))
Expected Auxilliary Space : O(N)
*/


class Solution {
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    activitySelection(startArr, endArr, n) {
        // making a single array for startArr & endArr and sorting it by end
        // because we will firstly do activities that are ending earlier so that we can do maximum activities
        const arr = startArr.map((start, idx) => ({ start, end: endArr[idx] }));
        arr.sort((a, b) => a.end - b.end);

        let prevEnd = arr[0].end; // we will start with the activity with least end time
        let c = 1;
        for (let i = 1; i < n; i++) {
            const { start: thisstart, end: thisEnd } = arr[i];

            if (thisstart > prevEnd) { // if this activity starts strictly after end time of the last/prev activity // only then man can do the activity
                c++;
                prevEnd = thisEnd;
            }
        }

        return c;
    }
}