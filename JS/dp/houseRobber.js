/*
https://leetcode.com/problems/house-robber/

198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/

//solution: https://www.youtube.com/watch?v=ZwDDLAeeBM0


//logic is that, either robber will rob this house or not

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let dp = [];
    dp[0] = nums[0];

    for (let i = 1; i < nums.length; i++) {
        if (i == 1) {
            dp[i] = Math.max(nums[i], dp[i - 1]);
            //for second house
            //1. if he robs this house then we can't include his first robbery
            //2. if he not robs this house then we can't include his first robbery
        } else {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            //either rob this house or not
            //1. if robbing this house then we can also include max robbery till prev to prev house (i-2) 
            //2. if not robbing this house then we can include max robbery till prev house (i-1)
        }
    }

    return dp[nums.length - 1]
};