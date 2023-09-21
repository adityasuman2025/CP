/*
https://leetcode.com/problems/subsets/description/

78. Subsets
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
*/


/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    let ans = [];
    function dfs(start, arr) {
        if (start > nums.length) return;

        if (start === nums.length) {
            ans.push(arr);
            return;
        }

        // in each iteration, either we can take/consider that element or skip it
        dfs(start + 1, arr); // not taking that element
        dfs(start + 1, [...arr, nums[start]]); // taking that element
    }
    dfs(0, []);

    return ans;
};