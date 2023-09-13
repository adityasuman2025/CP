/*
https://leetcode.com/problems/3sum/description/

15. 3Sum
Medium
28.4K
2.6K
Companies
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

*/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (arr) {
    arr.sort((a, b) => a - b);

    let ans = [];
    for (let i = 0; i < arr.length && arr[i] <= 0; i++) {
        let target = 0 - arr[i];

        if (i > 0 && arr[i - 1] === arr[i]) continue; // to avoid duplicates

        let start = i + 1, end = arr.length - 1;
        while (start < end) {
            let sum = arr[start] + arr[end];

            if (sum === target) {
                ans.push([arr[i], arr[start], arr[end]]);

                start++;
                while (arr[start] === arr[start - 1] && start < end) start++;  // to avoid duplicates
            } else if (target > sum) {
                start++;
            } else {
                end--;
            }
        }
    }

    return (ans);
};
