/*
https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75

1004. Max Consecutive Ones III
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/

// This question is basically asking maximum number of 0's we can have in our window such that this number is less than or equal to k
var longestOnes = function (arr, k) {
    let left = 0, numZeroes = 0;
    let maxC = 0;
    for (let right = 0; right < arr.length; right++) {
        if (arr[right] == 0) numZeroes++;

        if (numZeroes > k) {
            if (arr[left] == 0) numZeroes--;
            left++;
        } else {
            maxC = Math.max(maxC, right - left + 1);
        }
    }

    return maxC;
};
