/*
    https://leetcode.com/problems/combination-sum/
*/


/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(arr, target) {
    const ans = [];

    function dfs(req, start, items) {
        if (req === 0) {
            ans.push(items);
            return;
        }

        for (let i = start; i < arr.length; i++) {
            const curr = arr[i];
            if (curr > req) continue;
            else dfs(req - curr, i, [...items, curr]);
        }
    }
    dfs(target, 0, [])

    return ans;
};