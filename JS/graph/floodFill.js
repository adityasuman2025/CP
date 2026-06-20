/*
https://leetcode.com/problems/flood-fill/

Flood Fill
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

 

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
*/

const DRCTN = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
];

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function(image, si, sj, color) {
    const m = image.length, n = image[0].length;

    if (image[si][sj] === color) return image;

    const org = image[si][sj];

    const q = [[si, sj]];
    image[si][sj] = color;

    let c = 0;
    while (c < q.length) {
        const [currI, currJ] = q[c];

        for (let i = 0; i < DRCTN.length; i++) {
            const nextI = currI + DRCTN[i][0], nextJ = currJ + DRCTN[i][1];

            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                if (image[nextI][nextJ] === org) {
                    q.push([nextI, nextJ]);
                    image[nextI][nextJ] = color;
                }
            }
        }

        c++;
    }

    return image;
};