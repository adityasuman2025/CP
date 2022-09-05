/*
https://leetcode.com/problems/rectangle-overlap/

836. Rectangle Overlap
An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner, and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.

 

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:

Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false
*/

/**
 * @param {number[]} rec1
 * @param {number[]} rec2
 * @return {boolean}
 */
var isRectangleOverlap = function(rec1, rec2) {
    let rec1BLx = rec1[0];
    let rec1BLy = rec1[1];
    let rec1TRx = rec1[2];
    let rec1TRy = rec1[3];
    
    let rec2BLx = rec2[0];
    let rec2BLy = rec2[1];
    let rec2TRx = rec2[2];
    let rec2TRy = rec2[3];
    
    //if bottom-left x of one rectangle is greater than top-right x of other
    if ((rec2BLx >= rec1TRx) || (rec1BLx >= rec2TRx)) return false
    
    //if bottom-left y of one rectangle is greater than top-right y of other
    if ((rec2BLy >= rec1TRy) || (rec1BLy >= rec2TRy)) return false
    
    return true;
}