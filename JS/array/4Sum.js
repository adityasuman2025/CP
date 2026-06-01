/*
https://leetcode.com/problems/4sum/description/

18. 4 Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
*/

// time: O(n^3), space: O(1)
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(arr, target) {
    arr.sort((a, b) => a - b);

    const len = arr.length;
    const ans = [];

    for (let i = 0; i < len; i++) {
        for (let j = i + 1; j < len; j++) {
            let start = j + 1, end = arr.length - 1;

            while (start < end) {
                const sum = arr[i] + arr[j] + arr[start] + arr[end];

                if (sum === target) {
                    ans.push([arr[i], arr[j], arr[start], arr[end]]);

                    start++;
                    while (arr[start] === arr[start - 1]) start++; // to avoid duplicates

                    end--;
                    while (arr[start] === arr[end + 1]) end--; // to avoid duplicates
                } else if (sum > target) {
                    end--;
                    while (arr[end] === arr[end + 1]) end--; // to avoid duplicates
                } else {
                    start++;
                    while (arr[start] === arr[start - 1]) start++; // to avoid duplicates
                }
            }

            while (arr[j] === arr[j + 1]) j++; // to avoid duplicates
        }

        while (arr[i] == arr[i + 1]) i++; // to avoid duplicates
    }

    return ans;
};
