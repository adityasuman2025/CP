/*
    https://leetcode.com/problems/combination-sum-ii/description/
*/


/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(arr, target) {
    arr.sort((a, b) => a - b);

    const ans = [];
    function dfs(req, start, items) {
        if (req === 0) {
            ans.push(items);
            return;
        }

        for (let i = start; i < arr.length; i++) {
            const curr = arr[i];
            if (curr > req) continue;
            else if (i !== start && arr[i] === arr[i - 1]) continue; // to avoid duplicates
            else dfs(req - curr, i + 1, [...items, curr])
        }
    }
    dfs(target, 0, []);

    return ans;
};