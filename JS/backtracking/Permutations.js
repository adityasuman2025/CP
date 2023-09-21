/*
https://leetcode.com/problems/permutations/description/

46. Permutations
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
*/


/**
 * @param {number[]} nums
 * @return {number[][]}
*/
var permute = function(nums) {

    let ans = [];
    function dfs(start) {
        if (start > nums.length) return;

        if (start === nums.length) {
            ans.push([...nums]);
            return;
        }

        for (let j = start; j < nums.length; j++) {
            swap(nums, j, start); // swapping elements in each itterations to get new permutation

            dfs(start + 1);

            swap(nums, j, start); // reversing the swap
        }
    }
    dfs(0, []);

    return ans;
};

function swap(nums, i, j) {
    let temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
}