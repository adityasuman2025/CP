/*
https://leetcode.com/problems/squares-of-a-sorted-array/

977. Squares of a Sorted Array
Easy

6232

162

Add to List

Share
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

*/

var sortedSquares = function(arr) {
    let result = [];
    let length = arr.length;
    
    for (let i = 0; i<length; i++) {
        arr[i] = (arr[i] * arr[i]);
    }
    
    
    let frontIndex = 0;
    let behindIndex = length - 1;
    for (let i = length - 1; i >= 0; i--) {
        result[i] = arr[frontIndex] > arr[behindIndex] ? arr[frontIndex++] : arr[behindIndex--];
    }
    
    return result;
};