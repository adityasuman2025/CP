/*
https://leetcode.com/problems/jump-game-ii/description

45. Jump Game II
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
*/


// time: O(N^2), space: O(N)
var jump = function (arr) {
    start = 0, target = arr.length - 1;

    let memo = new Map();
    function dfs(start) {
        if (start === target) return 0;

        if (memo.has(start)) return memo.get(start);

        let min = Number.MAX_SAFE_INTEGER;
        for (let i = 1; i <= arr[start]; i++) {
            if (start + i <= target) {
                let jumps = dfs(start + i);
                min = Math.min(min, jumps + 1);
            }
        }

        memo.set(start, min);
        return min;
    }
    return dfs(start);
};


// ref: https://www.youtube.com/watch?v=8gO-3ya1ptM
// time: O(N), space: O(1)
var jump = function (arr) {
    arr[0] = 0 + arr[0];
    for (let i = 1; i < arr.length; i++) {
        arr[i] = Math.max(arr[i - 1], arr[i] + i);
    }

    let jumps = 0;
    let start = 0, target = arr.length - 1;
    while ((start < target) && ![null, undefined].includes(start)) {
        start = arr[start];
        jumps++;;
    }

    return jumps;
};
