/*
https://leetcode.com/problems/unique-paths/description/

62. Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
*/

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
    let memo = {};

    // let path = 0;
    function dfs(thisI, thisJ) {
        let thisKey = thisI + " " + thisJ;

        if ((thisI === m - 1) && (thisJ === n - 1)) {
            memo[thisKey] = 1;
            return 1;
        }

        let downPath = 0, rightPath = 0;
        // down
        if (thisI + 1 < m) {
            let keyD = (thisI + 1) + " " + (thisJ);
            downPath = memo.hasOwnProperty(keyD) ? memo[keyD] : dfs(thisI + 1, thisJ)
        }

        // right
        if (thisJ + 1 < n) {
            let keyR = (thisI) + " " + (thisJ + 1);
            rightPath = memo.hasOwnProperty(keyR) ? memo[keyR] : dfs(thisI, thisJ + 1)
        }

        memo[thisKey] = downPath + rightPath;
        return memo[thisKey];
    }
    dfs(0, 0);

    return memo["0 0"];
};