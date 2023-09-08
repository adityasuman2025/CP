/*
https://leetcode.com/problems/next-greater-element-ii/description/

503. Next Greater Element II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
*/


/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function (arr) {
    let stack = [], n = arr.length;

    let resp = [];
    for (let i = 2 * n - 1; i >= 0; i--) {
        let orgI = i % n;
        if (stack.length === 0) {
            stack.push(arr[orgI]);
        } else {
            // popping the elements from stack till element greater then arr[orgI] is found
            while (stack.length && stack.peek() <= arr[orgI]) {
                stack.pop();
            }

            if (i < n) {
                if (stack.length === 0) resp[i] = -1
                else resp[i] = stack.peek();
            }

            stack.push(arr[orgI]);
        }
    }


    return resp;
};

Array.prototype.peek = function () {
    return this[this.length - 1];
}