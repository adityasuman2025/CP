/*
https://leetcode.com/problems/maximal-rectangle/

85. Maximal Rectangle
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.


Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0

Example 3:
Input: matrix = [["1"]]
Output: 1
*/

var maximalRectangle = function(matrix) {
    let maxArea = maxInHistogram(matrix[0], matrix[0].length);

    for (let i = 1; i<matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 1)
                matrix[i][j] = parseInt(matrix[i-1][j]) + parseInt(matrix[i][j]);
        }

        let area = maxInHistogram(matrix[i], matrix[i].length);
        maxArea = Math.max(area, maxArea)
    }
    
    return maxArea;
};

function maxInHistogram(arr, length) {
    let area = 0;
    let maxArea = 0;
    
    let stack = [];
    
    let i = 0;
    while (i<length) {
        if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
            stack.push(i++)
        } else {
            let top = stack.pop();
            if (stack.isEmpty()) {
                area = arr[top] * i
            } else {
                area = arr[top] * ((i-1) - stack.peek());
            }
        
            maxArea = Math.max(area, maxArea);
        }
    }
    
    while (!stack.isEmpty()) {
        let top = stack.pop();
        if (stack.isEmpty()) {
            area = arr[top] * i
        } else {
            area = arr[top] * ((i-1) - stack.peek());
        }

        maxArea = Math.max(area, maxArea);
    }
    
    return maxArea;
}

Array.prototype.isEmpty = function() {
    return this.length == 0;
}

Array.prototype.peek = function() {
    return this[this.length-1];
}