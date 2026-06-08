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
var findMaxAverage = function(arr, k) {
    let maxSum = -Infinity;

    let start = 0, sum = 0;
    for (let end = 0; end < arr.length; end++) {
        sum += arr[end];

        if (end - start + 1 > k) {
            sum = sum - arr[start];
            start++;
        }

        if (end - start + 1 === k) maxSum = Math.max(maxSum, sum);
    }

    return maxSum / k;
};