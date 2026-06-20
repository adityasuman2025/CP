/*
https://leetcode.com/problems/jump-game/

55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/

/**
 * @param {number[]} nums
 * @return {boolean}
 */
// dfs (more intutive) // time: O(N^2)
var canJump = function(arr) {
    const end = arr.length - 1;

    const memo = {};
    function dfs(start) {
        if (start === end) {
            memo[start] = true;
            return true;
        }

        for (let j = Math.min(arr[start], end - start); j > 0; j--) {
            const key = start + j;

            if (!memo.hasOwnProperty(key)) memo[key] = dfs(key);
            if (memo[key]) return true;
        }

        memo[start] = false;
        return false;
    }
    return dfs(0);
};

// greedy // time: O(N)
var canJump = function(nums) {
    let max = 0;
    // keep checking maximum reach at each index, if an index is greater than max
    // it means this index is not reachable, hence last element can't be reached and return false
    for (let i = 0; i < nums.length; i++) {
        if (i > max) return false;
        if (max >= nums.length - 1) return true;
        max = Math.max(max, i + nums[i]);
    }
}

