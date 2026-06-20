/*
https://leetcode.com/problems/rotting-oranges/

994. Rotting Oranges
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
*/

const DRCTN = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
];

/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function(grid) {
    const m = grid.length, n = grid[0].length;

    let freshCount = 0;
    const q = [];
    grid.forEach((row, rowIdx) => {
        row.forEach((col, colIdx) => {
            if (grid[rowIdx][colIdx] === 1) freshCount++
            if (grid[rowIdx][colIdx] === 2) q.push([rowIdx, colIdx, 0]);
        })
    });

    if (q.length === 0) return freshCount ? -1 : 0;

    let c = 0;
    while (c < q.length) {
        const [currI, currJ, depth] = q[c];

        for (let i = 0; i < DRCTN.length; i++) {
            const nextI = currI + DRCTN[i][0], nextJ = currJ + DRCTN[i][1];

            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                if (grid[nextI][nextJ] === 1) {
                    q.push([nextI, nextJ, depth + 1]);
                    grid[nextI][nextJ] = 2;
                    freshCount--;
                }
            }
        }

        c++;
    }

    return freshCount === 0 ? q.at(-1)[2] : -1;
};