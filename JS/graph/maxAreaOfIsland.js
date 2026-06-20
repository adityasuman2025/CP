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
var maxAreaOfIsland = function(grid) {
    const m = grid.length, n = grid[0].length;

    let maxArea = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                const area = bfs(i, j);
                maxArea = Math.max(area, maxArea)
            }
        }
    }

    function bfs(i, j) {
        const q = [[i, j]];
        grid[i][j] = 0;

        let c = 0;
        while (c < q.length) {
            const [currI, currJ] = q[c];

            DRCTN.forEach(([cI, cJ]) => {
                const nextI = currI + cI, nextJ = currJ + cJ;
                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                    if (grid[nextI][nextJ] === 1) {
                        grid[nextI][nextJ] = 0;
                        q.push([nextI, nextJ])
                    }
                }
            });

            c++;
        }

        return c;
    }

    return maxArea;
};