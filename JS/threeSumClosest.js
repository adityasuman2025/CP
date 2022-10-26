/*
    https://leetcode.com/problems/3sum-closest/

    16. 3Sum Closest
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

    Return the sum of the three integers.

    You may assume that each input would have exactly one solution.


    Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    
    Example 2:
    Input: nums = [0,0,0], target = 1
    Output: 0
    Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
*/
function threeSumClosest(arr, target) {
    let n = arr.length;
        arr = arr.sort((a, b) => a-b)
        
        let ans = 0;
        let closestDist = Number.MAX_SAFE_INTEGER;
        for (let i = 0; i<n-2; i++) {
            let start = i+1, end = n-1;
            
            // 2 sum approach
            while (start < end) {
                let sum = arr[i] + arr[start] + arr[end];
                
                // Check if this total is closer than the previous one
                if (Math.abs(sum - target) < closestDist) {
                    closestDist = Math.abs(sum - target)
                    ans = sum;
                }
                
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return ans;
};