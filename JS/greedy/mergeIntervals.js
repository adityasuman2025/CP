/*
https://leetcode.com/problems/merge-intervals/description/

56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
*/

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);

    let ans = [];
    let prevStart = intervals[0][0], prevEnd = intervals[0][1];
    for (let i = 1; i < intervals.length; i++) {
        const [thisStart, thisEnd] = intervals[i];

        if (thisStart <= prevEnd) {
            prevEnd = Math.max(thisEnd, prevEnd);
        } else {
            ans.push([prevStart, prevEnd]);
            prevStart = thisStart, prevEnd = thisEnd;
        }
    }
    ans.push([prevStart, prevEnd]);

    return ans;
};
