/*
https://leetcode.com/problems/max-area-of-island

695. Max Area of Island
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

*/


/**
 * @param {number[][]} grid
 * @return {number}
 */

var maxAreaOfIsland = function (grid) {
    let m = grid.length, n = grid[0].length;

    let maxArea = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                let q = [[i, j]];
                grid[i][j] = 0;

                let area = 0;
                while (q.length) {
                    area++;
                    maxArea = Math.max(maxArea, area);

                    let [thisI, thisJ] = q.shift();

                    // top
                    let topI = thisI - 1;
                    if (topI >= 0) {
                        if ((grid[topI][thisJ] === 1)) {
                            grid[topI][thisJ] = 0;
                            q.push([topI, thisJ]);
                        }
                    }

                    // bottom
                    let bottomI = thisI + 1;
                    if (bottomI < m) {
                        if ((grid[bottomI][thisJ] === 1)) {
                            grid[bottomI][thisJ] = 0;
                            q.push([bottomI, thisJ]);
                        }
                    }

                    // left
                    let leftJ = thisJ - 1;
                    if (leftJ >= 0) {
                        if ((grid[thisI][leftJ] === 1)) {
                            grid[thisI][leftJ] = 0;
                            q.push([thisI, leftJ]);
                        }
                    }

                    // right
                    let rightJ = thisJ + 1;
                    if (rightJ < n) {
                        if ((grid[thisI][rightJ] === 1)) {
                            grid[thisI][rightJ] = 0;
                            q.push([thisI, rightJ]);
                        }
                    }
                }
            }
        }
    }

    return maxArea;
};