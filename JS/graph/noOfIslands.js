/*
https://leetcode.com/problems/number-of-islands/description/

200. Number of Islands
Medium
21.2K
455
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

const DRCTN = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
];

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const m = grid.length, n = grid[0].length;

    let count = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === "1") {
                bfs(i, j);
                count++;
            }
        }
    }

    function bfs(i, j) {
        const q = [[i, j]];
        grid[i][j] = 0;

        let c = 0;
        while (c < q.length) {
            const [currI, currJ] = q[c];

            for (let k = 0; k < DRCTN.length; k++) {
                const nextI = currI + DRCTN[k][0], nextJ = currJ + DRCTN[k][1];

                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                    if (grid[nextI][nextJ] === "1") {
                        q.push([nextI, nextJ]);
                        grid[nextI][nextJ] = 0;
                    }
                }
            }

            c++;
        }
    }

    return count;
};