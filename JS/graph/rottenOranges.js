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


var orangesRotting = function(image) {
    let maxRIndex = image.length - 1;
    let maxCIndex = image[0].length - 1;

    let fresh = 0;
    let time = 0;
    let queue = [];
    for (let sr = 0; sr <= maxRIndex; sr++) {
        for (let sc = 0; sc <= maxCIndex; sc++) {
            if (image[sr][sc] == 1) fresh++;
            if (image[sr][sc] == 2) queue.push({ sr, sc });
        }
    }

    while (queue.length > 0 && fresh > 0) {
        let size = queue.length;
        while (size) {
            size--;

            const { sr, sc } = queue.shift();

            //top
            let topR = sr - 1, topC = sc;
            if (topR >= 0 && image[topR][topC] == 1) {
                fresh--;
                image[topR][topC] = 0;
                queue.push({ sr: topR, sc: topC });
            }

            //bottom
            let bottomR = sr + 1, bottomC = sc;
            if (bottomR <= maxRIndex && image[bottomR][bottomC] == 1) {
                fresh--;
                image[bottomR][bottomC] = 0;
                queue.push({ sr: bottomR, sc: bottomC });
            }

            //left
            let leftR = sr, leftC = sc - 1;
            if (leftC >= 0 && image[leftR][leftC] == 1) {
                fresh--;
                image[leftR][leftC] = 0;
                queue.push({ sr: leftR, sc: leftC });
            }

            //right
            let rightR = sr, rightC = sc + 1;
            if (rightC <= maxCIndex && image[rightR][rightC] == 1) {
                fresh--;
                image[rightR][rightC] = 0;
                queue.push({ sr: rightR, sc: rightC });
            }
        }

        time++;
    }

    return fresh == 0 ? time : -1;
};