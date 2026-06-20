/*
https://leetcode.com/problems/non-overlapping-intervals/

435. Non-overlapping Intervals
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/

// this is similar to activity selection problem
var eraseOverlapIntervals = function(intervals) {
    if (!intervals.length) return 0;

    intervals.sort((a, b) => a[1] - b[1]);

    let nonOverlapCount = 0;
    let prevEndTime = -Infinity;
    for (let i = 0; i < intervals.length; i++) {
        const [start, end] = intervals[i];

        if (start >= prevEndTime) {
            prevEndTime = end;
            nonOverlapCount++;
        }
    }

    return intervals.length - nonOverlapCount
};