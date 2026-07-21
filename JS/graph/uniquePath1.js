/*
    https://leetcode.com/problems/unique-paths/
*/

const DRCTN = [
    [1, 0],
    [0, 1],
]

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    const memo = new Map();

    function dfs(i, j) {
        if (i === m - 1 && j === n - 1) return 1;

        const path = i + "_" + j;
        if (memo.has(path)) return memo.get(path);

        let count = 0;
        for (let k = 0; k < DRCTN.length; k++) {
            const [iC, jC] = DRCTN[k];
            const iN = i + iC, jN = j + jC;
            if (iN < m && jN < n) count += dfs(iN, jN)
        }
        memo.set(path, count);

        return count;
    }
    return dfs(0, 0);
};