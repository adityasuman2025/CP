/*
https://leetcode.com/problems/set-matrix-zeroes/description/

73. Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/


// space: O(mn)
var setZeroes = function(matrix) {
    let m = matrix.length, n = matrix[0].length;

    let arr = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 0) arr.push([i, j]);
        }
    }

    while (arr.length) {
        const [thisI, thisJ] = arr.pop();

        for (let i = 0; i < m; i++) {
            matrix[i][thisJ] = 0;
        }

        for (let j = 0; j < n; j++) {
            matrix[thisI][j] = 0;
        }
    }
};

// space: O(m+n)
var setZeroes = function(matrix) {
    const rowSet = new Set(), colSet = new Set()
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (!matrix[i][j]) {
                rowSet.add(i);
                colSet.add(j);
            };
        }
    }

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (rowSet.has(i) || colSet.has(j)) matrix[i][j] = 0
        }
    }
};


// space: O(1)
// we will use first column and first row of the matrix as marker, that if that row/column contains any 0
var setZeroes = function(matrix) {
    let m = matrix.length, n = matrix[0].length;

    // checking if first row has any 0
    let firstRowHasZero = false;
    for (let j = 0; j < n; j++) {
        if (matrix[0][j] === 0) {
            firstRowHasZero = true;
            break;
        }
    }

    // checking if first column has any 0
    let firstColHasZero = false;
    for (let i = 0; i < m; i++) {
        if (matrix[i][0] === 0) {
            firstColHasZero = true;
            break;
        }
    }

    // if that row/column has any 0 then setting the marker in first row/column of the matrix
    // first row/column is used as merker so starting from 2nd row/column, i.e. index 1
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (matrix[i][j] === 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // if 0 is found in marker (i.e. first row/column of the matrix) then setting 0 in that cell 
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (matrix[i][0] === 0 || matrix[0][j] === 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // if 0 was there in first row, then setting all cells of first row 0
    if (firstRowHasZero) {
        for (let j = 0; j < n; j++) {
            matrix[0][j] = 0
        }
    }

    // if 0 was there in first column, then setting all cells of first column 0
    if (firstColHasZero) {
        for (let i = 0; i < m; i++) {
            matrix[i][0] = 0
        }
    }
};