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


Array.prototype.isEmpty = function() {
    return this.length == 0;
}

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
*/
var floodFill = function(image, sr, sc, color) {
    let maxRIndex = image.length - 1;
    let maxCIndex = image[0].length - 1;

    let stack = [];
    if (image[sr][sc] != color) stack.push({ sr, sc });

    while (!stack.isEmpty()) {
        const { sr, sc } = stack.pop();
        let thisColor = image[sr][sc];

        //top
        let topR = sr - 1, topC = sc;
        if (topR >= 0 && image[topR][topC] != color && image[topR][topC] == thisColor) {
            stack.push({ sr: topR, sc: topC });
        }

        //bottom
        let bottomR = sr + 1, bottomC = sc;
        if (bottomR <= maxRIndex && image[bottomR][bottomC] != color && image[bottomR][bottomC] == thisColor) {
            stack.push({ sr: bottomR, sc: bottomC });
        }

        //left
        let leftR = sr, leftC = sc - 1;
        if (leftC >= 0 && image[leftR][leftC] != color && image[leftR][leftC] == thisColor) {
            stack.push({ sr: leftR, sc: leftC });
        }

        //right
        let rightR = sr, rightC = sc + 1;
        if (rightC <= maxCIndex && image[rightR][rightC] != color && image[rightR][rightC] == thisColor) {
            stack.push({ sr: rightR, sc: rightC });
        }

        image[sr][sc] = color; //setting the required color
    }

    return image;
};