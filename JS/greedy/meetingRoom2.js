/*
    https://neetcode.io/problems/meeting-schedule-ii/question

    Meeting Rooms II

    Medium
    Topics
    Company Tags

    Hints
    Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of rooms required to schedule all meetings without any conflicts.

    Note: (0,8),(8,10) is NOT considered a conflict at 8.

    Example 1:

    Input: intervals = [(0,40),(5,10),(15,20)]

    Output: 2
    Explanation:
    room1: (0,40)
    room2: (5,10),(15,20)

    Example 2:

    Input: intervals = [(4,9)]

    Output: 1
    Constraints:

    0 <= intervals.length <= 500
    0 <= intervals[i].start < intervals[i].end <= 1,000,000
*/

/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {number}
     */
    minMeetingRooms(arr) {
        const start = [], end = [];
        for (let i = 0; i < arr.length; i++) {
            start.push(arr[i].start);
            end.push(arr[i].end);
        }
        start.sort((a, b) => a - b);
        end.sort((a, b) => a - b);

        let c = 0, s = 0, e = 0;
        let max = 0;
        while (s < arr.length && e < arr.length) {
            if (start[s] < end[e]) {
                // if any meeting is starting before ending of another meeting
                // i.e count of con-current meeting is increasing
                // so 1 more rooms is required
                c++;
                s++;
            } else {
                // start[s] >= end[e]
                // any older meeting is ending before starting a new meeting
                // i.e count of con-current meeting is decreasing
                // so 1 room is geeting freed
                c--;
                e++;
            }

            max = Math.max(max, c);
        }

        return max;
    }
}
