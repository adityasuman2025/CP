/*
    https://leetcode.com/problems/combination-sum-iv/
*/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(arr, target) {
    const memo = new Map();

    function dfs(req) {
        if (req === 0) return 1;
        if (memo.has(req)) return memo.get(req);

        let count = 0;
        for (let i = 0; i < arr.length; i++) {
            const curr = arr[i];
            if (curr > req) continue;
            else count += dfs(req - curr);
        }
        memo.set(req, count)

        return count;
    }
    dfs(target)

    return memo.get(target);
};