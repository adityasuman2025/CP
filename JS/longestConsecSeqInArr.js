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
const longestConsecutive = function(nums) {
    if (nums.length === 0) return 0;
    nums.sort((a, b) => a - b);

    let c = 1, maxC = 1, prev = nums[0];
    for (let i = 1; i < nums.length;) {
        if (nums[i] === prev + 1) {
            c++;
            prev = nums[i];
            maxC = Math.max(maxC, c);
        } else {
            c = 1;
            prev = nums[i];
        }

        i++;
        while (nums[i - 1] === nums[i]) i++;
    }

    return maxC;
}

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