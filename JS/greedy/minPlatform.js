/*
https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

Minimum Platforms

Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.


Example 1:

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPlatform() which takes the array arr[] (denoting the arrival times), array dep[] (denoting the departure times) and the size of the array as inputs and returns the minimum number of platforms required at the railway station such that no train waits.

Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this may be > 59).


Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n)
*/


/*
    LOGIC
    We are trying to know, any moment where maximum number of trains are present on the station
    so the maximum no of trains will become the max number of platforms, as to adjust that many trains at any moment we need that many platforms


    1. We sort both the arrays and will take two pointer approach
    2. if arrival time of any train is less than departure time of any train, means at that moment 2 trains are there on the station, so 2 platforms are needed
    3. in this case we will increase arrival pointer, so that we can check if any more train exist whose arrival time is less than departure time of any train
    and vise versa
*/

class Solution {
    findPlatform(arrival, departure, n) {
        // Sort the arrival and departure times
        arrival.sort((a, b) => a - b);
        departure.sort((a, b) => a - b);

        let platformsAtTheMoment = 0;
        let maxPlatforms = 0;

        let i = 0; // Pointer for arrival times
        let j = 0; // Pointer for departure times

        while (i < arrival.length && j < departure.length) {
            if (arrival[i] <= departure[j]) { // one more train is present at the moment
                platformsAtTheMoment++;
                i++;
            } else { // one train has left at the moment
                platformsAtTheMoment--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platformsAtTheMoment);
        }

        return maxPlatforms;
    }
}