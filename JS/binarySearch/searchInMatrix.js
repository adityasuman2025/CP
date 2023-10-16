/*
https://leetcode.com/problems/search-a-2d-matrix/description/

74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

*/

// time: O(log(m*n))
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let m = matrix.length, n = matrix[0].length;

    let startI = 0, endI = m - 1;
    while (startI <= endI) {
        let midI = parseInt((startI + endI) / 2);

        if (target >= matrix[midI][0] && target <= matrix[midI][n - 1]) {
            return binarySearch(matrix[midI], target, 0, n - 1);
        } else if (target < matrix[midI][0]) {
            endI = midI - 1;
        } else if (target > matrix[midI][n - 1]) {
            startI = midI + 1;
        }
    }

    return false;
};

function binarySearch(arr, target, start, end) {
    while (start <= end) {
        let mid = parseInt((start + end) / 2);

        if (arr[mid] === target) {
            return true;
        } else if (target > arr[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return false;
}