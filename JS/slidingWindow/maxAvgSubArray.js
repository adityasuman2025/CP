/*
https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75

643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
*/


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

// var findMaxAverage = function(nums, k) {
//     let len = nums.length, sum = Number.MIN_SAFE_INTEGER;

//     for (let i=0; i<len-k+1; i++) {
//         let thisSum = 0;
//         for (let j=i; (j<i+k) && (j<len) ; j++) {
//             thisSum += nums[j];
//         }

//         sum = Math.max(sum, thisSum);
//     }

//     return sum/k;
// };

var findMaxAverage = function (nums, k) {
    let len = nums.length, maxSum = Number.MIN_SAFE_INTEGER;

    let left = 0, thisSum = 0;
    for (let right = 0; right < len; right++) {
        thisSum += nums[right];

        if (right >= k - 1) {
            maxSum = Math.max(thisSum, maxSum);

            thisSum -= nums[left];
            left++;
        }
    }

    return maxSum / k;
};