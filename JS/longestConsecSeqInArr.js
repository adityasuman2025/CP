/*
https://leetcode.com/problems/longest-consecutive-sequence/

128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

// time: O(nlogn), space: O(1)
var longestConsecutive = function(arr) {
    if (!arr.length) return 0;

    arr.sort((a, b) => a - b);

    let len = 1, max = 1, prev = arr[0];
    for (let i = 1; i < arr.length; i++) {
        const item = arr[i];
        if (item === prev) continue;
        if (item === prev + 1) len++;
        else len = 1;

        max = Math.max(max, len);
        prev = item;
    }

    return max;
};

// time: O(n), space: O(n)
const longestConsecutiveOptimised = function(arr) {
    //we are storing array value in set, because array can be too large because of repeated values, which can cause TLE
    const set = new Set(arr);

    let maxLen = 0;
    set.forEach(item => {
        if (!set.has(item - 1)) { // if there is no item present smaller than current item // then we started looking for larger elements
            let j = item;
            while (set.has(j)) j++;

            maxLen = Math.max(maxLen, j - item)
        }
    });

    return maxLen;
};