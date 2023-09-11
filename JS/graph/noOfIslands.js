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


/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    let m = grid.length, n = grid[0].length;

    let c = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === "1") {
                c++;
                let q = [[i, j]];
                grid[i][j] = 0;

                while (q.length) {
                    let [thisI, thisJ] = q.shift();

                    // top
                    let topI = thisI - 1;
                    if (topI >= 0) {
                        if ((grid[topI][thisJ] === "1")) {
                            grid[topI][thisJ] = 0;
                            q.push([topI, thisJ]);
                        }
                    }

                    // bottom
                    let bottomI = thisI + 1;
                    if (bottomI < m) {
                        if ((grid[bottomI][thisJ] === "1")) {
                            grid[bottomI][thisJ] = 0;
                            q.push([bottomI, thisJ]);
                        }
                    }

                    // left
                    let leftJ = thisJ - 1;
                    if (leftJ >= 0) {
                        if ((grid[thisI][leftJ] === "1")) {
                            grid[thisI][leftJ] = 0;
                            q.push([thisI, leftJ]);
                        }
                    }

                    // right
                    let rightJ = thisJ + 1;
                    if (rightJ < n) {
                        if ((grid[thisI][rightJ] === "1")) {
                            grid[thisI][rightJ] = 0;
                            q.push([thisI, rightJ]);
                        }
                    }
                }
            }
        }
    }

    return c;
};