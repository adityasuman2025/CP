/*
https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75

283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

*/

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    let j = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[j] = nums[i]
            j++
        }
    }

    for (let i = j; i < nums.length; i++) nums[i] = 0;

    return nums;
};