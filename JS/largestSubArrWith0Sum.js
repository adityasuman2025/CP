/*
https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

Largest subarray with 0 sum
Join the most popular course on DSA. Master Skills & Become Employable by enrolling today! 
Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
*/


/**
 * @param {Number[]} arr
 * @param {Number} n
 * @returns {Number}
 */

/*
    LOGIC
    1. we keep storing prefixSum at each index in a map
    2. we loop over the array and keep doing prefix sum
    3. if we encounter the same prefixSum at any point then we know that, sum of array b/w this index and the already present prefixSum's index in map is 0
    4. so length of that array will be thisIndex - prevPrefixSumIdx

*/
class Solution {
    maxLen(arr, n) {
        let map = new Map(); // sum to index map

        let max = 0, prefixSum = 0;
        for (let i = 0; i < n; i++) {
            prefixSum += arr[i];

            if (prefixSum === 0) max = i + 1;

            if (map.has(prefixSum)) {
                let prevPrefixSumIdx = map.get(prefixSum);
                max = Math.max(max, i - prevPrefixSumIdx);
            } else {
                map.set(prefixSum, i);
            }
        }

        return max;
    }
}